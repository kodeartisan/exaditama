package com.exaditama.testapp.di.module;

import android.app.Activity;

import com.exaditama.testapp.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kodeartisan on 28/12/17.
 */

@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityScope
    public Activity provideActivity() {
        return mActivity;
    }
}

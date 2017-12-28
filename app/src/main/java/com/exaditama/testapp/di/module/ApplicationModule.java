package com.exaditama.testapp.di.module;

import android.content.Context;

import com.exaditama.testapp.rx.scheduler.BaseSchedulerProvider;
import com.exaditama.testapp.rx.scheduler.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kodeartisan on 28/12/17.
 */

@Module
public class ApplicationModule {

    private Context mContext;

    public ApplicationModule(Context context) {
        this.mContext = context;
    }

    @Provides
    public Context provideContext() {
        return mContext;
    }

    @Singleton
    @Provides
    BaseSchedulerProvider provideSchedulers() {
        return new SchedulerProvider();
    }
}

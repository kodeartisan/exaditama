package com.exaditama.testapp.di.module;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.exaditama.testapp.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kodeartisan on 28/12/17.
 */

@Module
public class FragmentModule {

    private Fragment mFragment;

    public FragmentModule(Fragment fragment) {
        this.mFragment = fragment;
    }

    @Provides
    @FragmentScope
    public Activity provideActivity() {
        return mFragment.getActivity();
    }
}

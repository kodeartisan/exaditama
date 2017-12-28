package com.exaditama.testapp.di.module;

import com.exaditama.testapp.di.scope.ActivityScope;
import com.exaditama.testapp.di.scope.FragmentScope;
import com.exaditama.testapp.ui.home.fragment.home.HomeFragmentContract;
import com.exaditama.testapp.ui.home.fragment.home.HomeFragmentPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kodeartisan on 28/12/17.
 */

@Module
public class PresenterModule {

    @FragmentScope
    @Provides
    HomeFragmentContract.Presenter  homeFragmentPresenter() {
        return new HomeFragmentPresenter();
    }


}

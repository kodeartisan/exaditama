package com.exaditama.testapp.di.component;

import com.exaditama.testapp.di.module.FragmentModule;
import com.exaditama.testapp.di.module.PresenterModule;
import com.exaditama.testapp.di.scope.FragmentScope;
import com.exaditama.testapp.ui.home.fragment.home.HomeFragment;

import dagger.Component;

/**
 * Created by kodeartisan on 28/12/17.
 */

@FragmentScope
@Component(dependencies = ApplicationComponent.class, modules = {FragmentModule.class, PresenterModule.class})
public interface FragmentComponent {

    void inject(HomeFragment homeFragment);
}

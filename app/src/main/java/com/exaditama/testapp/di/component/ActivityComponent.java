package com.exaditama.testapp.di.component;

import com.exaditama.testapp.di.module.PresenterModule;
import com.exaditama.testapp.di.scope.ActivityScope;
import com.exaditama.testapp.ui.home.HomeActivity;
import com.exaditama.testapp.ui.splash.SplashActivity;

import dagger.Component;

/**
 * Created by kodeartisan on 28/12/17.
 */

@ActivityScope
@Component(dependencies = ApplicationComponent.class, modules = PresenterModule.class)
public interface ActivityComponent {

    void inject(SplashActivity activity);
    void inject(HomeActivity activity);
}

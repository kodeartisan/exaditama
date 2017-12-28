package com.exaditama.testapp.di.component;

import com.exaditama.testapp.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by kodeartisan on 28/12/17.
 */

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {


}

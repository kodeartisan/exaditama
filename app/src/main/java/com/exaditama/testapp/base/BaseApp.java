package com.exaditama.testapp.base;

import android.app.Application;

import com.exaditama.testapp.di.component.ApplicationComponent;
import com.exaditama.testapp.di.component.DaggerApplicationComponent;
import com.exaditama.testapp.di.module.ApplicationModule;

/**
 * Created by kodeartisan on 28/12/17.
 */

public class BaseApp extends Application {

    public static final String TAG = BaseApp.class.getSimpleName();

    public static ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeComponent();
    }

    private void initializeComponent() {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .build();
    }



    public static ApplicationComponent getAppComponent() {
        return mApplicationComponent;
    }
}

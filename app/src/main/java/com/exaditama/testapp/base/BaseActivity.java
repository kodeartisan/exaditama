package com.exaditama.testapp.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.exaditama.testapp.di.component.ActivityComponent;
import com.exaditama.testapp.di.component.DaggerActivityComponent;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by kodeartisan on 28/12/17.
 */

public abstract class BaseActivity extends AppCompatActivity{

    public static final String TAG = BaseActivity.class.getSimpleName();

    protected Unbinder unbinder;

    protected abstract @LayoutRes
    int getLayoutId();

    protected void injectDependencies(){}
    protected void initWidget(){}
    protected void initVariables(Bundle savedInstanceState){}
    protected void initListener(){}


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependencies();
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);
        initVariables(savedInstanceState);
        initWidget();
        initListener();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(unbinder != null) unbinder.unbind();


    }

    protected ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder().applicationComponent(BaseApp.mApplicationComponent)
                .build();
    }









}

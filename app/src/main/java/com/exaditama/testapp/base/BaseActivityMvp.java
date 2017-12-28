package com.exaditama.testapp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;


import com.exaditama.testapp.di.component.ActivityComponent;
import com.exaditama.testapp.di.component.DaggerActivityComponent;

import javax.inject.Inject;

/**
 * Created by kodeartisan on 28/12/17.
 */

public abstract class BaseActivityMvp<T extends BaseContract.BasePresenter> extends BaseActivity {

    @Inject
    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) mPresenter.detachView();
    }



}
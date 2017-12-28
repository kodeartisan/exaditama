package com.exaditama.testapp.base;

import javax.inject.Inject;

/**
 * Created by kodeartisan on 28/12/17.
 */

public abstract class BaseFragmentMvp<T extends BaseContract.BasePresenter> extends BaseFragment implements BaseContract.BaseView {

    @Inject
    protected T mPresenter;

    @Override
    protected void initPresenter() {
        super.initPresenter();
        mPresenter.attachView(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (mPresenter != null) mPresenter.detachView();
    }
}

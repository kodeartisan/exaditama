package com.exaditama.testapp.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.exaditama.testapp.di.component.DaggerFragmentComponent;
import com.exaditama.testapp.di.component.FragmentComponent;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by kodeartisan on 28/12/17.
 */

public abstract class BaseFragment extends Fragment {


    private Unbinder mUnbinder;
    protected View mRootView;
    protected LayoutInflater mInflater;
    protected AppCompatActivity mActivity;
    protected void injectDependencies(){}
    protected void initWidget(){}
    protected void initVariables(Bundle savedInstanceState){}
    protected void initListener(){}
    protected void initPresenter(){}

    public abstract
    @LayoutRes
    int getLayoutId();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUnbinder = ButterKnife.bind(this, view);
        injectDependencies();
        initPresenter();
        initVariables(savedInstanceState);
        initWidget();
        initListener();
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mRootView = inflater.inflate(getLayoutId(), container, false);
        mInflater = inflater;
        mActivity = (AppCompatActivity) getActivity();

        return mRootView;
    }

    protected FragmentComponent getFragmentComponent() {
        return DaggerFragmentComponent.builder()
                .applicationComponent(BaseApp.getAppComponent())
                .build();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mUnbinder!=null){
            mUnbinder.unbind();
        }
    }
}

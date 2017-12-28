package com.exaditama.testapp.base;

/**
 * Created by kodeartisan on 28/12/17.
 */

public interface BaseContract {

    interface BaseView {

        void showError(String msg);

        void complete();


    }

    interface BasePresenter<T>  {


        void attachView(T view);


        void detachView();
    }

}

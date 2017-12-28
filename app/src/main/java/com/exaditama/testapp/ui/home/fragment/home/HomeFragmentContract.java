package com.exaditama.testapp.ui.home.fragment.home;

import com.exaditama.testapp.base.BaseContract;
import com.exaditama.testapp.model.DataHorizontal;
import com.exaditama.testapp.model.DataVertical;

import java.util.List;

/**
 * Created by kodeartisan on 28/12/17.
 */

public interface HomeFragmentContract {

    interface View extends BaseContract.BaseView {
        void onGetDataHorizontal(List<DataHorizontal> dataHorizontalList);
        void onGetDataVertical(List<DataVertical> dataVerticalList);

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void getDataHorizontal();
        void getDataVertical();
    }
}

package com.exaditama.testapp.ui.home.fragment.home;

import com.exaditama.testapp.model.DataHorizontal;
import com.exaditama.testapp.model.DataVertical;
import com.exaditama.testapp.rx.RxPresenter;

import java.util.ArrayList;
import java.util.List;
import java.util.SimpleTimeZone;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by kodeartisan on 28/12/17.
 */

public class HomeFragmentPresenter extends RxPresenter<HomeFragmentContract.View> implements HomeFragmentContract.Presenter<HomeFragmentContract.View> {

    public static final String TAG = HomeFragmentPresenter.class.getSimpleName();


    @Override
    public void getDataHorizontal() {
        addSubscribe( Observable.create((ObservableEmitter<List<DataHorizontal>> emitter) -> {
            List<DataHorizontal> mData = new ArrayList<>();
            mData.add(new DataHorizontal("Reward 1", "profile/style-17/Profile-17-post4.jpg", "Lorem Ipsum Lur D", "November 2017"));
            mData.add(new DataHorizontal("Reward 2", "profile/style-17/Profile-17-post4.jpg", "Lorem Ipsum Lur D", "November 2017"));
            mData.add(new DataHorizontal("Reward 3", "profile/style-17/Profile-17-post5.jpg", "Lorem Ipsum Lur D", "November 2017"));
            mData.add(new DataHorizontal("Reward 4", "profile/style-17/Profile-17-post3.jpg", "Lorem Ipsum Lur D", "November 2017"));

            emitter.onNext(mData);
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::processDataHorizontal, this::processErrorDataHorizontal));



    }

    @Override
    public void getDataVertical() {
        addSubscribe( Observable.create((ObservableEmitter<List<DataVertical>> emitter) -> {
            List<DataVertical> mData = new ArrayList<>();
            mData.add(new DataVertical("Citywalks", "gallery/style-9/Gallery-9-img-2.png", "Lorem Ipsum Lur D", "November 2017"));
            mData.add(new DataVertical("Mountain", "gallery/style-9/Gallery-9-img-4.png", "Lorem Ipsum Lur D", "November 2017"));
            mData.add(new DataVertical("Nature", "gallery/style-9/Gallery-9-img-3.png", "Lorem Ipsum Lur D", "November 2017"));
            mData.add(new DataVertical("Urban Skyscrapers", "gallery/style-9/Gallery-9-img-1.png", "Lorem Ipsum Lur D", "November 2017"));

            emitter.onNext(mData);
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::processDataVertical, this::processErrorDataVertical));
    }

    private void processDataHorizontal(List<DataHorizontal> dataHorizontalList) {
        mView.onGetDataHorizontal(dataHorizontalList);
    }

    private void processErrorDataHorizontal(Throwable throwable) {
    }

    private void processDataVertical(List<DataVertical> dataVerticalList) {
        mView.onGetDataVertical(dataVerticalList);
    }

    private void processErrorDataVertical(Throwable throwable) {

    }


}

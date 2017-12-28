package com.exaditama.testapp.ui.home.fragment.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.exaditama.testapp.R;
import com.exaditama.testapp.base.BaseFragment;
import com.exaditama.testapp.base.BaseFragmentMvp;
import com.exaditama.testapp.model.DataHorizontal;
import com.exaditama.testapp.model.DataVertical;
import com.exaditama.testapp.ui.adapter.HorizontalAdapter;
import com.exaditama.testapp.ui.adapter.VerticalAdapter;
import com.exaditama.testapp.ui.home.fragment.favorite.FavoriteFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by kodeartisan on 28/12/17.
 */

public class HomeFragment extends BaseFragmentMvp<HomeFragmentContract.Presenter> implements HomeFragmentContract.View {

    public static final String NAME = HomeFragment.class.getSimpleName();
    public static final String TAG = HomeFragment.class.getSimpleName();

    private List<DataHorizontal> mHorizontalList = new ArrayList<>();
    private List<DataVertical> mVerticalList = new ArrayList<>();

    private HorizontalAdapter mHorizontalAdapter;
    private VerticalAdapter mVerticalAdapter;

    @BindView(R.id.recyclerview_horizontal)
    protected RecyclerView mRecyclerviewHorizontal;

    @BindView(R.id.recyclerview_vertical)
    protected RecyclerView mRecyclerviewVertical;

    @BindView(R.id.imageMain)
    protected ImageView mImageMain;

    @Override
    protected void initPresenter() {
        super.initPresenter();
    }

    @BindView(R.id.toolbar)
    protected Toolbar mToolbar;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void injectDependencies() {
        super.injectDependencies();
        getFragmentComponent().inject(this);
    }

    @Override
    protected void initWidget() {
        super.initWidget();
        initRecyclerview();
    }

    @Override
    protected void initVariables(Bundle savedInstanceState) {
        super.initVariables(savedInstanceState);
        setRetainInstance(true);
        mActivity.setSupportActionBar(mToolbar);
        mActivity.setTitle("");

        mHorizontalAdapter = new HorizontalAdapter(getActivity());
        mVerticalAdapter = new VerticalAdapter(getActivity());

        mPresenter.getDataVertical();
        mPresenter.getDataHorizontal();

        Glide.with(this).load(R.drawable.chocolate).into(mImageMain);



    }

    @Override
    protected void initListener() {
        super.initListener();
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void complete() {

    }

    @Override
    public void onGetDataHorizontal(List<DataHorizontal> dataHorizontalList) {
        mHorizontalList.clear();
        mHorizontalList.addAll(dataHorizontalList);
        mHorizontalAdapter.setData(mHorizontalList);
    }

    @Override
    public void onGetDataVertical(List<DataVertical> dataVerticalList) {
        mVerticalList.clear();
        mVerticalList.addAll(dataVerticalList);
        mVerticalAdapter.setData(dataVerticalList);

    }

    private void initRecyclerview() {


        mRecyclerviewHorizontal.setAdapter(mHorizontalAdapter);
        mRecyclerviewHorizontal.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        mRecyclerviewHorizontal.setHasFixedSize(true);

        mRecyclerviewVertical.setAdapter(mVerticalAdapter);
        mRecyclerviewVertical.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mRecyclerviewVertical.setHasFixedSize(true);
    }
}

package com.exaditama.testapp.ui.home;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.exaditama.testapp.R;
import com.exaditama.testapp.base.BaseActivity;
import com.exaditama.testapp.ui.home.fragment.favorite.FavoriteFragment;
import com.exaditama.testapp.ui.home.fragment.home.HomeFragment;
import com.exaditama.testapp.ui.home.fragment.profile.ProfileFragment;

import butterknife.BindView;

public class HomeActivity extends BaseActivity {

    public static final String TAG = HomeActivity.class.getSimpleName();

    private Fragment mCurrentFragment;

    @BindView(R.id.bottom_nav)
    protected BottomNavigationView mBottomNav;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void injectDependencies() {
        super.injectDependencies();
        getActivityComponent().inject(this);

    }

    @Override
    protected void initWidget() {
        super.initWidget();
    }

    @Override
    protected void initVariables(Bundle savedInstanceState) {
        super.initVariables(savedInstanceState);
        addFragment(HomeFragment.newInstance(), HomeFragment.NAME);
    }

    @Override
    protected void initListener() {
        super.initListener();
        mBottomNav.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.action_home:
                    if(!mCurrentFragment.getTag().equals(HomeFragment.NAME)) {
                         changeFragment(HomeFragment.newInstance(), HomeFragment.NAME);
                    }

                    break;
                case R.id.action_favorite:
                    if(!mCurrentFragment.getTag().equals(FavoriteFragment.NAME)) {
                        changeFragment(FavoriteFragment.newInstance(), FavoriteFragment.NAME);
                    }
                    break;
                case R.id.action_profile:
                    if(!mCurrentFragment.getTag().equals(ProfileFragment.NAME)) {
                        changeFragment(ProfileFragment.newInstance(), ProfileFragment.NAME);
                    }
                    break;
            }
            return true;
        });
    }

    private void addFragment(Fragment fragment, String name) {
        mCurrentFragment = fragment;
        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(R.id.fragment_container, fragment, name);
        ft.commit();


    }

    private void changeFragment(Fragment fragment, String name) {
        mCurrentFragment = fragment;
        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.fragment_container, fragment, name);
        ft.commit();


    }
}

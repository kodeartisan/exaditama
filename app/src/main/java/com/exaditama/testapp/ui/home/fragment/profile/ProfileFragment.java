package com.exaditama.testapp.ui.home.fragment.profile;

import com.exaditama.testapp.R;
import com.exaditama.testapp.base.BaseFragment;
import com.exaditama.testapp.ui.home.fragment.home.HomeFragment;

/**
 * Created by kodeartisan on 28/12/17.
 */

public class ProfileFragment extends BaseFragment {

    public static final String NAME = ProfileFragment.class.getSimpleName();
    public static final String TAG = ProfileFragment.class.getSimpleName();

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_profile;
    }
}

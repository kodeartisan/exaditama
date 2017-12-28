package com.exaditama.testapp.ui.home.fragment.favorite;

import com.exaditama.testapp.R;
import com.exaditama.testapp.base.BaseFragment;

/**
 * Created by kodeartisan on 28/12/17.
 */

public class FavoriteFragment extends BaseFragment {

    public static final String NAME = FavoriteFragment.class.getSimpleName();

    public static FavoriteFragment newInstance() {
        return new FavoriteFragment();
    }
    @Override
    public int getLayoutId() {
        return R.layout.fragment_favorite;
    }
}

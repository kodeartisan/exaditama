package com.exaditama.testapp.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import com.exaditama.testapp.R;
import com.exaditama.testapp.base.BaseActivity;
import com.exaditama.testapp.ui.home.HomeActivity;

import butterknife.BindView;

public class SplashActivity extends BaseActivity {

    private Animation splashAnimation;

    @BindView(R.id.layout_container)
    protected RelativeLayout mLayoutContainer;

    @Override
    protected int getLayoutId() { return R.layout.activity_splash; }

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
        splashAnimation = AnimationUtils.loadAnimation(this, R.anim.splash);
        splashAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mLayoutContainer.startAnimation(splashAnimation);

    }

    @Override
    protected void initListener() {
        super.initListener();

    }
}

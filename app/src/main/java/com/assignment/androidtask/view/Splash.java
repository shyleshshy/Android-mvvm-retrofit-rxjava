package com.assignment.androidtask.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.assignment.androidtask.BR;
import com.assignment.androidtask.callbacks.SplashCallback;
import com.assignment.androidtask.R;
import com.assignment.androidtask.databinding.ActivitySplashBinding;
import com.assignment.androidtask.model.SplashViewModel;
import com.assignment.androidtask.view.base.BaseActivity;

public class Splash extends BaseActivity<ActivitySplashBinding, SplashViewModel> implements SplashCallback {

    private SplashViewModel mSplashViewModel;

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public SplashViewModel getViewModel() {
        mSplashViewModel = new SplashViewModel();
        return mSplashViewModel;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSplashViewModel.setCallbacks(this);
        mSplashViewModel.decideNextActivity();
    }

    @Override
    public void openLoginActivity() {
        Intent intent = new Intent();
        intent.setClass(Splash.this, Login.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void openMainActivity() {
        Intent intent = new Intent();
        intent.setClass(Splash.this, MainPage.class);
        startActivity(intent);
        finish();
    }
}

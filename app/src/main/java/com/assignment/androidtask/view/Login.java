package com.assignment.androidtask.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.assignment.androidtask.BR;
import com.assignment.androidtask.callbacks.LoginCallbacks;
import com.assignment.androidtask.R;
import com.assignment.androidtask.databinding.ActivityLoginBinding;
import com.assignment.androidtask.model.LoginViewModel;
import com.assignment.androidtask.view.base.BaseActivity;

public class Login extends BaseActivity<ActivityLoginBinding, LoginViewModel> implements LoginCallbacks {

    private LoginViewModel mLoginViewModel;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public LoginViewModel getViewModel() {
        mLoginViewModel = new LoginViewModel();
        return mLoginViewModel;
    }

    @Override
    public int getBindingVariable() {
        return BR.loginModel;
    }

    @Override
    public void login() {
        mLoginViewModel.isEmailAndPasswordValid(getViewDataBinding().etEmail.getText().toString(), getViewDataBinding().etPassword.getText().toString());
    }

    @Override
    public void openMainActivity() {
        Intent intent = new Intent();
        intent.setClass(this,MainPage.class);
        startActivity(intent);
    }

    @Override
    public void loginError(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLoginViewModel.setCallbacks(this);
    }
}

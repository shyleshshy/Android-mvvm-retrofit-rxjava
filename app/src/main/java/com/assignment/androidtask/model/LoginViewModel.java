package com.assignment.androidtask.model;

import android.text.TextUtils;
import android.util.Patterns;

import com.assignment.androidtask.App;
import com.assignment.androidtask.callbacks.LoginCallbacks;
import com.assignment.androidtask.Constants;
import com.assignment.androidtask.view.base.BaseViewModel;

public class LoginViewModel extends BaseViewModel<LoginCallbacks> {

    public void onLoginClick() {
        getCallbacks().login();
    }

    public void isEmailAndPasswordValid(String email, String password) {
        // validate email and password
        if (TextUtils.isEmpty(email)) {
            getCallbacks().loginError("Please enter your Email id");
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            getCallbacks().loginError("Please enter a valid Email id");
            return;
        }
        if (TextUtils.isEmpty(password)) {
            getCallbacks().loginError("Please enter a valid password");
            return;
        }
        setIsLoading(true);
        App.getPref().setCurrentUserLoggedInMode(Constants.LoggedInMode.LOGGED_IN_MODE_LOGGED_IN);
        getCallbacks().openMainActivity();
    }
}

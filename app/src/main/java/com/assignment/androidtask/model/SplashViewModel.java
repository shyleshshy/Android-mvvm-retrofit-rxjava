package com.assignment.androidtask.model;

import com.assignment.androidtask.App;
import com.assignment.androidtask.callbacks.SplashCallback;
import com.assignment.androidtask.Constants;
import com.assignment.androidtask.view.base.BaseViewModel;

public class SplashViewModel extends BaseViewModel<SplashCallback> {

    /**
     * Checks weather user is logged in or not and navigates the app to appropriate screen
     * */
    public void decideNextActivity() {
        setIsLoading(true);
        if (App.getPref().getCurrentUserLoggedInMode() == Constants.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.getType()) {
            getCallbacks().openLoginActivity();
        } else {
            getCallbacks().openMainActivity();
        }
    }

}

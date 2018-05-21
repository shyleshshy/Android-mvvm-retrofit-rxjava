package com.assignment.androidtask.model;

import android.text.TextUtils;
import android.util.Patterns;

import com.assignment.androidtask.App;
import com.assignment.androidtask.Constants;
import com.assignment.androidtask.callbacks.LoginCallbacks;
import com.assignment.androidtask.model.api.LoginResponse;
import com.assignment.androidtask.model.api.ValidateRequest;
import com.assignment.androidtask.view.base.BaseViewModel;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class LoginViewModel extends BaseViewModel<LoginCallbacks> {

    public void onLoginClick() {
        getCallbacks().login();
    }

    /*
    * validates username and password
    * */
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
        login(email, password);
    }

    /*
    * Hits login API
    * */
    private void login(String email, String password) {
        ValidateRequest validateRequest = new ValidateRequest();
        validateRequest.setEmail(email);
        validateRequest.setPassword(password);
        setIsLoading(true);
        getCompositeDisposable().add(App.getApiService().login(validateRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<LoginResponse>() {
                    @Override
                    public void onSuccess(LoginResponse value) {
                        if (value.getStatus().getCode() == 200) {
                            App.getPref().setCurrentUserLoggedInMode(Constants.LoggedInMode.LOGGED_IN_MODE_LOGGED_IN);
                            getCallbacks().openMainActivity();
                        } else if (value.getStatus().getCode() == 207) {
                            getCallbacks().loginError(value.getStatus().getMessage());
                        }
                        setIsLoading(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        setIsLoading(false);
                        String message = "Error occurred, please try again later";
                        getCallbacks().loginError(message);
                    }
                }));

        setIsLoading(true);
    }
}

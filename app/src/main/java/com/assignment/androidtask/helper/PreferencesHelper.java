package com.assignment.androidtask.helper;


import com.assignment.androidtask.Constants;

public interface PreferencesHelper {

    String getCurrentUserEmail();

    void setCurrentUserEmail(String email);

    Long getCurrentUserId();

    void setCurrentUserId(Long userId);

    int getCurrentUserLoggedInMode();

    void setCurrentUserLoggedInMode(Constants.LoggedInMode mode);

    String getCurrentUserName();

    void setCurrentUserName(String userName);

}

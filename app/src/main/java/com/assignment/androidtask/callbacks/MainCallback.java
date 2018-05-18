package com.assignment.androidtask.callbacks;

import com.assignment.androidtask.model.api.ResponseDummy;

import java.util.List;

public interface MainCallback {

    void getUpdates(List<ResponseDummy> value);

}

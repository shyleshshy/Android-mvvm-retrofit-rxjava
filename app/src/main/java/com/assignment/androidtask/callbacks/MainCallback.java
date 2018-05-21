package com.assignment.androidtask.callbacks;

import com.assignment.androidtask.model.api.ItemsBean;

import java.util.List;

public interface MainCallback {

    void getUpdates(List<ItemsBean> value);

    void clearList();
}

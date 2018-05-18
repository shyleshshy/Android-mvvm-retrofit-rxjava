package com.assignment.androidtask.model;

import com.assignment.androidtask.model.api.ResponseDummy;
import com.assignment.androidtask.view.base.BaseViewModel;

public class ItemMainModel extends BaseViewModel {

    public String title;
    public String desc;

    private ResponseDummy dummy;

    public ItemMainModel(ResponseDummy obj) {
        dummy = obj;
        this.title = obj.getEmail();
        this.desc = obj.getBody();
    }
}

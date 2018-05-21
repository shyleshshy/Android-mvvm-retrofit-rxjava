package com.assignment.androidtask.model;

import com.assignment.androidtask.model.api.ItemsBean;
import com.assignment.androidtask.view.base.BaseViewModel;

public class ItemMainModel extends BaseViewModel {

    public String title;
    public String desc;
    public String id;

    private ItemsBean item;

    public ItemMainModel(ItemsBean obj) {
        item = obj;
        this.title = obj.getName();
        this.desc = String.valueOf(obj.getPrice());
        this.id = obj.getItem_code();
    }
}

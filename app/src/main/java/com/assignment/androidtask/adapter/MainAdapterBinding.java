package com.assignment.androidtask.adapter;

import android.databinding.BindingAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.assignment.androidtask.model.api.ItemsBean;

import java.util.List;

public final class MainAdapterBinding {

    private MainAdapterBinding() {
    }

    @BindingAdapter({"setItemsRv"})
    public static void addItems(RecyclerView rvMain, List<ItemsBean> objs) {
        MainAdapter mainAdapter = (MainAdapter) rvMain.getAdapter();
        RecyclerView.LayoutManager layoutManager = rvMain.getLayoutManager();
        if (layoutManager == null) {
            rvMain.setLayoutManager(new LinearLayoutManager(rvMain.getContext()));
        }
        if (mainAdapter == null) {
            mainAdapter = new MainAdapter(objs);
            rvMain.setAdapter(mainAdapter);
        }
    }
}

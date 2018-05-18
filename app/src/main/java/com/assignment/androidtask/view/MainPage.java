package com.assignment.androidtask.view;

import android.os.Bundle;

import com.assignment.androidtask.BR;
import com.assignment.androidtask.R;
import com.assignment.androidtask.adapter.MainAdapter;
import com.assignment.androidtask.callbacks.MainCallback;
import com.assignment.androidtask.databinding.ActivityMainPageBinding;
import com.assignment.androidtask.model.MainViewModel;
import com.assignment.androidtask.model.api.ResponseDummy;
import com.assignment.androidtask.view.base.BaseActivity;

import java.util.List;

public class MainPage extends BaseActivity<ActivityMainPageBinding, MainViewModel> implements MainCallback{

    private MainViewModel mMainViewModel;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main_page;
    }

    @Override
    public MainViewModel getViewModel() {
        mMainViewModel = new MainViewModel();
        return mMainViewModel;
    }

    @Override
    public int getBindingVariable() {
        return BR.mainPageModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainViewModel.setCallbacks(this);
        mMainViewModel.fetchAll();
    }

    @Override
    public void getUpdates(List<ResponseDummy> value) {
        ((MainAdapter)getViewDataBinding().rvMain.getAdapter()).addItems(value);
    }
}

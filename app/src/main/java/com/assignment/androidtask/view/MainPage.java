package com.assignment.androidtask.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

import com.assignment.androidtask.App;
import com.assignment.androidtask.BR;
import com.assignment.androidtask.Constants;
import com.assignment.androidtask.R;
import com.assignment.androidtask.adapter.MainAdapter;
import com.assignment.androidtask.callbacks.MainCallback;
import com.assignment.androidtask.databinding.ActivityMainPageBinding;
import com.assignment.androidtask.helper.RecyclerOnScrollListener;
import com.assignment.androidtask.model.MainViewModel;
import com.assignment.androidtask.model.api.ItemsBean;
import com.assignment.androidtask.view.base.BaseActivity;

import java.util.List;

public class MainPage extends BaseActivity<ActivityMainPageBinding, MainViewModel> implements MainCallback {

    private MainViewModel mMainViewModel;
    private RecyclerOnScrollListener mROnScrollListener;

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

        mROnScrollListener = new RecyclerOnScrollListener((LinearLayoutManager) getViewDataBinding().rvMain.getLayoutManager()) {
            @Override
            public void onLoadMore(int current_page) {
                mMainViewModel.mPageNumber = current_page;
                mMainViewModel.fetchAll();
            }
        };
        getViewDataBinding().rvMain.addOnScrollListener(mROnScrollListener);
        mMainViewModel.fetchAll();
    }

    @Override
    public void getUpdates(List<ItemsBean> value) {
        ((MainAdapter) getViewDataBinding().rvMain.getAdapter()).addItems(value);
    }

    @Override
    public void clearList() {
        ((MainAdapter) getViewDataBinding().rvMain.getAdapter()).clearItems();
        if (mROnScrollListener != null)
            mROnScrollListener.reset();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_logout:
                App.getPref().setCurrentUserLoggedInMode(Constants.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT);
                Intent intent = new Intent(MainPage.this, Login.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

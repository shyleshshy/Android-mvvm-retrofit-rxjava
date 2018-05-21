package com.assignment.androidtask.model;

import com.assignment.androidtask.App;
import com.assignment.androidtask.callbacks.MainCallback;
import com.assignment.androidtask.model.api.ItemsBean;
import com.assignment.androidtask.model.api.ResponseItem;
import com.assignment.androidtask.view.base.BaseViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends BaseViewModel<MainCallback> {

    public final List<ItemsBean> mData = new ArrayList<>();
    public int mPageNumber = 1;

    /*
    * Called on swipe to refresh
    * */
    public void onRefresh() {
        getCallbacks().clearList();
        mPageNumber = 1;
        fetchAll();
    }

    /*
    *Get all items from the server
    * */
    public void fetchAll() {
        setIsLoading(true);
        getCompositeDisposable().add(App.getApiService().fetchAllNotes(mPageNumber,10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<ResponseItem>() {
                    @Override
                    public void onSuccess(ResponseItem value) {
                        if (value.getStatus().getCode() == 200) {
                            getCallbacks().getUpdates(value.getResponseBody());
                        }
                        setIsLoading(false);
                        setHasFailed(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        setIsLoading(false);
                        setHasFailed(true);
                    }
                }));

        setIsLoading(true);
    }
}

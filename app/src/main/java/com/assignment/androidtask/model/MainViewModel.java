package com.assignment.androidtask.model;

import com.assignment.androidtask.App;
import com.assignment.androidtask.callbacks.MainCallback;
import com.assignment.androidtask.model.api.ResponseDummy;
import com.assignment.androidtask.view.base.BaseViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends BaseViewModel<MainCallback> {

    public final List<ResponseDummy> mData = new ArrayList<>();

    public void fetchAll() {
        setIsLoading(true);
        getCompositeDisposable().add(App.getApiService().fetchAllNotes()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<ResponseDummy>>() {
                    @Override
                    public void onSuccess(List<ResponseDummy> value) {
                        getCallbacks().getUpdates(value);
                        setIsLoading(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        setIsLoading(false);
                    }
                }));

        setIsLoading(true);
    }

}

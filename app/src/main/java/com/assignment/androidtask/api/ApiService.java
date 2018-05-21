package com.assignment.androidtask.api;

import com.assignment.androidtask.model.api.LoginResponse;
import com.assignment.androidtask.model.api.ResponseItem;
import com.assignment.androidtask.model.api.ValidateRequest;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    @GET("item")
    Single<ResponseItem> fetchAllNotes(@Query("page") int page,@Query("count") int numberOfItemsPage);

    @POST("validate")
    Single<LoginResponse> login(@Body ValidateRequest request);
}

package com.assignment.androidtask.api;

import com.assignment.androidtask.model.api.ResponseDummy;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface ApiService {
    @GET("posts/1/comments")
    Single<List<ResponseDummy>> fetchAllNotes();
}

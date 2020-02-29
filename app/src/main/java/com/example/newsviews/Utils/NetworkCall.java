package com.example.newsviews.Utils;

import com.example.newsviews.Model.HeadLine;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NetworkCall {

    //region GET
    @GET("v2/top-headlines")
    Observable<HeadLine> GetTopHeadlines(@Query("country") String country, @Query("apiKey") String apiKey);

    @GET("aplservice/GetChannel")
    Observable<String> GetChannel();
}

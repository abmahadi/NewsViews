package com.example.newsviews.Utils;

import com.example.newsviews.Model.HeadLine;

import io.reactivex.Observable;
import retrofit2.Retrofit;

public class NetworkService {

    private NetworkCall networkCall = null;


    public NetworkService() {
        Retrofit retrofit = RestClient.getClient();
        networkCall = retrofit.create(NetworkCall.class);
    }

    public Observable<HeadLine> GetTopHeadlines(String country, String key) {

        return networkCall.GetTopHeadlines(country, key);


    }


}

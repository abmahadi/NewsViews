package com.example.newsviews.Utils;

import com.example.newsviews.Model.HeadLine;

import io.reactivex.Observable;
import retrofit2.Retrofit;

public class NetworkService {

    private NetworkCall networkCall = null;

    private NetworkCall networkCallnumber = null;


    public NetworkService() {
        Retrofit retrofit = RestClient.getClient();
        networkCall = retrofit.create(NetworkCall.class);
    }

    public NetworkCall NetworkServiceNumber() {
        Retrofit retrofit = RestClient.getNumberClient();
        networkCallnumber = retrofit.create(NetworkCall.class);
        return networkCallnumber;
    }

    public Observable<HeadLine> GetTopHeadlines(String country, String key) {

        return networkCall.GetTopHeadlines(country, key);


    }


}

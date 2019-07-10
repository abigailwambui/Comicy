package com.example.comicy;


import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class ComicyService {

    public  static  void findComics(Callback callback) {

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.COMICY_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.COMICY_APIKEY_PARAMETER, Constants.COMICY_APIKEY);
        urlBuilder.addQueryParameter(Constants.COMICY_TS_PARAMETER, Constants.COMICY_TS);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }
}

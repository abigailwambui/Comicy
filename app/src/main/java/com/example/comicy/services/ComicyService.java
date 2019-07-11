package com.example.comicy.services;


import com.example.comicy.models.Comicy;
import com.example.comicy.Constants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ComicyService {

    public static void findComics(Callback callback) {

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.COMICY_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.COMICY_APIKEY_PARAMETER, Constants.COMICY_APIKEY);
        urlBuilder.addQueryParameter(Constants.COMICY_TS_PARAMETER, Constants.COMICY_TS);
        urlBuilder.addQueryParameter(Constants.COMICY_HASH_PARAMETER, Constants.COMICY_TOKEN);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Comicy> processResults(Response response) {
        ArrayList<Comicy> comics = new ArrayList<>();
        try {
            String jsonData = response.body().string();
            JSONObject jsonObject = new JSONObject(jsonData);
            JSONArray resultsJSON = jsonObject.getJSONObject("data").getJSONArray("results");
            if (response.isSuccessful()) {
               for (int i = 0; i < resultsJSON.length(); i++) {
                    JSONObject comicyJSON = resultsJSON.getJSONObject(i);
                    String id = comicyJSON.getString("id");
                    String title = comicyJSON.getString("title");
                    String issuenumber = comicyJSON.getString("issueNumber");
                    String description = comicyJSON.getString("description");
                    String format = comicyJSON.getString("format");
                    String modified = comicyJSON.getString("modified");
                    JSONObject thumbnail = comicyJSON.getJSONObject("thumbnail");
                    String path = thumbnail.getString("path");
                    String ext = thumbnail.getString("extension");
                    String pagecount = comicyJSON.getString("pageCount");
                    String thumbnail1 = path.concat("."+ext);

                    Comicy comicy = new Comicy(id, title, issuenumber,
                            description, format, modified, thumbnail1, pagecount);
                    comics.add(comicy);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return comics;

    }
}



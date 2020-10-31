package com.nese.movieapp.common;

import android.content.Context;

import com.nese.movieapp.data.remote.ApiClient;
import com.nese.movieapp.data.remote.ApiService;

public class BaseRepository {
    public ApiService apiService;

    public BaseRepository() {
        apiService = ApiClient.getClient();
    }
}

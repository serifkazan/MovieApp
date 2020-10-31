package com.nese.movieapp.ui.main;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.nese.movieapp.common.BaseRepository;
import com.nese.movieapp.model.movie.MovieResponse;
import com.nese.movieapp.model.movie.MovieResults;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepository extends BaseRepository {
    public LiveData<List<MovieResults>> getPopularMovies() {
        MutableLiveData<List<MovieResults>> moviesListData = new MutableLiveData<>();
        apiService.getPopularMovies().enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                moviesListData.setValue(response.body().getResults());
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.e("getPopularMovies", t.getMessage());
            }
        });
        return moviesListData;
    }

    public LiveData<List<MovieResults>> getTopRatedMovies() {
        MutableLiveData<List<MovieResults>> moviesListData = new MutableLiveData<>();
        apiService.getTopRatedMovies().enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                moviesListData.setValue(response.body().getResults());
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.e("getPopularMovies", t.getMessage());
            }
        });
        return moviesListData;
    }
}

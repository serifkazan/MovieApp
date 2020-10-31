package com.nese.movieapp.ui.detail.review;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.nese.movieapp.common.BaseRepository;
import com.nese.movieapp.model.reviews.MovieReviewResponse;
import com.nese.movieapp.model.reviews.MovieReviewResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReviewRepository extends BaseRepository {

    public MutableLiveData<List<MovieReviewResult>> getReviews(int movieId) {
        MutableLiveData<List<MovieReviewResult>> movieReviewLive = new MutableLiveData<>();
        apiService.getMovieReviews(movieId).enqueue(new Callback<MovieReviewResponse>() {
            @Override
            public void onResponse(Call<MovieReviewResponse> call, Response<MovieReviewResponse> response) {
                movieReviewLive.setValue(response.body().getResults());
            }

            @Override
            public void onFailure(Call<MovieReviewResponse> call, Throwable t) {
                Log.e("getReviews", t.getMessage().toString());
            }
        });
        return movieReviewLive;
    }
}

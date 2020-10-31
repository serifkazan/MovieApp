package com.nese.movieapp.ui.detail.overview;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.nese.movieapp.model.detail.MovieDetailResponse;
import com.nese.movieapp.model.video.MovieVideoResults;

import java.util.List;

public class OverviewMovieViewModel extends ViewModel {
    OverviewRepository overviewRepository;

    public OverviewMovieViewModel() {
        this.overviewRepository = new OverviewRepository();
    }

    public LiveData<MovieDetailResponse> getDetails(int movieId) {
        return overviewRepository.getDetails(movieId);
    }

    public LiveData<List<MovieVideoResults>> getVideos(int movieId) {
        return overviewRepository.getMovieVideos(movieId);
    }
}
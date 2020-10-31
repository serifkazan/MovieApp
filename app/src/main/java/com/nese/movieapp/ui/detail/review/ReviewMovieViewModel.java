package com.nese.movieapp.ui.detail.review;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.nese.movieapp.model.reviews.MovieReviewResult;

import java.util.List;

public class ReviewMovieViewModel extends ViewModel {
    ReviewRepository repository = new ReviewRepository();

    public LiveData<List<MovieReviewResult>> getReviews(int movieId) {
        return repository.getReviews(movieId);
    }
}
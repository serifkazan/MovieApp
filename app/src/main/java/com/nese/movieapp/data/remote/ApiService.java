package com.nese.movieapp.data.remote;

import com.nese.movieapp.model.detail.MovieDetailResponse;
import com.nese.movieapp.model.movie.MovieResponse;
import com.nese.movieapp.model.reviews.MovieReviewResponse;
import com.nese.movieapp.model.video.MovieVideoResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("movie/popular")
    Call<MovieResponse> getPopularMovies();

    @GET("movie/top_rated")
    Call<MovieResponse> getTopRatedMovies();

    @GET("movie/{id}")
    Call<MovieDetailResponse> getMovieDetail(@Path("id") int movieId);

    @GET("movie/{id}/videos")
    Call<MovieVideoResponse> getMovieVideos(@Path("id") int movieId);

    @GET("movie/{id}/reviews")
    Call<MovieReviewResponse> getMovieReviews(@Path("id") int movieId);
}

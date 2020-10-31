package com.nese.movieapp.ui.main.toprated;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.nese.movieapp.model.movie.MovieResults;
import com.nese.movieapp.ui.main.MainRepository;

import java.util.List;

public class TopRatedViewModel extends ViewModel {
    MainRepository repository;

    public TopRatedViewModel() {
        this.repository = new MainRepository();
    }

    public LiveData<List<MovieResults>> getTopRatedMovies() {
        return repository.getTopRatedMovies();
    }
}
package com.nese.movieapp.ui.main.popular;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nese.movieapp.R;
import com.nese.movieapp.common.BaseVMFragment;
import com.nese.movieapp.model.movie.MovieResults;
import com.nese.movieapp.ui.detail.DetailActivity;
import com.nese.movieapp.ui.main.MovieAdapter;

import java.util.List;

import static com.nese.movieapp.util.Constants.EXTRA_POPULAR_MOVIES;

public class PopularMoviesFragment extends BaseVMFragment<PopularMoviesViewModel> implements MovieAdapter.OnMovieClickListener {
    MovieAdapter adapter;
    private RecyclerView popularRecyclerView;
    private ProgressBar popularProgressBar;

    @Override
    public Class<PopularMoviesViewModel> getViewModel() {
        return PopularMoviesViewModel.class;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState, PopularMoviesViewModel viewModel) {
        adapter = new MovieAdapter(new MovieAdapter.MovieDiff(), this);
        popularRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        viewModel.getPopularMovies().observe(this, movieResults -> {
            adapter.submitList(movieResults);
            popularRecyclerView.setAdapter(adapter);
            popularRecyclerView.setVisibility(View.VISIBLE);
            popularProgressBar.setVisibility(View.GONE);
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.popular_movies_fragment, container, false);
        popularRecyclerView = view.findViewById(R.id.popular_recyclerview);
        popularProgressBar = view.findViewById(R.id.popular_progressbar);
        return view;
    }

    @Override
    public void onMovieClick(MovieResults movieResults) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra(EXTRA_POPULAR_MOVIES, movieResults);
        startActivity(intent);
    }
}
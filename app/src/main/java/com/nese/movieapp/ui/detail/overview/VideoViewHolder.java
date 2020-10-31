package com.nese.movieapp.ui.detail.overview;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.nese.movieapp.databinding.ItemVideoBinding;
import com.nese.movieapp.model.video.MovieVideoResults;

public class VideoViewHolder extends RecyclerView.ViewHolder {
    private final ItemVideoBinding binding;

    public VideoViewHolder(ItemVideoBinding binding, VideoAdapter.OnVideoClickListener onVideoClickListener) {
        super(binding.getRoot());
        this.binding = binding;
        binding.getRoot().setOnClickListener(v -> onVideoClickListener.onVideoClick(binding.getVideo()));
    }

    public void bind(MovieVideoResults movieVideoResults) {
        binding.setVideo(movieVideoResults);
        binding.executePendingBindings();
    }

    public static VideoViewHolder create(LayoutInflater inflater, ViewGroup parent, VideoAdapter.OnVideoClickListener onVideoClickListener) {
        ItemVideoBinding itemVideoBinding = ItemVideoBinding.inflate(inflater, parent, false);
        return new VideoViewHolder(itemVideoBinding, onVideoClickListener);

    }
}

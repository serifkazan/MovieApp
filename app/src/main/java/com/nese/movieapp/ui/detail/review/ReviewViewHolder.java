package com.nese.movieapp.ui.detail.review;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.nese.movieapp.databinding.ItemReviewBinding;
import com.nese.movieapp.model.reviews.MovieReviewResult;

public class ReviewViewHolder extends RecyclerView.ViewHolder {

    private final ItemReviewBinding binding;

    public ReviewViewHolder(ItemReviewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(MovieReviewResult movieReviewResult) {
        binding.setReview(movieReviewResult);
        binding.executePendingBindings();
    }

    public static ReviewViewHolder create(LayoutInflater inflater, ViewGroup parent) {
        ItemReviewBinding itemReviewBinding = ItemReviewBinding.inflate(inflater, parent, false);
        return new ReviewViewHolder(itemReviewBinding);
    }
}

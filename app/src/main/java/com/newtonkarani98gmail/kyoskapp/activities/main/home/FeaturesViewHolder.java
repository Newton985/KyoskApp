package com.newtonkarani98gmail.kyoskapp.activities.main.home;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.newtonkarani98gmail.kyoskapp.databinding.FeatureItemBinding;

public class FeaturesViewHolder extends RecyclerView.ViewHolder {

    FeatureItemBinding binding;

    public FeaturesViewHolder(@NonNull FeatureItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(String imageUrl){
        binding.setFeatureImageUrl(imageUrl);
    }
}

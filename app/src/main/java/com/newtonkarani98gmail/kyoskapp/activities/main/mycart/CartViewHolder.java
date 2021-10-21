package com.newtonkarani98gmail.kyoskapp.activities.main.mycart;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.newtonkarani98gmail.kyoskapp.databinding.CartItemBinding;
import com.newtonkarani98gmail.kyoskapp.models.Item;

public class CartViewHolder extends RecyclerView.ViewHolder {
    CartItemBinding binding;

    public CartViewHolder(@NonNull CartItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Item item){
        binding.setItem(item);
    }
}

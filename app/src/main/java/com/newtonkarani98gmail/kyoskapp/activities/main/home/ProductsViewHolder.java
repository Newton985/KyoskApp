package com.newtonkarani98gmail.kyoskapp.activities.main.home;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.newtonkarani98gmail.kyoskapp.databinding.ProductItemBinding;
import com.newtonkarani98gmail.kyoskapp.models.Item;

public class ProductsViewHolder extends RecyclerView.ViewHolder {

    private ProductItemBinding binding;

    public ProductsViewHolder(@NonNull ProductItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Item item){
      binding.setItem(item);
    }
}

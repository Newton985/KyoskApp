package com.newtonkarani98gmail.kyoskapp.activities.main.home;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.newtonkarani98gmail.kyoskapp.databinding.CategoryOverviewItemBinding;
import com.newtonkarani98gmail.kyoskapp.models.Category;
import com.newtonkarani98gmail.kyoskapp.models.Item;

import java.util.ArrayList;
import java.util.List;

public class CategoriesOverviewViewHolder extends RecyclerView.ViewHolder {

    CategoryOverviewItemBinding binding;

    public CategoriesOverviewViewHolder(@NonNull CategoryOverviewItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Category category, HomeViewModel homeViewModel){
     binding.setCategory(category);

     List<Item> itemList = homeViewModel.getItemsByCategory(category.getCode());

     binding.productsRecyclerView.setItemAnimator(new DefaultItemAnimator());
     binding.productsRecyclerView.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext(), LinearLayoutManager.HORIZONTAL, false));

     ProductsAdapter productsAdapter = new ProductsAdapter(itemList);
     binding.productsRecyclerView.setAdapter(productsAdapter);

     for (int i = 0 ; i < itemList.size(); i++){ productsAdapter.notifyDataSetChanged(); }

    }
}

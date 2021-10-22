package com.newtonkarani98gmail.kyoskapp.activities.main.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.newtonkarani98gmail.kyoskapp.R;
import com.newtonkarani98gmail.kyoskapp.databinding.CategoryOverviewItemBinding;
import com.newtonkarani98gmail.kyoskapp.models.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoriesOverviewAdapter extends RecyclerView.Adapter<CategoriesOverviewViewHolder> {

    List<Category> categoryList= new ArrayList<>();
    HomeViewModel homeViewModel;

    public CategoriesOverviewAdapter(List<Category> categoryList, HomeViewModel homeViewModel){
        this.categoryList = categoryList;
        this.homeViewModel = homeViewModel;
    }

    @NonNull
    @Override
    public CategoriesOverviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CategoryOverviewItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.category_overview_item, parent, false);

        return new CategoriesOverviewViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesOverviewViewHolder holder, int position) {
        holder.bind(categoryList.get(position), homeViewModel);

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }
}

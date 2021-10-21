package com.newtonkarani98gmail.kyoskapp.activities.main.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.newtonkarani98gmail.kyoskapp.R;
import com.newtonkarani98gmail.kyoskapp.databinding.ProductItemBinding;
import com.newtonkarani98gmail.kyoskapp.models.Item;

import java.util.ArrayList;
import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsViewHolder> {

    private List<Item> itemList = new ArrayList<>();

    public  ProductsAdapter(List<Item> itemList){
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ProductItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.product_item, parent, false);
        return new ProductsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsViewHolder holder, int position) {
        holder.bind(itemList.get(position));

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}

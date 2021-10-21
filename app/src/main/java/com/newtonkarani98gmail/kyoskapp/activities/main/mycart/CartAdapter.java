package com.newtonkarani98gmail.kyoskapp.activities.main.mycart;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.newtonkarani98gmail.kyoskapp.R;
import com.newtonkarani98gmail.kyoskapp.databinding.CartItemBinding;
import com.newtonkarani98gmail.kyoskapp.models.Item;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartViewHolder> {

    List<Item> itemList = new ArrayList<>();

    public CartAdapter(List<Item> itemList){
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CartItemBinding binding = DataBindingUtil.inflate(
             LayoutInflater.from(parent.getContext()),R.layout.cart_item, parent, false);

        return new CartViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
     holder.bind(itemList.get(position));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}

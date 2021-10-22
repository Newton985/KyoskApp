package com.newtonkarani98gmail.kyoskapp.activities.main.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.newtonkarani98gmail.kyoskapp.R;
import com.newtonkarani98gmail.kyoskapp.databinding.FeatureItemBinding;

import java.util.ArrayList;
import java.util.List;

public class FeaturesAdapter extends RecyclerView.Adapter<FeaturesViewHolder> {

    List<String> featureImagesList = new ArrayList<>();

    public FeaturesAdapter(List<String> featureImagesList){
        this.featureImagesList = featureImagesList;
    }

    @NonNull
    @Override
    public FeaturesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        FeatureItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.feature_item, parent, false);
        return new FeaturesViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturesViewHolder holder, int position) {
        holder.bind(featureImagesList.get(position));
    }

    @Override
    public int getItemCount() {
        return featureImagesList.size();
    }
}

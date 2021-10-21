package com.newtonkarani98gmail.kyoskapp.activities.main.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.newtonkarani98gmail.kyoskapp.databinding.FragmentHomeBinding;
import com.newtonkarani98gmail.kyoskapp.models.CategoriesResponse;
import com.newtonkarani98gmail.kyoskapp.models.Item;

import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


       //Features Images
       binding.featuresRecyclerView.setItemAnimator(new DefaultItemAnimator());
       binding.featuresRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

       FeaturesAdapter featuresAdapter = new FeaturesAdapter(homeViewModel.getFeatureImages());
       binding.featuresRecyclerView.setAdapter(featuresAdapter);

       for (int i = 0; i< homeViewModel.getFeatureImages().size(); i++){ featuresAdapter.notifyDataSetChanged(); }


       homeViewModel.getCategoriesResponseMutableLiveData().observe(getViewLifecycleOwner(), new Observer<CategoriesResponse>() {
           @Override
           public void onChanged(CategoriesResponse categoriesResponse) {
               //Now get Items
               homeViewModel.getItems();

           }
       });

       homeViewModel.getItemsMutableLiveData().observe(getViewLifecycleOwner(), new Observer<List<Item>>() {
           @Override
           public void onChanged(List<Item> itemList) {

               binding.categoriesOverViewRecyclerView.setItemAnimator(new DefaultItemAnimator());
               binding.categoriesOverViewRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

               CategoriesOverviewAdapter categoriesOverviewAdapter = new CategoriesOverviewAdapter(homeViewModel.getCategoriesResponseMutableLiveData().getValue().getCategories(), homeViewModel);
               binding.categoriesOverViewRecyclerView.setAdapter(categoriesOverviewAdapter);

               for (int i =0; i< homeViewModel.getCategoriesResponseMutableLiveData().getValue().getCategories().size() ; i++){ categoriesOverviewAdapter.notifyDataSetChanged(); }


           }
       });

       //get Categories
        homeViewModel.getCategories();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
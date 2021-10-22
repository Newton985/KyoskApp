package com.newtonkarani98gmail.kyoskapp.activities.main.home;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.newtonkarani98gmail.kyoskapp.models.CategoriesResponse;
import com.newtonkarani98gmail.kyoskapp.models.Item;
import com.newtonkarani98gmail.kyoskapp.repositories.ProductsRepository;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends AndroidViewModel {

    ProductsRepository productsRepository;
    private final MutableLiveData<CategoriesResponse> categoriesResponseMutableLiveData;
    private final MutableLiveData<List<Item>> itemsMutableLiveData;
    private final List<String> featureImages = new ArrayList<>();

    private MutableLiveData<Integer> activeCategory = new MutableLiveData<>();

    public HomeViewModel(@NonNull Application application) {
        super(application);
        productsRepository = new ProductsRepository(application);
        categoriesResponseMutableLiveData = productsRepository.getCategoriesResponseMutableLiveData();
        itemsMutableLiveData = productsRepository.getItemsMutableLiveData();

        featureImages.add("https://images.unsplash.com/photo-1634733594199-1b406eef4afc?ixid=MnwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHw3fHx8ZW58MHx8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60");
        featureImages.add("https://images.unsplash.com/photo-1593642702749-b7d2a804fbcf?ixid=MnwxMjA3fDF8MHxlZGl0b3JpYWwtZmVlZHwxfHx8ZW58MHx8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60");
        featureImages.add("https://images.unsplash.com/photo-1633114128174-2f8aa49759b0?ixid=MnwxMjA3fDF8MHxlZGl0b3JpYWwtZmVlZHwxMXx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60");
        featureImages.add("https://images.unsplash.com/photo-1593642532454-e138e28a63f4?ixid=MnwxMjA3fDF8MHxlZGl0b3JpYWwtZmVlZHwyMXx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60");

    }

    public void getItems(){
      productsRepository.getItems();
    }

    public void getCategories(){
     productsRepository.getCategories();
    }


    public List<Item> getItemsByCategory(@NonNull String category){
        return productsRepository.getItemsByCategory(category);
    }

    public MutableLiveData<CategoriesResponse> getCategoriesResponseMutableLiveData() {
        return categoriesResponseMutableLiveData;
    }

    public MutableLiveData<List<Item>> getItemsMutableLiveData() {
        return itemsMutableLiveData;
    }

    public List<String> getFeatureImages() {
        return featureImages;
    }

    public MutableLiveData<Integer> getActiveCategory() {
        return activeCategory;
    }
}
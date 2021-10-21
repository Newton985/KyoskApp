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

    public HomeViewModel(@NonNull Application application) {
        super(application);
        productsRepository = new ProductsRepository(application);
        categoriesResponseMutableLiveData = productsRepository.getCategoriesResponseMutableLiveData();
        itemsMutableLiveData = productsRepository.getItemsMutableLiveData();

        featureImages.add("https://www.freeimages.com/photo/eggs-oranges-5-1546938");
        featureImages.add("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.shutterstock.com%2Fsearch%2Fadvertising&psig=AOvVaw1kZalqFH6s9_mVlU5tdAjI&ust=1634903712665000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCOjNhou52_MCFQAAAAAdAAAAABAJ");
        featureImages.add("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.livelaw.in%2Fadvertisement-is-facet-of-commercial-speech-protected-by-article-191a-of-constitution-holds-delhi-hc-read-judgment%2F&psig=AOvVaw1kZalqFH6s9_mVlU5tdAjI&ust=1634903712665000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCOjNhou52_MCFQAAAAAdAAAAABAP");
        featureImages.add("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.eco-business.com%2Fnews%2Fadvertisements-harm-the-planet-researchers-say%2F&psig=AOvVaw1kZalqFH6s9_mVlU5tdAjI&ust=1634903712665000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCOjNhou52_MCFQAAAAAdAAAAABAb");
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
}
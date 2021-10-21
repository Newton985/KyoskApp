package com.newtonkarani98gmail.kyoskapp.repositories;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Room;

import com.newtonkarani98gmail.kyoskapp.models.CategoriesResponse;
import com.newtonkarani98gmail.kyoskapp.models.Item;
import com.newtonkarani98gmail.kyoskapp.retrofit.ServiceBuilder;
import com.newtonkarani98gmail.kyoskapp.room.KyoskDatabase;
import com.newtonkarani98gmail.kyoskapp.services.ProductsService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsRepository {

    private final MutableLiveData<CategoriesResponse> categoriesResponseMutableLiveData = new MutableLiveData<>();
    private final MutableLiveData<List<Item>> itemsMutableLiveData = new MutableLiveData<>();
    private final ProductsService productsService;
    private final KyoskDatabase kyoskDatabase;

    public ProductsRepository(Application application){
        productsService = ServiceBuilder.buildService(ProductsService.class);
        kyoskDatabase = Room.databaseBuilder(application.getApplicationContext(), KyoskDatabase.class, "kyosk_db").build();
    }


    public void getCategories(){

        //try a network call
        productsService.getCategories().enqueue(new Callback<CategoriesResponse>() {
            @Override
            public void onResponse(Call<CategoriesResponse> call, Response<CategoriesResponse> response) {
                categoriesResponseMutableLiveData.setValue(response.body());

            }

            @Override
            public void onFailure(Call<CategoriesResponse> call, Throwable t) {
               // if no network -- Get data from SQLite
            }
        });
    }

    public void getItems(){
        //try a network call
        productsService.getItems().enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                itemsMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                // if no network -- Get data from SQLite

            }
        });

    }

    public List<Item> getItemsByCategory(@NonNull String category){
        List<Item> itemList = new ArrayList<>();

        if (itemsMutableLiveData.getValue() != null) {
            for (Item item : itemsMutableLiveData.getValue()){
                if (item.getCategory().equals(category)){
                    itemList.add(item);
                }
            }

        }

        return itemList;
    }


    public MutableLiveData<CategoriesResponse> getCategoriesResponseMutableLiveData() {
        return categoriesResponseMutableLiveData;
    }

    public MutableLiveData<List<Item>> getItemsMutableLiveData() {
        return itemsMutableLiveData;
    }
}

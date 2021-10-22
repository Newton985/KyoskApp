package com.newtonkarani98gmail.kyoskapp.services;

import com.newtonkarani98gmail.kyoskapp.models.CategoriesResponse;
import com.newtonkarani98gmail.kyoskapp.models.Item;
import com.newtonkarani98gmail.kyoskapp.retrofit.ApiEndpoints;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductsService {

    @GET(ApiEndpoints.items)
    public Call<List<Item>> getItems();

    @GET(ApiEndpoints.categories)
    public Call<CategoriesResponse> getCategories();
}

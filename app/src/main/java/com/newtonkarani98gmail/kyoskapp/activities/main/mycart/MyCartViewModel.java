package com.newtonkarani98gmail.kyoskapp.activities.main.mycart;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.newtonkarani98gmail.kyoskapp.models.Item;
import com.newtonkarani98gmail.kyoskapp.repositories.ProductsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MyCartViewModel extends AndroidViewModel {

    ProductsRepository productsRepository;
    private final MutableLiveData<List<Item>> cartItemsMutableLiveData ;

    public MyCartViewModel(@NonNull Application application) {
        super(application);
        productsRepository =  new ProductsRepository(application);
        cartItemsMutableLiveData = productsRepository.getCartItemsMutableLiveData();
    }

    public void getCartItems(){
        productsRepository.getItemsInCart();
    }

    public MutableLiveData<List<Item>> getCartItemsMutableLiveData() {
        return cartItemsMutableLiveData;
    }
}
package com.newtonkarani98gmail.kyoskapp.activities.main.mycart;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyCartViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MyCartViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
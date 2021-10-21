package com.newtonkarani98gmail.kyoskapp.bindingadapter;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class CustomBindingAdapter {

    @BindingAdapter("imageUrl")
    public  static void  setImage(ImageView imageView, String url){
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }
}

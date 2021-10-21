package com.newtonkarani98gmail.kyoskapp.retrofit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceBuilder {

    private static final OkHttpClient.Builder okHttp = new OkHttpClient.Builder();

    private static final Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(ApiEndpoints.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttp.build());

    private static final Retrofit retroFit = builder.build();

    public static <S> S buildService(Class<S> serviceType) {
        return retroFit.create(serviceType);
    }
}

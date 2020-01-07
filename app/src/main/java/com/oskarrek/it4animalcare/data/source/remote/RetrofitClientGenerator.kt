package com.oskarrek.it4animalcare.data.source.remote

import java.util.concurrent.TimeUnit
import android.os.Build
import androidx.annotation.RequiresApi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitClientGenerator {

    private val API_BASE_URL = "https://ascendant-bloom-259119.appspot.com/api/"

    @RequiresApi(Build.VERSION_CODES.N)
    private val okHttpClient = OkHttpClient.Builder().apply {
        addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        connectTimeout(10, TimeUnit.SECONDS)
    }.build()

    @RequiresApi(Build.VERSION_CODES.N)
    private val retrofit  = Retrofit.Builder().apply {
        baseUrl(API_BASE_URL)
        addConverterFactory(GsonConverterFactory.create())
        addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        client(okHttpClient)
    }.build()

    //TODO provide base api interface.
    @RequiresApi(Build.VERSION_CODES.N)
    fun <S> createClient(clientClass : Class<S>) : S {
        return retrofit.create(clientClass)
    }
}
package com.example.vntfesh.kartolafc.model.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by vntfesh on 6/29/17.
 */

class RestApi {

    val cartolaService: CartolaService

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.cartolafc.globo.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

        cartolaService = retrofit.create(CartolaService::class.java)
    }
}
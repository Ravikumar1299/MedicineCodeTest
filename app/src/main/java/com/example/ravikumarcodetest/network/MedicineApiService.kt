package com.example.ravikumarcodetest.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


private  val BASE_URL = "https://run.mocky.io/"

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .build()

    interface MedicineApiService {
        @GET("v3/c6b987e9-fa8a-49e4-9df4-577a037caa45")
        suspend fun getMedicineProblem(): ApiResponse
    }

    object MedicineApi {
        val retrofitService: MedicineApiService by lazy {
            retrofit.create(MedicineApiService::class.java)
        }
    }

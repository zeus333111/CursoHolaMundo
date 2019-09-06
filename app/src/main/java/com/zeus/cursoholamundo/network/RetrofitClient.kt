package com.zeus.cursoholamundo.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.zeus.cursoholamundo.Entities.Credential
import com.zeus.cursoholamundo.Entities.GeneralResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface RetrofitClient {

    @POST("authentication")
    fun login(@Body credential: Credential, @Header("token") token: String = "aslhfhberkjhbfejkh" ): Deferred<Response<GeneralResponse>>


    companion object{
        fun createClient(): RetrofitClient{

            val client = Retrofit.Builder()
                .baseUrl("https://server/rest/")
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
            return client.create(RetrofitClient::class.java)
        }
    }
}
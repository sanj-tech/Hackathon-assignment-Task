package com.example.digitalflakedemo.retrofit

import com.example.digitalflakedemo.models.Urlencoded
import com.example.digitalflakedemo.retrofitmodels.RetrofitLoginResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import com.example.digitalflakedemo.retrofitmodels.RetrofitResponse
import com.example.digitalflakedemo.retrofitmodels.urlencoded

interface RetrofitApiService {
    @FormUrlEncoded
    @POST("create_account")
    fun createAccount(
        @Field("user_id") user_id:String,
        @Field("message") message:String,
        @Field("contact") contact:String
    ):Call<RetrofitResponse>

    @FormUrlEncoded
    @POST("login")
    fun loginUser(
        @Field("user_id") user_id:String,
        @Field("user_id") message:String):Call<RetrofitLoginResponse>

}


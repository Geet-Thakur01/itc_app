package com.example.geet.retroexample.configuration


import com.google.gson.JsonObject
import io.reactivex.Observable
import retrofit2.http.*

interface Services {
    @Headers("Content-Type:application/json; charset=UTF-8")
    @GET("/walmartproducts/{pageNumber}/{pageSize}")
    abstract fun getWalmartproducts(pageNumber:String,pageSize:String): Observable<JsonObject>


}
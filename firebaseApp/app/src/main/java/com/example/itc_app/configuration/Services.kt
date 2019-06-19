package com.example.geet.retroexample.configuration


import com.google.gson.JsonObject
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface Services {
    @Headers("Content-Type:application/json; charset=UTF-8")
    @GET("/walmartproducts/{pageNumber}/{pageSize}")
    fun getWalmartproducts(@Path("pageNumber")pageNumber:String, @Path("pageSize")pageSize:String): Observable<JsonObject>


}
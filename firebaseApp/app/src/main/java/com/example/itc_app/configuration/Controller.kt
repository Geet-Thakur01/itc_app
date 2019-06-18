package com.example.geet.retroexample.configuration

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class Controller(val ctx: Context) {
    private val service: Services = ApiClient.getInstance().create<Services>(Services::class.java)


    fun getAllProducts() {
        if (AppUtility.isInternetConnected(ctx)) {

            service.getWalmartproducts("1", "2")
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(object : Observer<JsonObject> {
                        override fun onSubscribe(d: Disposable) {

                        }

                        override fun onNext(jsonObject: JsonObject) {
                            if (jsonObject.get("statusCode").asInt == 200) {
                                Log.e("TAG", "HI");
                            }
                        }

                        override fun onError(e: Throwable) {
                            Log.e("TAG", "HI")
                        }

                        override fun onComplete() {

                        }
                    })
        }
    }


//    implementation 'com.squareup.retrofit2:retrofit:2.4.0'
//    implementation 'com.squareup.retrofit2:converter-gson:2.3.0'
//
//    implementation 'io.reactivex.rxjava2:rxandroid:2.0.2'
//    implementation 'io.reactivex.rxjava2:rxjava:2.1.9'
//    implementation 'com.squareup.retrofit2:adapter-rxjava2:2.3.0'
//    implementation 'com.squareup.okhttp3:okhttp:3.11.0'


}
package com.example.geet.retroexample.configuration

import android.content.Context
import android.util.Log
import com.example.itc_app.models.Product_model
import com.example.itc_app.screens.ProductListActivity
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

            service.getWalmartproducts("1", "2").subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<JsonObject> {
                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onNext(jsonObject: JsonObject) {
                        if (jsonObject.get("statusCode").asInt == 200) {
                            val convert = Gson().toJson(jsonObject.get("products").asJsonArray)
                            val listType = object : TypeToken<List<Product_model>>() {
                            }.type
                            val data: ArrayList<Product_model> = Gson().fromJson(convert, listType)

                            Log.e("TAG", "HI")
                            (ctx as ProductListActivity).updateList(data)
                        }
                    }

                    override fun onError(e: Throwable) {
                    }

                    override fun onComplete() {
                    }
                })
        }

    }


}
package com.example.itc_app.models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData



class ProductViewModel(application:Application) : AndroidViewModel(application) {
    private val product_model: Product_model? = null
    private val allproducts: LiveData<List<Product_model>>? = null

}
package com.example.itc_app.interfaces

import com.example.itc_app.models.Product_model

interface List_view {
    fun updateList(data: ArrayList<Product_model>)
    fun OnItemClicked(item:Product_model)

}
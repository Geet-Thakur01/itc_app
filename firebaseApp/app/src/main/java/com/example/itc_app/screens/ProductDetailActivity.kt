package com.example.itc_app.screens

import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.geet.retroexample.configuration.ApiClient
import com.example.itc_app.R
import com.example.itc_app.models.Product_model
import kotlinx.android.synthetic.main.activity_product_detail.*
import kotlinx.android.synthetic.main.adapter_product_item.view.*

class ProductDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        val bundle = intent.getBundleExtra("myBundle")
        var product = bundle.getParcelable<Product_model>("data") as Product_model
        Log.e("TAG: ", product.price)

        product.let {

            tv_product_name.text = it.productName
            tv_full_description.text = it.longDescription
            tv_prize.text = it.price
            tv_review.text = "Review ${it.reviewRating.toString()}"
            tv_rating.text = "Rating ${it.reviewCount.toString()}"
            Glide.with(this)
                .load("${ApiClient.BASE_URL}/${it.productImage}")
                .centerCrop()
                .override(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                .into(img_product_detail)

        }
    }
}

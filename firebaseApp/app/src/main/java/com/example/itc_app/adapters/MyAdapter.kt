package com.example.itc_app.adapters

import android.content.Context
import android.os.Build
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.geet.retroexample.configuration.ApiClient
import com.example.itc_app.R
import com.example.itc_app.models.Product_model
import com.example.itc_app.screens.ProductListActivity
import kotlinx.android.synthetic.main.adapter_product_item.view.*

class MyAdapter(private val ctx: Context, private var myDataset: ArrayList<Product_model>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        // create a new view
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_product_item, parent, false) as View
        return MyViewHolder(view).listen { position ->
            (ctx as ProductListActivity).OnItemClicked(myDataset[position])
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.view.tv_product_name.text = Html.fromHtml(myDataset[position].productName, Html.FROM_HTML_MODE_COMPACT)
        holder.view.tv_desc.text = Html.fromHtml(myDataset[position].shortDescription, Html.FROM_HTML_MODE_COMPACT)
        holder.view.tv_prize.text = "Rating : ${myDataset[position].reviewRating}"
        holder.view.tv_prize.text = "Prize : ${myDataset[position].price}"
        holder.view.tv_stock.text = if (myDataset[position].inStock) "in stock" else "out of stock"
        Glide.with(ctx)
            .load("${ApiClient.BASE_URL}/${myDataset[position].productImage}")
            .centerCrop()
            .override(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            .into(holder.view.product_img)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = myDataset.size

    fun updateusers(data: ArrayList<Product_model>?) {
        data.let {
            myDataset.addAll(it!!)
            notifyDataSetChanged()
        }
    }

    fun <T : RecyclerView.ViewHolder> T.listen(event: (position: Int) -> Unit): T {
        itemView.setOnClickListener {
            event.invoke(adapterPosition)
        }
        return this
    }
}
package com.example.itc_app.screens

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.geet.retroexample.configuration.Controller
import com.example.itc_app.R
import com.example.itc_app.adapters.MyAdapter
import com.example.itc_app.interfaces.List_view
import com.example.itc_app.models.Product_model


class ProductListActivity : AppCompatActivity(), List_view {
    override fun OnItemClicked(item: Product_model) {
        val intent: Intent = Intent(this, ProductDetailActivity::class.java)
        var bundle = Bundle()
        bundle.putParcelable("data", item)
        intent.putExtra("myBundle", bundle)
        startActivity(intent)
    }

    override fun updateList(data: ArrayList<Product_model>) {
        (viewAdapter as MyAdapter).updateusers(data)
    }

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productlist)
        var myDataset = ArrayList<Product_model>()
        viewManager = LinearLayoutManager(this)
        viewAdapter = MyAdapter(this, myDataset)

        recyclerView = findViewById<RecyclerView>(R.id.my_recycler_view).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter

        }
        Controller(this).getAllProducts()

    }
}

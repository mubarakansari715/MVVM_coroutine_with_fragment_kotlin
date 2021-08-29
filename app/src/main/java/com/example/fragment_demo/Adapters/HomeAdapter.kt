package com.example.mvvm_coroutine_kotlin.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fragment_demo.R
import com.example.mvvm_coroutine_kotlin.DataClasses.HomeDataClass
import com.squareup.picasso.Picasso

class HomeAdapter(private val context: Context, private var viewList: List<HomeDataClass>) :
    RecyclerView.Adapter<HomeAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<TextView>(R.id.tv_title)
        val img = itemView.findViewById<ImageView>(R.id.tv_imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder(LayoutInflater.from(context)
            .inflate(R.layout.custom_view, parent, false))
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val model = viewList[position]
        holder.title.text = model.title.toString()
        Picasso.get().load(model.url).fit().centerCrop().into(holder.img)
    }

    override fun getItemCount(): Int {
        return viewList.size
    }

    fun saveData(viewList: List<HomeDataClass>) {
        this.viewList = viewList
        notifyDataSetChanged()
    }
}
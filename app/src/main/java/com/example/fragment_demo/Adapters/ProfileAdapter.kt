package com.example.fragment_demo.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fragment_demo.DataClasses.ProfileDataClass
import com.example.fragment_demo.R

class ProfileAdapter(private val context: Context, private var listView: List<ProfileDataClass>) :
    RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder>() {
    class ProfileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.tv_name)
        val email = itemView.findViewById<TextView>(R.id.tv_email)
        val body = itemView.findViewById<TextView>(R.id.tv_body)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        return ProfileViewHolder(LayoutInflater.from(context)
            .inflate(R.layout.profile_cus_view, parent, false))
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        val model = listView[position]
        holder.name.text = "Name  :  ${model.name}"
        holder.email.text = "Email  :  ${model.email}"
        holder.body.text = "Body  :  ${model.body}"
    }

    override fun getItemCount(): Int {
        return listView.size
    }
    fun PersonSavedData(listView: List<ProfileDataClass>){
        this.listView = listView
        notifyDataSetChanged()
    }
}
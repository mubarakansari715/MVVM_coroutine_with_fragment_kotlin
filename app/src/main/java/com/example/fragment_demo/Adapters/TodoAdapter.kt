package com.example.fragment_demo.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fragment_demo.DataClasses.TodoDataClass
import com.example.fragment_demo.R

class TodoAdapter(private val context: Context, private var todoList: List<TodoDataClass>) :
    RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val id = itemView.findViewById<TextView>(R.id.tv_user_id)
        val title = itemView.findViewById<TextView>(R.id.tv_user_title)
        val complete = itemView.findViewById<TextView>(R.id.tv_user_complete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(LayoutInflater.from(context).inflate(R.layout.todo_cus_list,parent,false))
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val model = todoList[position]
        holder.id.text = "Id   : ${model.id.toString()}"
        holder.title.text = "Title  : ${model.title}"
        holder.complete.text = "Completed : ${model.completed.toString()}"
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

    fun TodoDetails(todoList: List<TodoDataClass>){
        this.todoList = todoList
        notifyDataSetChanged()
    }
    fun PersonSavedData(todoList: List<TodoDataClass>){
        this.todoList = todoList
        notifyDataSetChanged()
    }
}
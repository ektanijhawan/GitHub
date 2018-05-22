package com.example.ekta.github

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_result.view.*


class Adapter(val context: Context) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    var list : ArrayList<Repo> ?= null

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        if(list?.get(position)!=null){
            holder?.tv?.text = list!!.get(position).name
        }
    }

    fun updateList(list : ArrayList<Repo>){
        this.list = list;
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return  list?.size ?: 0
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_result, parent, false))
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tv = view.tv
    }
}
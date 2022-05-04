package com.rudimentum.internshiptestapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rudimentum.internshiptestapp.HomeFeed
import com.rudimentum.internshiptestapp.R
import kotlinx.android.synthetic.main.recyclerview_item.view.*

class CustomRecyclerAdapter(private val homeFeed: HomeFeed) : RecyclerView
.Adapter<CustomRecyclerAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val character = homeFeed.characters[position]
        holder.itemView.textViewLarge.text = character.name
        holder.itemView.textViewSmall.text = character.status

    }

    override fun getItemCount(): Int {
        homeFeed.characters?.let {
            return it.size
        }
        return 0
    }
}
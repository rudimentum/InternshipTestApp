package com.rudimentum.internshiptestapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rudimentum.internshiptestapp.R
import com.rudimentum.internshiptestapp.model.HomeFeed
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recyclerview_item.view.*

class CustomRecyclerAdapter(private val homeFeed: HomeFeed) : RecyclerView
.Adapter<CustomRecyclerAdapter.MyViewHolder>() {

    private val picasso = Picasso.get()
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val character = homeFeed.results[position]
        holder.itemView.characterName.text = character.name
        holder.itemView.characterStatus.text = character.status
        holder.itemView.characterGender.text = character.gender
        picasso.load(character.image).into(holder.itemView.characterAvatar)

    }

    override fun getItemCount(): Int {
        homeFeed.results?.let {
            return it.size
        }
        return 0
    }
}
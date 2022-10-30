package com.example.homeproject3.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homeproject3.R
import com.example.homeproject3.model.User

class UserAdapter (private val items: List<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_profile, parent, false)
        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(items[position], holder.itemView.context)
    }

    override fun getItemCount(): Int = items.size

    inner class UserViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.userName)
        private val onlineStatusTextView: TextView = itemView.findViewById(R.id.onlineStatus)
        private val profileImageView: ImageView = itemView.findViewById(R.id.profileImage)

        fun bind(item : User, context : Context) {
            nameTextView.text = item.name
            onlineStatusTextView.text = item.onlineStatus
            Glide.with(context)
                .load(item.photo)
                .error(R.drawable.ic_generic_avatar)
                .into(profileImageView)
        }
    }
}
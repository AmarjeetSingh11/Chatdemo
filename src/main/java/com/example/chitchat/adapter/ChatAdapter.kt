package com.example.chitchat.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.chitchat.R
import com.example.chitchat.UserModel
import com.example.chitchat.databinding.ChatUserLayoutBinding
import java.util.ArrayList

class ChatAdapter(var context:Context,var list:ArrayList<UserModel>)
    : RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {

    inner class ChatViewHolder(view: View): RecyclerView.ViewHolder(view){
        var binding:ChatUserLayoutBinding= ChatUserLayoutBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        return ChatViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.chat_user_layout,parent,false))
    }

    override fun getItemCount(): Int {

        return list.size
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {

        val user=list[position]

        Glide.with(context).load(user.image).into(holder.binding.UserImageProfile)
        holder.binding.UserName.text=user.name
    }
}
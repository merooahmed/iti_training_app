package com.ya.iticourse.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ya.iticourse.databinding.PostItemBinding
import com.ya.iticourse.core.model.Post


class CustomerAdapter(var userList:List<Post>, var listener: MyCustomClickListener) :RecyclerView.Adapter<CustomerAdapter.ViewHolder>(){
    inner class ViewHolder(val binding:PostItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
         val binding = PostItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
         return userList.size
    }
    override fun onBindViewHolder(viewHolder: ViewHolder, position:Int){


    viewHolder.binding.userName1Label.text = "userId : ${userList[position].userId}"
    viewHolder.binding.date1Label.text = "postId : ${userList[position].id}"
    viewHolder.binding.post1Label.text = "${userList[position].body}"
    viewHolder.binding.titleTv.text = "${userList[position].title}"

        viewHolder.binding.detailsButton.setOnClickListener(){
            listener.onItemClick(userList[position],position)
        }

    }

}
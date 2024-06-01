package com.ya.iticourse.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.ya.iticourse.core.model.Comment
import com.ya.iticourse.databinding.CommentItemBinding


class CommentAdapter(var commentList:List<Comment>, var listener: MyCustomClickListener) :RecyclerView.Adapter<CommentAdapter.ViewHolder>(){
    inner class ViewHolder(val binding:CommentItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
         val binding = CommentItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
         return commentList.size
    }
    override fun onBindViewHolder(viewHolder: ViewHolder, position:Int){


    viewHolder.binding.postIdTv.text = "userId : ${commentList[position].postId}"
    viewHolder.binding.commentIdTv.text = "postId : ${commentList[position].id}"
    viewHolder.binding.bodyTv.text = "${commentList[position].body}"
    viewHolder.binding.nameTv.text = "${commentList[position].name}"
        viewHolder.binding.emailTv.text = "${commentList[position].email}"



    }

}
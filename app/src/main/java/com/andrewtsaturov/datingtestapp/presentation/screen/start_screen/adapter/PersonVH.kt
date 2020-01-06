package com.andrewtsaturov.datingtestapp.presentation.screen.start_screen.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.andrewtsaturov.datingtestapp.domain.etnity.Person
import com.andrewtsaturov.datingtestapp.presentation.screen.start_screen.OnPersonClickListener
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_people.view.*

class PersonVH(private val listener: OnPersonClickListener, itemView: View): RecyclerView.ViewHolder(itemView) {
    fun setItem(item: Person){
        itemView.item_start_person.apply {
            Glide.with(context)
                .load(item.imageUrl)
                //.apply(RequestOptions.circleCropTransform())//<= path of image
                .into(this)
        }
        itemView.setOnClickListener { listener.onPersonClick(adapterPosition) }
    }
}
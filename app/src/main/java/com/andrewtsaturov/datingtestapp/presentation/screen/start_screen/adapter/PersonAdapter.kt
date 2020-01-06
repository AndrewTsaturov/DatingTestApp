package com.andrewtsaturov.datingtestapp.presentation.screen.start_screen.adapter

import android.view.View
import androidx.viewpager.widget.PagerAdapter
import com.andrewtsaturov.datingtestapp.domain.etnity.Person
import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import com.andrewtsaturov.datingtestapp.R
import com.andrewtsaturov.datingtestapp.presentation.screen.start_screen.OnPersonClickListener
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_people.view.*


class PersonAdapter(private val listener: OnPersonClickListener): RecyclerView.Adapter<PersonVH>() {
    private val data = mutableListOf<Person>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PersonVH(listener, LayoutInflater.from(parent.context).inflate(R.layout.item_people,
        parent, false))

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: PersonVH, position: Int) = holder.setItem(data[position])

    fun updateData(persons: List<Person>){
        data.clear()
        data.addAll(persons)

        notifyDataSetChanged()
    }

    //    override fun instantiateItem(collection: ViewGroup, position: Int): Any {
//        val inflater = LayoutInflater.from(collection.context)
//        val layout = inflater.inflate(R.layout.item_people, collection, false)
//
//        layout.item_start_person.apply {
//            Glide.with(context)
//                .load(data[position].imageUrl)
//                .apply(RequestOptions.circleCropTransform())//<= path of image
//                .into(this)
//        }
//
//        layout.setOnClickListener { listener.onPersonClick(position) }
//
//        collection.addView(layout)
//
//        return layout
//    }

//    override fun destroyItem(collection: ViewGroup, position: Int, view: Any) {
//        collection.removeView(view as View)
//    }
//
//    override fun isViewFromObject(view: View, `object`: Any): Boolean {
//        return view === `object`
//    }

    //    override fun getCount(): Int = data.size
}
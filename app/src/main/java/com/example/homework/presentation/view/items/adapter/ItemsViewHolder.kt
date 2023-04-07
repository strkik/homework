package com.example.homework.presentation.view.items.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.homework.R
import com.example.homework.presentation.view.items.listener.ItemListener
import com.example.homework.model.ItemsModel

class ItemsViewHolder(private var view: View, private var itemListener: ItemListener) : RecyclerView.ViewHolder(view) {
    fun bind(itemsModel: ItemsModel){
        val tvDate = view.findViewById<TextView>(R.id.tvItemFruitDate)
        val tvText = view.findViewById<TextView>(R.id.tvItemFruitText)
        val image = view.findViewById<ImageView>(R.id.ivFruit)
        val star = view.findViewById<ImageView>(R.id.ivStar)
        var changeStar = true
        tvDate.text = itemsModel.date
        tvText.text = itemsModel.name
        image.setBackgroundResource(itemsModel.image)

        image.setOnClickListener(){
            itemListener.onCLick()

        }
        itemView.setOnClickListener(){
            itemListener.onElementSelected(itemsModel.image, itemsModel.date, itemsModel.name)
        }
        star.setOnClickListener{
            when(changeStar){
                true -> {star.setImageResource(R.drawable.star_blank)
                    changeStar = false}
                false -> {star.setImageResource(R.drawable.star)
                    changeStar = true}
            }
        }
    }
}
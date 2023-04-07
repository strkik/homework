package com.example.homework.data

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.homework.R
import com.example.homework.domain.ItemsRepository
import com.example.homework.model.ItemsModel
import java.time.LocalDateTime

class ItemsRepositoryImpl: ItemsRepository{
    @RequiresApi(Build.VERSION_CODES.O)
    override fun getData(): List<ItemsModel> {
        val listItems = listOf<ItemsModel>(
            ItemsModel(R.drawable.apple, "ЭПЛ1", "${LocalDateTime.now()}"),
            ItemsModel(R.drawable.apple, "ЭПЛ2", "${LocalDateTime.now()}"),
            ItemsModel(R.drawable.apple, "ЭПЛ3", "${LocalDateTime.now()}"),
            ItemsModel(R.drawable.apple, "ЭПЛ4", "${LocalDateTime.now()}"),
            ItemsModel(R.drawable.apple, "ЭПЛ5", "${LocalDateTime.now()}"),
            ItemsModel(R.drawable.apple, "ЭПЛ6", "${LocalDateTime.now()}"),
            ItemsModel(R.drawable.apple, "ЭПЛ7", "${LocalDateTime.now()}"),
            ItemsModel(R.drawable.apple, "ЭПЛ8", "${LocalDateTime.now()}"),
            ItemsModel(R.drawable.apple, "ЭПЛ9", "${LocalDateTime.now()}"),
            ItemsModel(R.drawable.apple, "ЭПЛ10", "${LocalDateTime.now()}"),
        )
    return listItems}

}
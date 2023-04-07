package com.example.homework.domain

import com.example.homework.model.ItemsModel

interface ItemsRepository {
    fun getData(): List<ItemsModel>
}
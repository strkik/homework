package com.example.homework.domain

import com.example.homework.model.ItemsModel

class ItemsInteractor(private val itemsRepository: ItemsRepository) {
    fun getData(): List<ItemsModel>{
        return itemsRepository.getData()
    }
}
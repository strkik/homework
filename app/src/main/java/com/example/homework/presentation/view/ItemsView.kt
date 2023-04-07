package com.example.homework.presentation.view

import com.example.homework.model.ItemsModel

interface ItemsView {
    fun dataReceived(list: List<ItemsModel>)
    fun imageViewClicked(msg: Int)
    fun goToDetails(image: Int, name: String, date: String)
}
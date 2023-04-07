package com.example.homework.presentation.view.items

import com.example.homework.R
import com.example.homework.domain.ItemsInteractor
import com.example.homework.model.ItemsModel
import com.example.homework.presentation.view.ItemsView

class ItemsPresenter(private val itemsView: ItemsView, private val itemsInteractor: ItemsInteractor) {
fun getData(){
    val list = itemsInteractor.getData()
    itemsView.dataReceived(list)

}
    fun imageViewClicked(){
        itemsView.imageViewClicked(R.string.value)
}
    fun elementSelected(image: Int, name: String, date: String){
        itemsView.goToDetails(image, name, date)
    }
    }
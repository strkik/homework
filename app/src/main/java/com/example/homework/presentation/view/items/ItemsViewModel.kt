package com.example.homework.presentation.view.items

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homework.R
import com.example.homework.domain.ItemsInteractor
import com.example.homework.model.ItemsModel

class ItemsViewModel(private val itemsInteractor: ItemsInteractor) : ViewModel() {
    private var _items = MutableLiveData<List<ItemsModel>>()
    val items: LiveData<List<ItemsModel>> = _items

    private var _msg = MutableLiveData<Int>()
    val msg: LiveData<Int> = _msg

    private var _bundle = MutableLiveData<NavigateWithBundle?>()
    val bundle: LiveData<NavigateWithBundle?> = _bundle

    fun getData() {
        val listItems = itemsInteractor.getData()
        _items.value = listItems
    }

    fun imageView() {
        _msg.value = R.string.image_view_clicked
    }

    fun elementClicked(image: Int, name: String, date: String) {
        _bundle.value = NavigateWithBundle(
            image = image,
            name = name,
            date = date
        )
    }
    fun userNavigated(){
        _bundle.value = null
    }
}

data class NavigateWithBundle(val image: Int, val name: String, val date: String) {

}
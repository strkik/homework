package com.example.homework.presentation.view.items

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.homework.domain.ItemsInteractor

class ItemsViewModelFactory(
    private val itemsInteractor: ItemsInteractor
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ItemsViewModel(itemsInteractor) as T
    }
}
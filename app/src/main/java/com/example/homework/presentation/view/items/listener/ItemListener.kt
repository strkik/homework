package com.example.homework.presentation.view.items.listener

import android.media.Image

interface ItemListener {
    fun onImageClick(){}
    fun onCLick(){}
    fun onElementSelected(image: Int, date: String, name: String){}
}
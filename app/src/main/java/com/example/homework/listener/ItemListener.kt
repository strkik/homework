package com.example.homework.listener

import android.media.Image

interface ItemListener {
    fun onImageClick(){}
    fun onCLick(){}
    fun onElementSelected(image: Int, data: String, name: String){}
}
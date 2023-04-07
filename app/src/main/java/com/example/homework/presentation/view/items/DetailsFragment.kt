package com.example.homework.presentation.view.items

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.homework.R
import com.example.homework.databinding.FragmentDetailsBinding
import com.example.homework.databinding.FragmentMainBinding


class DetailsFragment : Fragment() {
    private var _viewBinding: FragmentDetailsBinding? = null
    private val viewBinding get() = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _viewBinding = FragmentDetailsBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return viewBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val detailsName = view.findViewById<TextView>(R.id.detailsName)
        val detailsDate = view.findViewById<TextView>(R.id.detailsDate)
        val detailsImage = view.findViewById<ImageView>(R.id.detailsImage)

        val bundle = arguments

        bundle?.let { safeBundle ->
            detailsName.text = safeBundle.getString("name")
            detailsDate.text = safeBundle.getString("date")
            val image = safeBundle.getInt("imageVIew")
            detailsImage.setBackgroundResource(image)

        }
    }


}
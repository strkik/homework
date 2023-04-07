package com.example.homework.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.example.homework.R
import com.example.homework.databinding.FragmentItemsBinding
import com.example.homework.databinding.FragmentMainBinding
import com.example.homework.presentation.view.items.ItemsFragment


class MainFragment : Fragment() {
    private var _viewBinding: FragmentMainBinding? = null
    private val viewBinding get() = _viewBinding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _viewBinding = FragmentMainBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return viewBinding.root
        // Inflate the layout for this fragment
//            requireActivity().onBackPressedDispatcher.addCallback(this, object: OnBackPressedCallback(true){
//                override fun handleOnBackPressed() {
//                    activity?.finishAffinity()
//                }
//            }
//
        }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val alertDialog = AlertDialog.Builder(requireActivity())
            .setTitle("logib form")
            .setMessage("ВЫ  зашли успесшно")
            .setPositiveButton("OK"){_,_ -> }
        alertDialog.show()

        viewBinding.itemFruitBtn.setOnClickListener(){
            parentFragmentManager.beginTransaction()
                .replace(R.id.appContainer, ItemsFragment())
                .commit()
        }
    }

    }



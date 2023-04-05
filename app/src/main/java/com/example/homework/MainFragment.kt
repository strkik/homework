package com.example.homework

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog


class MainFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//            requireActivity().onBackPressedDispatcher.addCallback(this, object: OnBackPressedCallback(true){
//                override fun handleOnBackPressed() {
//                    activity?.finishAffinity()
//                }
//            }
//            )

        return inflater.inflate(R.layout.fragment_main, container, false)
        }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val alertDialog = AlertDialog.Builder(requireActivity())
            .setTitle("logib form")
            .setMessage("ВЫ  зашли успесшно")
            .setPositiveButton("OK"){_,_ -> }
        alertDialog.show()
        val itemFruitBtn = view.findViewById<Button>(R.id.itemFruitBtn)
        itemFruitBtn.setOnClickListener(){
            parentFragmentManager.beginTransaction()
                .replace(R.id.appContainer, ItemsFragment())
                .commit()
        }
    }

    }



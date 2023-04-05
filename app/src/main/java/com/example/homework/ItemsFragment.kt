package com.example.homework

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homework.adapter.ItemsAdapter
import com.example.homework.listener.ItemListener
import com.example.homework.model.ItemsModel
import java.time.LocalDateTime


class ItemsFragment : Fragment() , ItemListener{
    private lateinit var itemsAdapter: ItemsAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_items, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemsAdapter = ItemsAdapter(this)
        val rv = view.findViewById<RecyclerView>(R.id.rcView)
        rv.layoutManager = LinearLayoutManager(context)
        rv.adapter = itemsAdapter
        val listItems = listOf<ItemsModel>(
            ItemsModel(R.drawable.apple, "ЭПЛ1", "${LocalDateTime.now()}"),
            ItemsModel(R.drawable.apple, "ЭПЛ2", "${LocalDateTime.now()}"),
            ItemsModel(R.drawable.apple, "ЭПЛ3", "${LocalDateTime.now()}"),
            ItemsModel(R.drawable.apple, "ЭПЛ4", "${LocalDateTime.now()}"),
            ItemsModel(R.drawable.apple, "ЭПЛ5", "${LocalDateTime.now()}"),
            ItemsModel(R.drawable.apple, "ЭПЛ6", "${LocalDateTime.now()}"),
            ItemsModel(R.drawable.apple, "ЭПЛ7", "${LocalDateTime.now()}"),
            ItemsModel(R.drawable.apple, "ЭПЛ8", "${LocalDateTime.now()}"),
            ItemsModel(R.drawable.apple, "ЭПЛ9", "${LocalDateTime.now()}"),
            ItemsModel(R.drawable.apple, "ЭПЛ10", "${LocalDateTime.now()}"),
        )
        itemsAdapter.submitList(listItems.toList())
    }

    override fun onCLick() {
        Toast.makeText(context, "dfgdfg", Toast.LENGTH_SHORT).show()
    }

    override fun onElementSelected(image: Int, data: String, name: String) {
        val detailsFragment = DetailsFragment()
        val bundle = Bundle()
        bundle.putString("name", name)
        bundle.putString("date", data)
        bundle.putInt("imageVIew", image)
        detailsFragment.arguments = bundle

        //ADD method we will not use
        //We will use replace
        //replace always have addToBackstack to go back, or if we don't have addToBackstack we will not back
        parentFragmentManager.beginTransaction()
            .replace(R.id.appContainer, detailsFragment)
            .addToBackStack("Back")
            .commit()
    }

    override fun onImageClick() {
        val star = view?.findViewById<ImageView>(R.id.ivStar)
        star?.setImageResource(R.drawable.star)
    }


}
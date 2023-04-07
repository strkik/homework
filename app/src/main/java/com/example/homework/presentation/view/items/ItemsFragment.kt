package com.example.homework.presentation.view.items

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
import com.example.homework.R
import com.example.homework.data.ItemsRepositoryImpl
import com.example.homework.databinding.FragmentItemsBinding
import com.example.homework.domain.ItemsInteractor
import com.example.homework.presentation.view.items.adapter.ItemsAdapter
import com.example.homework.presentation.view.items.listener.ItemListener
import com.example.homework.model.ItemsModel
import com.example.homework.presentation.view.ItemsView
import java.time.LocalDateTime


class ItemsFragment : Fragment() , ItemListener, ItemsView {
    private lateinit var itemsPresenter: ItemsPresenter
    private var _viewBinding: FragmentItemsBinding? = null
    private val viewBinding get() = _viewBinding!!
    private lateinit var itemsAdapter: ItemsAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _viewBinding = FragmentItemsBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return viewBinding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemsPresenter = ItemsPresenter(this, ItemsInteractor(ItemsRepositoryImpl()))
        itemsAdapter = ItemsAdapter(this)
        viewBinding.rcView.layoutManager = LinearLayoutManager(context)
        viewBinding.rcView.adapter = itemsAdapter
        itemsPresenter.getData()
    }

    override fun onCLick() {
        itemsPresenter.imageViewClicked()
    }

    override fun onElementSelected(image: Int, date: String, name: String) {
    itemsPresenter.elementSelected(image, name, date)
    }

    override fun onImageClick() {
        val star = view?.findViewById<ImageView>(R.id.ivStar)
        star?.setImageResource(R.drawable.star)
    }

    override fun dataReceived(list: List<ItemsModel>) {
        itemsAdapter.submitList(list)
    }

    override fun imageViewClicked(msg: Int) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    override fun goToDetails(image: Int, name: String, date: String) {
        val detailsFragment = DetailsFragment()
        val bundle = Bundle()
        bundle.putString("name", name)
        bundle.putString("date", date)
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


}
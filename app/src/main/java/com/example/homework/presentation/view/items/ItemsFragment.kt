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
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework.R
import com.example.homework.data.ItemsRepositoryImpl
import com.example.homework.databinding.FragmentItemsBinding
import com.example.homework.domain.ItemsInteractor
import com.example.homework.presentation.view.items.adapter.ItemsAdapter
import com.example.homework.presentation.view.items.listener.ItemListener
import com.example.homework.model.ItemsModel


class ItemsFragment : Fragment(), ItemListener {
    private val viewModel: ItemsViewModel by viewModels{
        ItemsViewModelFactory(ItemsInteractor(ItemsRepositoryImpl()))
    }
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

        itemsAdapter = ItemsAdapter(this)
        viewBinding.rcView.layoutManager = LinearLayoutManager(context)
        viewBinding.rcView.adapter = itemsAdapter
        viewModel.getData()
        viewModel.items.observe(viewLifecycleOwner) {
            itemsAdapter.submitList(it)
        }
        viewModel.msg.observe(viewLifecycleOwner) {
            Toast.makeText(context, getString(it), Toast.LENGTH_SHORT).show()
        }
        viewModel.bundle.observe(viewLifecycleOwner) {
            if (it != null) {

                val detailsFragment = DetailsFragment()
                val bundle = Bundle()
                bundle.putString("name", it.name)
                bundle.putString("date", it.date)
                bundle.putInt("imageVIew", it.image)
                detailsFragment.arguments = bundle

                //ADD method we will not use
                //We will use replace
                //replace always have addToBackstack to go back, or if we don't have addToBackstack we will not back
                parentFragmentManager.beginTransaction()
                    .replace(R.id.appContainer, detailsFragment)
                    .addToBackStack("Back")
                    .commit()
                viewModel.userNavigated()
            }
        }
    }

    override fun onCLick() {
        viewModel.imageView()
    }

    override fun onElementSelected(image: Int, date: String, name: String) {
        viewModel.elementClicked(image, name, date)
    }
}


//    override fun onCLick() {
//viewModel.imageView()
//    }
//
//    override fun onElementSelected(image: Int, date: String, name: String) {
//
//    }
//
//    override fun onImageClick() {
//        val star = view?.findViewById<ImageView>(R.id.ivStar)
//        star?.setImageResource(R.drawable.star)
//    }

//    override fun dataReceived(list: List<ItemsModel>) {
//        itemsAdapter.submitList(list)
//    }
//
//    override fun imageViewClicked(msg: Int) {
//        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
//    }
//
//    override fun goToDetails(image: Int, name: String, date: String) {
//        val detailsFragment = DetailsFragment()
//        val bundle = Bundle()
//        bundle.putString("name", name)
//        bundle.putString("date", date)
//        bundle.putInt("imageVIew", image)
//        detailsFragment.arguments = bundle
//
//        //ADD method we will not use
//        //We will use replace
//        //replace always have addToBackstack to go back, or if we don't have addToBackstack we will not back
//        parentFragmentManager.beginTransaction()
//            .replace(R.id.appContainer, detailsFragment)
//            .addToBackStack("Back")
//            .commit()
//    }



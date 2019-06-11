package com.prokoshevnik.myapplication.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.prokoshevnik.backend.Item
import com.prokoshevnik.myapplication.R
import com.prokoshevnik.myapplication.factory.ItemViewFactory
import kotlinx.android.synthetic.main.item_details_layout.view.*

class ItemDetailsFragment : Fragment() {
    lateinit var item: Item

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.item_details_layout, container, false).also {
            ItemViewFactory.inflateViewForItem(item, inflater, it.itemDetails_detailsContainer)

            it.itemDetails_itemNameView.text =
                requireContext().getString(item.getRepresentationNameResId())

            it.setOnClickListener {
                requireActivity().supportFragmentManager.popBackStack()
            }
        }
    }
}

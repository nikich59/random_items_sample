package com.prokoshevnik.myapplication.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.prokoshevnik.backend.RandomItemGenerator
import com.prokoshevnik.myapplication.MainActivity
import com.prokoshevnik.myapplication.R
import kotlinx.android.synthetic.main.item_list_layout.view.*
import kotlinx.android.synthetic.main.item_simple_layout.view.*
import kotlin.random.Random

class ItemListFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.item_list_layout, container, false)

        fillList(view.itemList_listLayout, inflater)

        return view
    }

    private fun fillList(linearLayout: LinearLayout, inflater: LayoutInflater) {
        val random = Random(System.currentTimeMillis())

        for (item in RandomItemGenerator.generateItems(
            random,
            random.nextInt(ITEM_LIST_SIZE_MIN, ITEM_LIST_SIZE_MAX)
        )) {
            val view = inflater.inflate(R.layout.item_simple_layout, linearLayout, false)

            view.itemSimple_nameView.text = requireContext().getString(item.getRepresentationNameResId())
            view.itemSimple_detailsView.text = item.getDetailsRepresentation(requireContext())
            view.setOnClickListener {
                (requireActivity() as MainActivity).openItemDetails(item)
            }

            linearLayout.addView(view)
        }
    }

    companion object {
        private const val ITEM_LIST_SIZE_MIN = 10
        private const val ITEM_LIST_SIZE_MAX = 100
    }
}












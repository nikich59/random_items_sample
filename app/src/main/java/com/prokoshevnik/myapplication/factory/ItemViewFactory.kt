package com.prokoshevnik.myapplication.factory

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.prokoshevnik.backend.getRepresentation
import com.prokoshevnik.backend.item.Event
import com.prokoshevnik.backend.item.Move
import com.prokoshevnik.backend.item.Notice
import com.prokoshevnik.myapplication.R
import kotlinx.android.synthetic.main.item_event_layout.view.*
import kotlinx.android.synthetic.main.item_move_layout.view.*
import kotlinx.android.synthetic.main.item_notice_layout.view.*


object ItemViewFactory {
    fun inflateViewForItem(item: Any, inflater: LayoutInflater, container: ViewGroup): View {
        return when (item) {
            is Event -> {
                val view = inflater.inflate(R.layout.item_event_layout, container)

                view.itemEvent_startTimeView.text =
                    item.startTime?.getRepresentation(container.context) ?: container.context.getString(R.string.itemDataUnavailable)
                view.itemEvent_endTimeView.text =
                    item.endTime?.getRepresentation(container.context) ?: container.context.getString(R.string.itemDataUnavailable)
                view.itemEvent_nameView.text =
                    item.name ?: container.context.getString(R.string.itemDataUnavailable)

                view
            }
            is Move -> {
                val view = inflater.inflate(R.layout.item_move_layout, container)

                view.itemMove_fromPlaceView.text =
                    item.fromPlace ?: container.context.getString(R.string.itemDataUnavailable)
                view.itemMove_toPlaceView.text =
                    item.toPlace ?: container.context.getString(R.string.itemDataUnavailable)
                view.itemMove_estimatedTime.text =
                    item.estimatedTime?.getRepresentationString(container.context)
                        ?: container.context.getString(R.string.itemDataUnavailable)

                view
            }
            is Notice -> {
                val view = inflater.inflate(R.layout.item_notice_layout, container)

                view.itemNotice_flightDateView.text =
                    item.flightDate?.getRepresentation(container.context) ?: container.context.getString(R.string.itemDataUnavailable)
                view.itemNotice_gateView.text =
                    item.gate ?: container.context.getString(R.string.itemDataUnavailable)

                view
            }
            else ->
                throw RuntimeException("Views for item class ${item::class.java} are not implemented")
        }
    }
}











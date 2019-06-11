package com.prokoshevnik.backend.item

import android.content.Context
import com.prokoshevnik.backend.Item
import com.prokoshevnik.backend.R
import com.prokoshevnik.backend.getRepresentation
import java.util.*


data class Notice(
    val flightDate: Calendar? = null,
    val gate: String? = null
) : Item {
    override fun getDetailsRepresentation(context: Context) =
        context.getString(R.string.itemNoticeDetailsTemplate).format(
            flightDate.getRepresentation(context),
            gate
        )

    override fun getRepresentationNameResId() = R.string.itemNoticeRepresentationName
}


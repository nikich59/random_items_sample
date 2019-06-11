package com.prokoshevnik.backend.item

import android.content.Context
import com.prokoshevnik.backend.Item
import com.prokoshevnik.backend.R
import com.prokoshevnik.backend.TimeInterval

class Move : Item {
    override fun getDetailsRepresentation(context: Context) =
        context.getString(R.string.itemMoveDetailsTemplate).format(
            fromPlace,
            toPlace,
            estimatedTime?.getRepresentationString(context) ?: context.getString(R.string.timeIntervalUnavailable)
        )

    override fun getRepresentationNameResId() = R.string.itemMoveRepresentationName

    var fromPlace: String? = null
    var toPlace: String? = null
    var estimatedTime: TimeInterval? = null

    constructor(
        fromPlace: String?,
        toPlace: String?,
        estimatedTime: TimeInterval?
    ) {
        this.fromPlace = fromPlace
        this.toPlace = toPlace
        this.estimatedTime = estimatedTime
    }
}

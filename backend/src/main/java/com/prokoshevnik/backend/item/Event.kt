package com.prokoshevnik.backend.item

import android.content.Context
import com.prokoshevnik.backend.Item
import com.prokoshevnik.backend.R
import com.prokoshevnik.backend.getRepresentation
import java.util.*

class Event : Item {
    override fun getDetailsRepresentation(context: Context) =
        context.getString(R.string.itemEventDetailsTemplate).format(
            startTime.getRepresentation(context),
            endTime.getRepresentation(context),
            name
        )

    override fun getRepresentationNameResId() = R.string.itemEventRepresentationName

    var startTime: Calendar? = null
    var endTime: Calendar? = null
    var name: String? = null

    constructor(
        startTime: Calendar?,
        endTime: Calendar?,
        name: String?
    ) {
        this.startTime = startTime
        this.endTime = endTime
        this.name = name
    }
}


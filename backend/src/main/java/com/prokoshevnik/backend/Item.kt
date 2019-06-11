package com.prokoshevnik.backend

import android.content.Context
import java.util.*

interface Item {
    fun getRepresentationNameResId(): Int

    fun getDetailsRepresentation(context: Context): String
}

fun Calendar?.getRepresentation(context: Context): String {
    return if (this == null) {
        context.getString(R.string.calendarUnavailable)
    } else {
        context.getString(R.string.calendarRepresentationTemplate).format(
            get(Calendar.DAY_OF_MONTH),
            get(Calendar.MONTH),
            get(Calendar.YEAR),
            get(Calendar.HOUR_OF_DAY),
            get(Calendar.MINUTE)
        )
    }
}

package com.prokoshevnik.backend

import android.content.Context


data class TimeInterval(
    val fromTime: Time,
    val toTime: Time
) {
    fun getRepresentationString(context: Context) =
        context.getString(R.string.timeIntervalTemplate).format(
            fromTime.getRepresentationString(context),
            toTime.getRepresentationString(context)
        )
}

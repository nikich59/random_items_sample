package com.prokoshevnik.backend

import android.content.Context


data class Time(
    val hours: Int,
    val minutes: Int
) {
    fun getRepresentationString(context: Context) =
        context.getString(R.string.timeTemplate).format(hours, minutes)

    fun isAfter(other: Time) =
        hours > other.hours || (hours == other.hours && minutes > other.minutes)
}


package com.prokoshevnik.backend

import java.util.*
import kotlin.random.Random

object RandomUtils {
    fun getRandomDate(random: Random) =
        Calendar.getInstance().apply {
            set(Calendar.YEAR, random.nextInt(1980, 2040))
            set(Calendar.HOUR_OF_DAY, random.nextInt(24))
            set(Calendar.MINUTE, random.nextInt(60))
            set(Calendar.MILLISECOND, 0)

            add(Calendar.DATE, random.nextInt(365))
        }

    fun getRandomGate(random: Random) =
        "${'A' + random.nextInt(24)}${random.nextInt(64)}"

    fun getRandomEventName(random: Random) =
        getRandomString(random, 16)

    fun getRandomString(random: Random, length: Int): String {
        val stringBuilder = StringBuilder()

        for (charIndex in 0 until length) {
            stringBuilder.append('A' + random.nextInt(24))
        }

        return stringBuilder.toString()
    }

    fun getRandomTimeInterval(random: Random): TimeInterval {
        val time1 = getRandomTime(random)
        val time2 = getRandomTime(random)

        return if (time2.isAfter(time1)) {
            TimeInterval(time1, time2)
        } else {
            TimeInterval(time2, time1)
        }
    }

    fun getRandomTime(random: Random) =
        Time(
            random.nextInt(24),
            random.nextInt(60)
        )
}

















package com.prokoshevnik.backend

import com.prokoshevnik.backend.item.Event
import com.prokoshevnik.backend.item.Move
import com.prokoshevnik.backend.item.Notice
import kotlin.random.Random

object RandomItemGenerator {
    private const val ITEM_TYPE_COUNT = 3


    fun generateItems(random: Random, count: Int): List<Item> {
        return arrayListOf<Item>().apply {
            for (itemIndex in 0 until count) {
                add(generateItem(random, random.nextInt(ITEM_TYPE_COUNT)))
            }
        }
    }

    private fun generateItem(random: Random, itemType: Int) =
        when (itemType) {
            0 ->
                generateRandomEvent(random)
            1 ->
                generateRandomMove(random)
            2 ->
                generateRandomNotice(random)
            else ->
                throw RuntimeException("Random generation of item indexed $itemType is not implemented")
        }

    private fun generateRandomNotice(random: Random) =
        Notice(
            RandomUtils.getRandomDate(random),
            RandomUtils.getRandomGate(random)
        )

    private fun generateRandomMove(random: Random) =
        Move(
            RandomUtils.getRandomString(random, 16),
            RandomUtils.getRandomString(random, 16),
            RandomUtils.getRandomTimeInterval(random)
        )

    private fun generateRandomEvent(random: Random) =
        Event(
            RandomUtils.getRandomDate(random),
            RandomUtils.getRandomDate(random),
            RandomUtils.getRandomEventName(random)
        )
}













package com.prokoshevnik.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.prokoshevnik.backend.Item
import com.prokoshevnik.myapplication.fragment.ItemDetailsFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openItemDetails(item: Item) {
        val fragment = ItemDetailsFragment()
        fragment.item = item

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.activityMain_itemListFragment, fragment)

        fragmentTransaction.addToBackStack(fragment.toString())

        fragmentTransaction.commit()
    }
}

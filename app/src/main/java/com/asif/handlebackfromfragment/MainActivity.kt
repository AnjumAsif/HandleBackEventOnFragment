package com.asif.handlebackfromfragment

import android.os.Bundle
import androidx.fragment.app.FragmentTransaction

class MainActivity : BaseActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment(FirstFragment())
    }

    private fun loadFragment(firstFragment: FirstFragment) {

        val transaction: FragmentTransaction =
            supportFragmentManager.beginTransaction()
        transaction.replace(R.id.layoutContainer, firstFragment)
        transaction.commit()
    }

}

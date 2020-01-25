package com.asif.handlebackfromfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

open class BaseActivity : AppCompatActivity() {

    public override fun onBackPressed() {
        val fragmentList = supportFragmentManager.fragments

        var handled = false
        for (f in fragmentList) if (f is BaseFragment) {
            handled = f.onBackPressed()

            if (handled) {
                break
            }
        }

        if (!handled) {
            super.onBackPressed()
        }
    }
}

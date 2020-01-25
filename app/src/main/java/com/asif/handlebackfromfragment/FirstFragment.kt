package com.asif.handlebackfromfragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.fragment_first.view.*

class FirstFragment : BaseFragment(), View.OnClickListener {
    private val openedLine: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_first, container, false)
        view.buttonPost1.setOnClickListener(this)
        return view
    }
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.buttonPost1 -> {
                loadFragment(SecondFragment())
            }

        }
    }

    private fun loadFragment(firstFragment: Fragment) {

        val transaction: FragmentTransaction =
            activity!!.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.layoutContainer, firstFragment)
        transaction.commit()
    }

    /**
     * Back pressed send from activity.
     *
     * @return if event is consumed, it will return true.
     */
    override fun onBackPressed(): Boolean {
        if (openedLine < 0) {
            return false
        } else {
            Toast.makeText(activity, "First fragment", Toast.LENGTH_SHORT).show()
            return true
        }
    }

}

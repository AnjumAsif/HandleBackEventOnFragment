package com.asif.handlebackfromfragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragment : BaseFragment() {
    private val openedLine: Int = 1

    private fun loadFragment(firstFragment: Fragment) {
        val transaction: FragmentTransaction =
            activity!!.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.layoutContainer, firstFragment)
        transaction.commit()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
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
            loadFragment(FirstFragment())
            Toast.makeText(activity, "Second fragment", Toast.LENGTH_SHORT).show()
            return true
        }
    }
}

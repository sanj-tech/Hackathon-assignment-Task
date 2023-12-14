package com.example.digitalflakedemo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.digitalflakedemo.R
import com.example.digitalflakedemo.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    lateinit var homeBinding: FragmentHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeBinding =
            FragmentHomeBinding.inflate(LayoutInflater.from(context))
        val view: View = homeBinding.root
        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bookingHistory()
        bookWorkStation()

    }

    private fun bookWorkStation() {
        homeBinding.ivBookWorkStation.setOnClickListener({
            homeBinding.llBooking.visibility = View.INVISIBLE
            loadFragment(BookWorkStationFragment())
        })
    }

    private fun bookingHistory() {
        homeBinding.btnBookinHistory.setOnClickListener({
            homeBinding.llBooking.visibility = View.INVISIBLE
            loadFragment(BookingHistoryFragment())

        })
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = activity?.supportFragmentManager!!.beginTransaction()
        transaction.replace(R.id.bookingContainer, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


}



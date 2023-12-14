package com.example.digitalflakedemo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.digitalflakedemo.R
import com.example.digitalflakedemo.adapters.BookHistoryAdapter
import com.example.digitalflakedemo.databinding.FragmentBookingHistoryBinding
import com.example.digitalflakedemo.models.BookHistoryModel

class BookingHistoryFragment : Fragment() {
    lateinit var bookingHistoryBinding: FragmentBookingHistoryBinding
    var historyList: MutableList<BookHistoryModel> = mutableListOf()
    lateinit var bookHistoryAdapter: BookHistoryAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bookingHistoryBinding =
            FragmentBookingHistoryBinding.inflate(LayoutInflater.from(context))
        val view: View = bookingHistoryBinding.root
        // Inflate the layout for this fragment

        return view

    }

    //Load Home Fragment
    private fun moveHistoryFragment() {
        bookingHistoryBinding.ivBack.setOnClickListener({
            activity?.supportFragmentManager?.popBackStack()
            loadData(HomeFragment())
        })
    }

    private fun loadData(homeFragment: HomeFragment) {
        val transaction = activity?.supportFragmentManager!!.beginTransaction()
        transaction.replace(R.id.bookingContainer, homeFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showUserListData()
        moveHistoryFragment()
    }

    private fun showUserListData() {
        historyList = ArrayList()
        bookHistoryAdapter = BookHistoryAdapter(requireContext(), historyList)
        bookingHistoryBinding.bookHistoryRv.adapter = bookHistoryAdapter



        historyList.clear()
        historyList.add(
            BookHistoryModel(
                "12345",
                "Tushar Patil",

                "28 may 2022 at 12:00PM",
            )
        )
        historyList.add(
            BookHistoryModel(
                "12345",
                "Tushar Patil",

                "28 may 2022 at 12:00PM",
            )
        )
        historyList.add(
            BookHistoryModel(
                "12345",
                "Tushar Patil",

                "28 may 2022 at 12:00PM",
            )
        )
        historyList.add(
            BookHistoryModel(
                "12345",
                "Tushar Patil",

                "28 may 2022 at 12:00PM",
            )
        )
        historyList.add(
            BookHistoryModel(
                "12345",
                "Tushar Patil",

                "28 may 2022 at 12:00PM",
            )
        )
        historyList.add(
            BookHistoryModel(
                "12345",
                "Tushar Patil",

                "28 may 2022 at 12:00PM",
            )
        )
        historyList.add(
            BookHistoryModel(
                "12345",
                "Tushar Patil",

                "28 may 2022 at 12:00PM",
            )
        )
    }
}

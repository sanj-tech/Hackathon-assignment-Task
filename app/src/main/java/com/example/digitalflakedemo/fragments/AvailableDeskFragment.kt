package com.example.digitalflakedemo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.digitalflakedemo.ConfirmationDialog
import com.example.digitalflakedemo.R
import com.example.digitalflakedemo.databinding.FragmentAvailableDeskBinding


class AvailableDeskFragment : Fragment() {
    lateinit var availableBookDeskBinding: FragmentAvailableDeskBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        availableBookDeskBinding =
            FragmentAvailableDeskBinding.inflate(LayoutInflater.from(context))
        val view: View = availableBookDeskBinding.root

        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        BookDesk()
        moveBack()
    }

    private fun moveBack() {
        availableBookDeskBinding.callAvailableDesk.setOnClickListener({
            activity?.supportFragmentManager?.popBackStack()
            loadData(BookWorkStationFragment())
        })
    }

    private fun loadData(bookWorkStationFragment: BookWorkStationFragment) {
        val transaction = activity?.supportFragmentManager!!.beginTransaction()
        transaction.replace(R.id.bookingContainer, bookWorkStationFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun BookDesk() {
        availableBookDeskBinding.btnBookDesk.setOnClickListener({
            view?.let { it1 -> showAlert(it1) }

        })
    }

    fun showAlert(view: View) {
        ConfirmationDialog().show(requireActivity().supportFragmentManager, "dialog")
    }
}


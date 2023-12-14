package com.example.digitalflakedemo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.digitalflakedemo.adapters.CalendarAdapter
import com.example.digitalflakedemo.databinding.FragmentBookWorkStationBinding
import com.example.digitalflakedemo.models.CalendarItem
import java.text.SimpleDateFormat
import java.util.*


class BookWorkStationFragment : Fragment() {
    lateinit var workStationBinding: FragmentBookWorkStationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        workStationBinding =
            FragmentBookWorkStationBinding.inflate(LayoutInflater.from(context))
        val view: View = workStationBinding.root
        // Inflate the layout for this fragment

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        moveNext()
        moveBack()
        ShowCalander()
    }

    private fun generateCalendarItems(
        currentMonth: Int,
        currentYear: Int
    ): MutableList<CalendarItem> {
        val calendarItems = mutableListOf<CalendarItem>()
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.YEAR, currentMonth)
        calendar.set(Calendar.MONTH, currentMonth)
        calendar.set(Calendar.DAY_OF_MONTH, 1) // Start from the first day of the month

        val daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        for (i in 1..daysInMonth) {

            calendar.set(Calendar.DAY_OF_MONTH, i)
            val day = i.toString()
            val month = SimpleDateFormat("MMM", Locale.getDefault()).format(calendar.time)
            val dayOfWeek = SimpleDateFormat("EE", Locale.getDefault()).format(calendar.time)

            val isSelected = true // Set initial selection status as needed
            calendarItems.add(CalendarItem( month, day, dayOfWeek, isSelected))


        }
        return calendarItems
    }

    //Show Calendar
    private fun ShowCalander() {


        val layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        workStationBinding.rvCalander.layoutManager = layoutManager

        val currentMonth = Calendar.getInstance().get(Calendar.MONTH)
        val currentYear = Calendar.getInstance().get(Calendar.YEAR)
        val calendarItems = generateCalendarItems(currentMonth, currentYear)

        val adapter = CalendarAdapter(calendarItems as List<CalendarItem>)
        workStationBinding.rvCalander.adapter = adapter
    }

    private fun moveBack() {
        workStationBinding.ivCallBack.setOnClickListener({
            activity?.supportFragmentManager?.popBackStack()
            loadData(HomeFragment())
        })
    }

    private fun loadData(homeFragment: HomeFragment) {
        val transaction = activity?.supportFragmentManager!!.beginTransaction()
        transaction.replace(com.example.digitalflakedemo.R.id.bookingContainer, homeFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun moveNext() {
        workStationBinding.btnNext.setOnClickListener({
            CheckAvailabledesks()
        })
    }

    private fun CheckAvailabledesks() {
        workStationBinding.llSelectDate.visibility = View.INVISIBLE
        loadFragment(AvailableDeskFragment())
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = activity?.supportFragmentManager!!.beginTransaction()
        transaction.replace(com.example.digitalflakedemo.R.id.flSelectDateContainer, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


}

package com.example.digitalflakedemo.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.digitalflakedemo.R
import com.example.digitalflakedemo.models.CalendarItem


class CalendarAdapter(private val items: List<CalendarItem>) :
    RecyclerView.Adapter<CalendarAdapter.CalendarViewHolder>() {
    var onDateClickListener: ((CalendarItem) -> Unit)? = null

    inner class CalendarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Bind views here
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.calendar_item, parent, false)
        return CalendarViewHolder(view)
    }

    override fun onBindViewHolder(holder: CalendarViewHolder, position: Int) {
        val item = items[position]
        // Bind data to views in ViewHolder
        holder.itemView.findViewById<TextView>(R.id.monthTextView).text = item.month
        holder.itemView.findViewById<TextView>(R.id.dateTextView).text = item.date
        holder.itemView.findViewById<TextView>(R.id.dayOfWeek).text = item.dayOfWeek

        holder.itemView.findViewById<TextView>(R.id.calendarText).apply {
            text = item.month
            //setBackgroundColor(if (item.isSelected) Color.BLUE else Color.WHITE)
            // Handle item click/change background color
            setOnClickListener {
                // Handle item click event here
                // Example: Toggle item selection on click
                item.isSelected = !item.isSelected
                notifyItemChanged(holder.adapterPosition)

                holder.itemView.setOnClickListener {
                    // Handle item click event here
                    onDateClickListener?.invoke(item)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
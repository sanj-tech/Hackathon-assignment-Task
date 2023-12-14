package com.example.digitalflakedemo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.digitalflakedemo.R
import com.example.digitalflakedemo.databinding.CustomItemViewBinding
import com.example.digitalflakedemo.models.BookHistoryModel

class BookHistoryAdapter(var context: Context, var historyList: MutableList<BookHistoryModel>) :
    RecyclerView.Adapter<BookHistoryAdapter.BookHistoryViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookHistoryViewHolder {
        var binding: CustomItemViewBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.custom_item_view, parent, false
        )
        return BookHistoryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return historyList.size
    }

    override fun onBindViewHolder(holder: BookHistoryViewHolder, position: Int) {
        var historyList = historyList[position]
        holder.binding.tvId.text = historyList.deskId
        holder.binding.tvName.text = historyList.name
        holder.binding.tvInfoDate.text = historyList.bookedDate
    }

    class BookHistoryViewHolder(val binding: CustomItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }
}
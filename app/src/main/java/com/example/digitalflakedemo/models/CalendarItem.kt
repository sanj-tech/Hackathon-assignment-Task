package com.example.digitalflakedemo.models

data class CalendarItem(val month: String,
                        val date: String,
                        val dayOfWeek: String,
                        var isSelected: Boolean)
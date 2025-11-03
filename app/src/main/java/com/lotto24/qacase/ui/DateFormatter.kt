package com.lotto24.qacase.ui

import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

object DateFormatter {
    fun format(dateString: String): String {
        return try {
            val inputFormatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME
            val outputFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy",
                Locale.getDefault())
            val dateTime = OffsetDateTime.parse(dateString, inputFormatter)
            dateTime.format(outputFormatter)
        } catch (e: Exception) {
            // Return the original string if formatting fails
            dateString
        }
    }
}
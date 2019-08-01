package br.com.tmovies.common.extensions

import java.text.SimpleDateFormat

fun String.formatStrDate(baseFormat: String, newFormat: String): String? {
    return this.takeIf { !isNullOrEmpty() }.run {
        val newFormat = SimpleDateFormat(newFormat)
        val date = SimpleDateFormat(baseFormat).parse(this)
        newFormat.format(date)
    }
}
package br.com.tmovies.common.extensions

import android.widget.ImageView
import com.squareup.picasso.Picasso

fun ImageView.loadImageUrl(url: String?) {
    if (url.isNullOrEmpty()) {
        setImageBitmap(null) //todo set blank image
        return
    }

    Picasso.with(context).load(url).fit().into(this)
}
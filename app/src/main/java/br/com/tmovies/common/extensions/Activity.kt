package br.com.tmovies.common.extensions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.startFeatureActivity(activityPath: String) {
    val basePath = "br.com.tmovies"
    val intent = Intent().apply {
        action = Intent.ACTION_VIEW
        setClassName(basePath, basePath.plus(".$activityPath"))
    }
    startActivity(intent)
}

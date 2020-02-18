package com.rud.movieapp.view.base

import android.content.Context
import android.content.Intent
import android.os.Bundle

const val EXTRA_ARG = "_args"


fun <T> Context.openActivity(it: Class<T>, extras: Bundle.() -> Unit = {}) {
    val intent = Intent(this, it)
    intent.putExtra(EXTRA_ARG, Bundle().apply(extras))
    startActivity(intent)
}


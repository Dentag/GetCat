package com.dentag.getcat.ui

import android.view.View

interface Router {
    fun goToCat(url: String, view: View)
}

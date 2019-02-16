package com.example.socialearth.viewmodel

import android.support.design.widget.BottomNavigationView
import android.databinding.BindingMethod
import android.databinding.BindingMethods


@BindingMethods(
    BindingMethod(
        type = BottomNavigationView::class,
        attribute = "app:onNavigationItemSelected",
        method = "OnNavigationItemSelectedListener"
    )
)
open class DataBindingAdapter{}

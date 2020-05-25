package com.github.vsbauer.libraryapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.github.vsbauer.libraryapp.R
import kotlinx.android.synthetic.main.main_activity.*


class MainActivity : AppCompatActivity(R.layout.main_activity) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bottom_navigation.setupWithNavController(findNavController(R.id.navigation_container))
    }
}

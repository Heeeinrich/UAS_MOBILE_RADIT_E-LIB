package com.example.uasmobileradite_lib

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set edge-to-edge layout
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContentView(R.layout.activity_register)

        // Ensure the root view has an ID of 'main'
        val rootView = findViewById<View>(R.id.main)

        // Apply window insets to the root view
        ViewCompat.setOnApplyWindowInsetsListener(rootView) { view, insets ->
            val systemBarsInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.updatePadding(
                left = systemBarsInsets.left,
                top = systemBarsInsets.top,
                right = systemBarsInsets.right,
                bottom = systemBarsInsets.bottom
            )
            WindowInsetsCompat.CONSUMED
        }
    }
}

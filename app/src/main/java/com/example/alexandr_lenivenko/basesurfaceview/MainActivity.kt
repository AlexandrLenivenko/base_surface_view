package com.example.alexandr_lenivenko.basesurfaceview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.alexandr_lenivenko.testnew.custom_surface_view.BackgroundCustomView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val backgroundCustomView = findViewById<BackgroundCustomView>(R.id.sv_background)
        lifecycle.addObserver(backgroundCustomView)
    }
}

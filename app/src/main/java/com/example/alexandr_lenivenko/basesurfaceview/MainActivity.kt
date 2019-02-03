package com.example.alexandr_lenivenko.basesurfaceview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.alexandr_lenivenko.testnew.custom_surface_view.ShapeCustomView
import com.example.alexandr_lenivenko.testnew.custom_surface_view.ShapeCustomView.Companion.CIRCLE
import com.example.alexandr_lenivenko.testnew.custom_surface_view.ShapeCustomView.Companion.RECTANGLE

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val shapeCustomView = findViewById<ShapeCustomView>(R.id.sv_background)
        lifecycle.addObserver(shapeCustomView)

        findViewById<View>(R.id.btn_circle).setOnClickListener { shapeCustomView.shape = CIRCLE }
        findViewById<View>(R.id.btn_rect).setOnClickListener { shapeCustomView.shape = RECTANGLE }
    }
}

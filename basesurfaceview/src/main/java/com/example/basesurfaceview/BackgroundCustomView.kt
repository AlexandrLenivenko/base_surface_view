package com.example.alexandr_lenivenko.testnew.custom_surface_view

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet


class BackgroundCustomView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : BaseCustomSurfaceView(context, attrs, defStyleAttr) {

    init {
        if (!isInEditMode()) {

        }

    }

    override fun onDrawView(canvas: Canvas) {

    }

}
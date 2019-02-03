package com.example.alexandr_lenivenko.testnew.custom_surface_view

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.GradientDrawable
import android.support.annotation.IntDef
import android.util.AttributeSet
import com.example.basesurfaceview.R
import com.example.basesurfaceview.createGradianteDrawable


class ShapeCustomView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : BaseCustomSurfaceView(context, attrs, defStyleAttr) {
    private lateinit var shapeBitmap: GradientDrawable

    @Shape
    var shape = CIRCLE
        set(value) {
            if (shape == value) {
                return
            }

            field = value
            changeShape()
            needRedraw = true
        }

    init {
        if (!isInEditMode()) {
            changeShape()
        }

    }

    override fun onDrawView(canvas: Canvas) {
        //canvas.drawBitmap(shapeBitmap, (measuredHeight/2).toFloat(), (measuredWidth/2).toFloat(), paint)
        shapeBitmap.setBounds(0, 0, measuredWidth / 4, measuredWidth / 4)
        shapeBitmap.draw(canvas)
    }

    private fun changeShape() {
        shapeBitmap = resources.createGradianteDrawable(
                when (shape) {
                    CIRCLE -> R.drawable.circle
                    RECTANGLE -> R.drawable.rectangle
                    else -> R.drawable.circle
                }
        )
    }


    companion object {

        @IntDef(RECTANGLE, CIRCLE)
        @Retention(AnnotationRetention.SOURCE)
        annotation class Shape

        const val RECTANGLE = 0
        const val CIRCLE = 1
    }


}
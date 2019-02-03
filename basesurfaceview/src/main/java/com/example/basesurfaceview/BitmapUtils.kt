package com.example.basesurfaceview

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Matrix
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.VectorDrawable
import android.support.annotation.DrawableRes

fun Resources.getBitmapFromVectorDrawable(@DrawableRes imageId: Int): Bitmap {

    val drawable = getDrawable(imageId)
    return if (drawable is VectorDrawable) {
        createBitmapFromVectorDrawable(drawable)
    } else {
        BitmapFactory.decodeResource(this, imageId)
    }
}

fun Resources.createGradianteDrawable(@DrawableRes imageId: Int): GradientDrawable {
    val drawable = getDrawable(imageId)
    return if (drawable is GradientDrawable) {
        drawable
    } else {
        throw Exception("wrong type")
    }
}

private fun createBitmapFromVectorDrawable(vectorDrawable: VectorDrawable): Bitmap {
    val bitmap = Bitmap.createBitmap(vectorDrawable.intrinsicWidth,
            vectorDrawable.intrinsicHeight, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(bitmap)
    vectorDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight())
    vectorDrawable.draw(canvas)
    return bitmap
}

fun Bitmap.rotate(degrees: Float): Bitmap {
    val matrix = Matrix().apply { postRotate(degrees) }
    return Bitmap.createBitmap(this, 0, 0, width, height, matrix, true)
}
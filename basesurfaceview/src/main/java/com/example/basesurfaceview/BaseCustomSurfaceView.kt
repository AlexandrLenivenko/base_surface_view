package com.example.alexandr_lenivenko.testnew.custom_surface_view

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.SurfaceView
import java.lang.Exception

abstract class BaseCustomSurfaceView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
): SurfaceView(context, attrs, defStyleAttr), Runnable, LifecycleObserver {
    private var thread: Thread? = null
    private var isItOk = false
    protected var needRedraw = true
    private val paint: Paint = Paint()

    init {
        paint.strokeWidth = 20f
    }

    override fun run() {
        while ( isItOk) {
            if(!holder.surface.isValid || !needRedraw) continue
            val canvas = holder.lockCanvas()
            onDrawView(canvas)
            needRedraw = false
            holder.unlockCanvasAndPost(canvas)
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun resume() {
        isItOk = true
        thread = Thread(this).apply { start() }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun pause() {
        isItOk = false
        while (true) {
            try {
                thread?.join()
            }catch (e: Exception) {
                e.printStackTrace()
            }
            break
        }
        thread?.interrupt()
        thread = null
    }

    abstract fun onDrawView(canvas: Canvas)
}

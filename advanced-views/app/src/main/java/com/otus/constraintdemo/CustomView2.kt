package com.otus.constraintdemo

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View

class CustomView2(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {
    val TAG = "CustomView"
    val paint : Paint
    var defaultWidth = 450

    val list = ArrayList<Int>()
    var maxValue : Int = 0
    var widthPerView = 0
    var heightPerValue = 0

    init {
        paint = Paint()
        paint.color = Color.GRAY
        paint.strokeWidth = 10f
    }
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val widthMode = MeasureSpec.getMode(widthMeasureSpec);
        val widthSize = MeasureSpec.getSize(widthMeasureSpec);
        val heightMode = MeasureSpec.getMode(heightMeasureSpec);
        val heightSize = MeasureSpec.getSize(heightMeasureSpec);
        if (widthMode == MeasureSpec.UNSPECIFIED) {
            Log.d(TAG, "onMeasure UNSPECIFED")
            setMeasuredDimension(if (list.size == 0) 0 else defaultWidth * list.size, heightSize)
            widthPerView = if (list.size == 0) 0 else defaultWidth

        } else if (widthMode == MeasureSpec.AT_MOST) {
            Log.d(TAG, "onMeasure AT_MOST")

        } else if (widthMode == MeasureSpec.EXACTLY){
            Log.d(TAG, "onMeasure EXACTLY")
            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
            widthPerView = if (list.size > 0) measuredWidth / list.size else 0
        }

        heightPerValue = if (maxValue > 0) measuredHeight / maxValue else 0

        Log.d(TAG, "onMeasure")
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)

        Log.d(TAG, "onLayout")
    }

    override fun onDraw(canvas: Canvas?) {
        if (list.size == 0) return

        var currentX = 0

        //Log.d(TAG, widthPerView.toString())
        //Log.d(TAG, heightPerValue.toString())

        for (item in list) {
            canvas?.drawRect(currentX.toFloat(), (height - heightPerValue * item).toFloat(), (currentX + widthPerView).toFloat(), height.toFloat(), paint)
            currentX += widthPerView
            if (paint.color == Color.GRAY) paint.color = Color.MAGENTA else paint.color = Color.GRAY
        }


        Log.d(TAG, "onDraw")
    }

    fun setValues(values : List<Int>) {
        Log.d(TAG, "setValues")

        list.clear()
        list.addAll(values)

        maxValue = list.max() ?: 0
        //widthPerView = if (list.size > 0) measuredWidth / list.size else 0
        //heightPerValue = if (maxValue > 0) measuredHeight / maxValue else 0

        requestLayout()
        invalidate()
    }
}
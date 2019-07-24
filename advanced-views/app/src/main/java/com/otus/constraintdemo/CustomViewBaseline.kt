package com.otus.constraintdemo

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout

class CustomViewBaseline : FrameLayout {
    val TAG = "CustomViewBaseline"

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        init(context)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()

        Log.d(TAG, "onFinishInflate")
    }

    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr : Int) : super(context, attributeSet, defStyleAttr) {
        init(context)
    }

    private fun init(context: Context) {
        Log.d(TAG, "constructor")
        LayoutInflater.from(context).inflate(R.layout.view_baseline, this, true)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        Log.d(TAG, "onAttachedToWindow")
    }
    override fun getBaseline(): Int {
        return findViewById<View>(R.id.image_view).measuredHeight
    }
}
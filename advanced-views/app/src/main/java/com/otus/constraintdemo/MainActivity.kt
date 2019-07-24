package com.otus.constraintdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main_0.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_0)

        helloWorld.setOnClickListener {
            customView.setValues(listOf(5, 3, 1, 4, 1, 0, 3))
        }

        /*hello_world.setOnClickListener {
            view_stub.visibility = View.VISIBLE
        }*/
    }
}

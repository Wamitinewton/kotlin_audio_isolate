package com.example.audio_kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.audio_kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)

       setContentView(activityMainBinding.root)
    }

//    override fun onBackPressed() {
//        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.Q) {
//
//            finishAfterTransition()
//        } else {
//            super.onBackPressed()
//        }
//    }
}

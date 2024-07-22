package com.example.audio_kotlin.fragments

import org.tensorflow.lite.support.label.Category

interface AudioClassificationListener{
    fun onError(error: String)
    fun onResult(results: List<Category>, inferenceTime: Long)
}
package com.example.audio_kotlin.fragments

import androidx.fragment.app.Fragment
import com.example.audio_kotlin.AudioClassificationHelper
import com.example.audio_kotlin.databinding.FragmentAudioBinding
import org.tensorflow.lite.support.label.Category

interface AudioClassificationListener{
    fun onError(error: String)
    fun onResult(results: List<Category>, inferenceTime: Long)
}

class AudioFragment : Fragment() {
    private var _fragmentBinding: FragmentAudioBinding? = null
    private val fragmentAudioBinding get() = _fragmentBinding!!
    private val adapter by lazy { // calling the probability adapter here
    }

    private lateinit var audioHelper: AudioClassificationHelper

    private val audioClassificationListener = object: AudioClassificationHelper {
        override fun onResult(results: List<Category>, inferenceTime: Long) {
            requireActivity().runOnUiThread {
                adapter.categoryList = results
            }
        }
    }
}
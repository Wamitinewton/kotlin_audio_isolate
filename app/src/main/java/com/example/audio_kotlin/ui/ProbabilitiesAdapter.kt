package com.example.audio_kotlin.ui

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.audio_kotlin.R
import com.example.audio_kotlin.databinding.ItemProbabilityBinding
import org.tensorflow.lite.support.label.Category

internal class ProbabilitiesAdapter: RecyclerView.Adapter<ProbabilitiesAdapter.ViewHolder>() {
    var categoryList: List<Category> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder{
        val binding =
            ItemProbabilityBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ViewHolder(binding)

    }

    override fun onBindingViewHolder(holder: ViewHolder, position: Int){
        val category = categoryList[position]
        holder.bind(category.label, category.score, category.index)
    }

    class ViewHolder(private val binding: ItemProbabilityBinding) :
            RecyclerView.ViewHolder(binding.root){
                private var primaryProgressColorList: IntArray
                private var backgroundProgressColorList: IntArray

                init {
                    primaryProgressColorList =
                        binding.root.resources.getIntArray((R.array.colors_progress_primary))
                    backgroundProgressColorList =
                        binding.root.resources.getIntArray((R.array.colors_progress_background))
                }

        fun bind(label: String, score: Float, index: Int){
            with(binding) {
                labelTextView.text = label

                progressBar.progressBackgroundTintList =
                    ColorStateList.valueOf(
                        backgroundProgressColorList[index % backgroundProgressColorList.size]
                    )

                progressBar.progressTintList =
                    ColorStateList.valueOf(
                        primaryProgressColorList[index % primaryProgressColorList.size]

                    )
                val newValue = (score * 100).toInt()
                progressBar.progress = newValue
            }
        }
            }
}
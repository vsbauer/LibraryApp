package com.github.vsbauer.libraryapp.ui.recommendation

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.github.vsbauer.libraryapp.R

class RecommendationFragment : Fragment(R.layout.fragment_recommendation) {

    private lateinit var viewModel: RecommendationViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RecommendationViewModel::class.java)
    }

}

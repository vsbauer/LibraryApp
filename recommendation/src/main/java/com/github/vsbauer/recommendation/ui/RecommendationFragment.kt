package com.github.vsbauer.recommendation.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.vsbauer.core_api.AppWithAppProvider
import com.github.vsbauer.recommendation.R
import com.github.vsbauer.recommendation.ui.di.RecommendationFragmentComponent
import kotlinx.android.synthetic.main.fragment_recommendation.*
import javax.inject.Inject


class RecommendationFragment : Fragment(R.layout.fragment_recommendation) {

    private val recommendationAdapter = RecommendationAdapter(
        onItemClicked = {
            onItemClicked(it)
        }
    )

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: RecommendationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        RecommendationFragmentComponent.create((requireActivity().application as AppWithAppProvider).getAppProvider())
            .inject(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this, viewModelFactory)[RecommendationViewModel::class.java]

        recycler_recommend.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = recommendationAdapter
        }

        viewModel.getBooks("Android").observe(viewLifecycleOwner, Observer {
            recommendationAdapter.updateData(it)
        })
    }

    private fun onItemClicked(link: String) {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(link)))
    }

}

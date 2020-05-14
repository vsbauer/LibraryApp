package com.github.vsbauer.libraryapp.ui.recommendation

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.vsbauer.libraryapp.R
import dagger.android.support.AndroidSupportInjection
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

    val viewModel: RecommendationViewModel by viewModels {
        viewModelFactory
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

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

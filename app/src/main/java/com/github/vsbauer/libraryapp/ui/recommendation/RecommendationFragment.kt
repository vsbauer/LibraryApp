package com.github.vsbauer.libraryapp.ui.recommendation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.vsbauer.libraryapp.R
import kotlinx.android.synthetic.main.fragment_recommendation.*


class RecommendationFragment : Fragment(R.layout.fragment_recommendation) {
    private val recommendationAdapter = RecommendationAdapter(
        onItemClicked = {
            onItemClicked(it)
        }
    )

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val viewModel: RecommendationViewModel =
            ViewModelProvider(this).get(RecommendationViewModel::class.java)

        recycler_recommend.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = recommendationAdapter
        }

        viewModel.getBooks("Android").observe(viewLifecycleOwner, Observer {
            recommendationAdapter.updateData(it)
        })
    }

    private fun onItemClicked(link: String) {
        val myIntent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
        startActivity(myIntent)
    }

}

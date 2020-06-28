package com.github.vsbauer.search.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.vsbauer.core_api.AppWithAppProvider
import com.github.vsbauer.search.R
import com.github.vsbauer.search.ui.di.SearchFragmentComponent
import kotlinx.android.synthetic.main.fragment_recommendation.*
import javax.inject.Inject


class SearchFragment : Fragment(R.layout.fragment_recommendation) {

    private val recommendationAdapter = SearchAdapter(
        onItemClicked = {
            onItemClicked(it)
        }
    )

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: SearchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SearchFragmentComponent.create((requireActivity().application as AppWithAppProvider).getAppProvider())
            .inject(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this, viewModelFactory)[SearchViewModel::class.java]

        recycler_search.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = recommendationAdapter
        }

        edit_txt_search.addTextChangedListener {
            //todo
        }

        viewModel.getBooks("Android").observe(viewLifecycleOwner, Observer {
            recommendationAdapter.updateData(it)
        })
    }

    private fun onItemClicked(link: String) {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(link)))
    }

}

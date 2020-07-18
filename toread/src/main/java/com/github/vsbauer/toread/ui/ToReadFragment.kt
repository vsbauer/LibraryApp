package com.github.vsbauer.toread.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.vsbauer.core_api.AppWithAppProvider
import com.github.vsbauer.toread.R
import com.github.vsbauer.toread.di.ToReadFragmentComponent
import kotlinx.android.synthetic.main.fragment_toread.*
import javax.inject.Inject


class ToReadFragment : Fragment(R.layout.fragment_toread) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: ToReadViewModel

    private val toReadAdapter = ToReadAdapter(
        onItemClicked = {
            onItemClicked(it.link)
        },
        onRemoveClicked = {
            viewModel.removeBook(it)
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ToReadFragmentComponent.create((requireActivity().application as AppWithAppProvider).getAppProvider())
            .inject(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[ToReadViewModel::class.java]

        recycler_toread.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = toReadAdapter
        }
        viewModel.getBooks().observe(viewLifecycleOwner, Observer {
            toReadAdapter.updateData(it)
        })
    }

    private fun onItemClicked(link: String) {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(link)))
    }
}
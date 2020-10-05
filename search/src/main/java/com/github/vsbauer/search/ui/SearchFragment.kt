package com.github.vsbauer.search.ui

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.vsbauer.core.models.Book
import com.github.vsbauer.core_api.AppWithAppProvider
import com.github.vsbauer.search.R
import com.github.vsbauer.search.di.SearchFragmentComponent
import kotlinx.android.synthetic.main.fragment_search.*
import javax.inject.Inject


class SearchFragment : Fragment(R.layout.fragment_search) {

    private val searchAdapter = SearchAdapter(
        onItemClicked = {
            onItemClicked(it)
        },
        onItemFav = { book: Book ->
            viewModel.saveBook(book)
            Toast.makeText(context, "Book is saved!", Toast.LENGTH_LONG).show()
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
            layoutManager = LinearLayoutManager(requireContext())
            adapter = searchAdapter
        }

        searchBooks("Book")

        edit_txt_search.apply {
            onFocusChangeListener = View.OnFocusChangeListener { v, hasFocus ->
                if (!hasFocus) {
                    (requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?)
                        ?.hideSoftInputFromWindow(v.windowToken, 0)
                }
            }
            addTextChangedListener {
                searchBooks(it?.toString())
            }
        }
    }

    private fun searchBooks(request: String?) {
        request?.let {
            if (request.length > 2) {
                viewModel.getBooks(request)
                    .observe(viewLifecycleOwner, Observer { list ->
                        searchAdapter.updateData(list)
                    })
            }
        }

    }

    private fun onItemClicked(link: String) {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(link)))
    }

}

package com.github.vsbauer.search.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.vsbauer.core.models.GoogleBook
import com.github.vsbauer.search.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.search_item.view.*

class SearchAdapter(val onItemClicked: (link: String) -> Unit) :
    RecyclerView.Adapter<SearchAdapter.ViewHolder>() {
    private val data = ArrayList<GoogleBook>()

    fun updateData(list: List<GoogleBook>) {
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.search_item, parent, false)
        )


    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(googleBook: GoogleBook) {
            itemView.apply {
                txt_name.text = googleBook.tittle
                txt_author.text = googleBook.author
                Picasso.get().load(googleBook.img).into(img_book)
                setOnClickListener {
                    onItemClicked(googleBook.link)
                }

            }
        }
    }
}
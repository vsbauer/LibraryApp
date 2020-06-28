package com.github.vsbauer.search.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.vsbauer.core.models.Book
import com.github.vsbauer.search.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recommendation_item.view.*

class SearchAdapter(val onItemClicked: (link: String) -> Unit) :
    RecyclerView.Adapter<SearchAdapter.ViewHolder>() {
    private val data = ArrayList<Book>()

    fun updateData(list: List<Book>) {
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recommendation_item, parent, false)
        )


    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(book: Book) {
            itemView.apply {
                txt_name.text = book.tittle
                txt_author.text = book.author
                Picasso.get().load(book.img).into(img_book)
                setOnClickListener {
                    onItemClicked(book.link)
                }

            }
        }
    }
}
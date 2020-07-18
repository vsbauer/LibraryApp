package com.github.vsbauer.toread.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.vsbauer.core.models.Book
import com.github.vsbauer.toread.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.toread_item.view.*


class ToReadAdapter(
    private val onItemClicked: (book: Book) -> Unit,
    private val onRemoveClicked: (book: Book) -> Unit
) :
    RecyclerView.Adapter<ToReadAdapter.ViewHolder>() {
    private val data = ArrayList<Book>()

    fun updateData(list: List<Book>) {
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.toread_item, parent, false))

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
                btn_remove.setOnClickListener {
                    onRemoveClicked(book)
                    data.remove(book)
                    notifyDataSetChanged()
                }
                setOnClickListener {
                    onItemClicked(book)
                }
            }
        }
    }
}
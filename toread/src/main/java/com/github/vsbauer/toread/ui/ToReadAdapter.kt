package com.github.vsbauer.toread.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.recyclerview.widget.RecyclerView
import com.github.vsbauer.core.models.Book
import com.github.vsbauer.toread.R
import kotlinx.android.synthetic.main.toread_item.view.*


class ToReadAdapter(val onItemClicked: (book: Book) -> Unit) :
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
        holder.bind(data[position], position)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(book: Book, position: Int) {
            itemView.apply {
                checkbox_toread.setOnCheckedChangeListener { _: CompoundButton, flag: Boolean ->
                    if (flag) {
                        data.remove(book)
                        data.add(book)
                        notifyItemMoved(position, data.size - 1)
                    } else {
                        data.remove(book)
                        data.add(0, book)
                        notifyItemMoved(position, 0)
                    }
                }

                txt_name.text = book.tittle
                txt_author.text = book.author

                setOnClickListener {
                    onItemClicked(book)
                }

            }
        }
    }
}
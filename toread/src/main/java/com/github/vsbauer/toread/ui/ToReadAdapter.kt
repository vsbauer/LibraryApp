package com.github.vsbauer.toread.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.recyclerview.widget.RecyclerView
import com.github.vsbauer.core.models.GoogleBook
import com.github.vsbauer.toread.R
import kotlinx.android.synthetic.main.toread_item.view.*


class ToReadAdapter(val onItemClicked: (googleBook: GoogleBook) -> Unit) :
    RecyclerView.Adapter<ToReadAdapter.ViewHolder>() {
    private val data = ArrayList<GoogleBook>()

    fun updateData(list: List<GoogleBook>) {
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

        fun bind(googleBook: GoogleBook, position: Int) {
            itemView.apply {
                checkbox_toread.setOnCheckedChangeListener { _: CompoundButton, flag: Boolean ->
                    if (flag) {
                        data.remove(googleBook)
                        data.add(googleBook)
                        notifyItemMoved(position, data.size - 1)
                    } else {
                        data.remove(googleBook)
                        data.add(0, googleBook)
                        notifyItemMoved(position, 0)
                    }
                }

                txt_name.text = googleBook.tittle
                txt_author.text = googleBook.author

                setOnClickListener {
                    onItemClicked(googleBook)
                }

            }
        }
    }
}
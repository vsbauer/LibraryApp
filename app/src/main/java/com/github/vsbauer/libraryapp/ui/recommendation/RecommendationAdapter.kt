package com.github.vsbauer.libraryapp.ui.recommendation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.vsbauer.libraryapp.R
import com.github.vsbauer.libraryapp.data.models.Item
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recommendation_item.view.*

class RecommendationAdapter(val onItemClicked: (link: String) -> Unit) :
    RecyclerView.Adapter<RecommendationAdapter.ViewHolder>() {
    private val data = ArrayList<Item>()

    fun updateData(list: List<Item>) {
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

        fun bind(item: Item?) {
            itemView.apply {
                item?.volumeInfo?.run {
                    txt_name.text = title
                    txt_author.text = if (authors.isNullOrEmpty()) "None" else authors.first()
                    Picasso.get().load(imageLinks.thumbnail).into(img_book)
                    setOnClickListener {
                        onItemClicked(infoLink)
                    }
                }

            }
        }
    }
}
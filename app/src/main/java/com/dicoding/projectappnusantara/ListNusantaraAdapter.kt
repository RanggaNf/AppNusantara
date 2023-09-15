package com.dicoding.projectappnusantara

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListNusantaraAdapter(private val list: List<Nusantara>) : RecyclerView.Adapter<ListNusantaraAdapter.ListViewHolder>() {

    private var onItemClickCallback: OnItemClickCallback? = null

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        private val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
        private val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)

        fun bind(nusantara: Nusantara) {
            tvName.text = nusantara.name
            tvDescription.text = nusantara.description
            imgPhoto.setImageResource(nusantara.photo)
        }

        init {
            itemView.setOnClickListener {
                onItemClickCallback?.onItemClicked(list[adapterPosition])
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Nusantara)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_nusantara, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
}

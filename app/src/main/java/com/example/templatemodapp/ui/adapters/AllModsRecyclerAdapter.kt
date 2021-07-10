package com.example.templatemodapp.ui.adapters

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.templatemodapp.R
import com.example.templatemodapp.ui.data.models.Mod
import com.example.templatemodapp.utils.inflate
import com.example.templatemodapp.utils.loadImage
import com.google.android.material.card.MaterialCardView

class AllModsRecyclerAdapter(private val listener: Listener) :
    RecyclerView.Adapter<AllModsRecyclerAdapter.ViewHolder>() {

    private var dataList = listOf<Mod>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflatedView = parent.inflate(R.layout.item_mod, false)
        return ViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.bind(item)
    }

    override fun getItemCount() = dataList.size

    fun setData(list: List<Mod>) {
        dataList = list
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val cvMod = view.findViewById<MaterialCardView>(R.id.cvMod)
        private val imgModIcon = view.findViewById<ImageView>(R.id.imgModIcon)

        fun bind(data: Mod) {
            cvMod.setOnClickListener {
                listener.onItemClicked(data)
            }
            imgModIcon.loadImage(data.icon)
        }
    }

    interface Listener {
        fun onItemClicked(item: Mod)
    }
}

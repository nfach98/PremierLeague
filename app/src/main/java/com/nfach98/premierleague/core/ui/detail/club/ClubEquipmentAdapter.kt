package com.nfach98.premierleague.core.ui.detail.club

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nfach98.premierleague.R
import com.nfach98.premierleague.core.domain.model.Equipment
import com.nfach98.premierleague.databinding.ItemEquipmentBinding
import com.squareup.picasso.Picasso
import java.util.*

class ClubEquipmentAdapter : RecyclerView.Adapter<ClubEquipmentAdapter.ListViewHolder>() {

    private var listData = ArrayList<Equipment>()
    var onItemClick: ((Equipment) -> Unit)? = null

    fun setData(newListData: List<Equipment>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_equipment, parent, false))

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemEquipmentBinding.bind(itemView)
        fun bind(data: Equipment) {
            with(binding) {
                Picasso.get().load("${data.strEquipment}/preview").into(binding.ivEquipment)
                when(data.strType) {
                    "1st" -> tvEquipment.text = "Home Kit"
                    "2nd" -> tvEquipment.text = "Away Kit"
                    else -> tvEquipment.text = "${data.strType} Kit"
                }
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}
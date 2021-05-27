package com.nfach98.premierleague.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nfach98.premierleague.R
import com.nfach98.premierleague.core.domain.model.Table
import com.nfach98.premierleague.databinding.ItemTableHomeBinding
import com.squareup.picasso.Picasso
import java.util.*

class HomeTableAdapter : RecyclerView.Adapter<HomeTableAdapter.ListViewHolder>() {

    private var listData = ArrayList<Table>()
    var onItemClick: ((Table) -> Unit)? = null

    fun setData(newListData: List<Table>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_table_home, parent, false))

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemTableHomeBinding.bind(itemView)
        fun bind(data: Table) {
            with(binding) {
                Picasso.get().load("${data.teamBadge}/tiny").into(binding.ivTeam)
                tvPos.text = (listData.indexOf(data) + 1).toString()
                tvTeam.text = data.name
                tvPlay.text = data.played.toString()
                tvGd.text =
                    if(data.goalsdifference > 0) "+${data.goalsdifference}"
                    else data.goalsdifference.toString()
                tvPoint.text = data.total.toString()
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}
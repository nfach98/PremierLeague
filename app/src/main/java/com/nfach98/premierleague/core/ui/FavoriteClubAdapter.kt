package com.nfach98.premierleague.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nfach98.premierleague.R
import com.nfach98.premierleague.core.domain.model.Club
import com.nfach98.premierleague.databinding.ItemClubFavoriteBinding
import com.squareup.picasso.Picasso
import java.util.*

class FavoriteClubAdapter : RecyclerView.Adapter<FavoriteClubAdapter.ListViewHolder>() {

    private var listData = ArrayList<Club>()
    var onItemClick: ((Club) -> Unit)? = null

    fun setData(newListData: List<Club>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_club_favorite, parent, false))

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemClubFavoriteBinding.bind(itemView)
        fun bind(data: Club) {
            with(binding) {
                Picasso.get().load("${data.strTeamBadge}/tiny").into(binding.ivTeam)
                tvName.text = data.strTeam
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}
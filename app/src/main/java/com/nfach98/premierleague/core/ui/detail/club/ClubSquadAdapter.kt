package com.nfach98.premierleague.core.ui.detail.club

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nfach98.premierleague.R
import com.nfach98.premierleague.core.domain.model.Player
import com.nfach98.premierleague.databinding.ItemPlayerClubBinding
import com.squareup.picasso.Picasso
import java.util.*

class ClubSquadAdapter : RecyclerView.Adapter<ClubSquadAdapter.ListViewHolder>() {

    private var listData = ArrayList<Player>()
    var onItemClick: ((Player) -> Unit)? = null

    fun setData(newListData: List<Player>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_player_club, parent, false))

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemPlayerClubBinding.bind(itemView)
        fun bind(data: Player) {
            with(binding) {
                Picasso.get()
                    .load("${data.strCutout}/preview")
                    .placeholder(R.drawable.placeholder_player)
                    .error(R.drawable.placeholder_player)
                    .into(binding.ivPlayer)
                tvName.text = data.strPlayer
                tvNumber.text = data.strNumber
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}
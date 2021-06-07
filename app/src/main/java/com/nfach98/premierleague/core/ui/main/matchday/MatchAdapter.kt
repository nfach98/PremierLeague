package com.nfach98.premierleague.core.ui.main.matchday

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nfach98.premierleague.R
import com.nfach98.premierleague.core.domain.model.Match
import com.nfach98.premierleague.databinding.ItemMatchdayBinding
import com.squareup.picasso.Picasso
import java.util.*

class MatchAdapter : RecyclerView.Adapter<MatchAdapter.ListViewHolder>() {

    private var listData = ArrayList<Match>()
    var onItemClick: ((Match) -> Unit)? = null

    fun setData(newListData: List<Match>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_matchday, parent, false))

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemMatchdayBinding.bind(itemView)
        fun bind(data: Match) {
            with(binding) {
                Picasso.get().load("${data.strHomeTeamBadge}/tiny").into(binding.ivTeamHome)
                tvTeamHome.text = data.strHomeTeamShort

                Picasso.get().load("${data.strAwayTeamBadge}/tiny").into(binding.ivTeamAway)
                tvTeamAway.text = data.strAwayTeamShort

                tvTime.text = data.strResult
                if(data.intHomeScore != "" && data.intAwayScore != "") {
                    tvTime.text = "${data.intHomeScore} - ${data.intAwayScore}"
                }
                else{
                    bgScore.visibility = View.INVISIBLE
                    tvTime.text = data.strTime?.substring(0, data.strTime.length - 3)
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
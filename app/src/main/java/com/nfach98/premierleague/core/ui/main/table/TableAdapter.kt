package com.nfach98.premierleague.core.ui.main.table

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.nfach98.premierleague.R
import com.nfach98.premierleague.core.domain.model.Table
import com.nfach98.premierleague.databinding.ItemTableLookupBinding
import com.squareup.picasso.Picasso
import java.util.*

class TableAdapter : RecyclerView.Adapter<TableAdapter.ListViewHolder>() {

    private var listData = ArrayList<Table>()
    var onItemClick: ((Table) -> Unit)? = null

    fun setData(newListData: List<Table>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_table_lookup, parent, false))

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemTableLookupBinding.bind(itemView)
        fun bind(data: Table) {
            with(binding) {
                Picasso.get().load(data.strTeamBadge).into(binding.ivTeam)
                tvPos.text = (listData.indexOf(data) + 1).toString()
                tvTeam.text = data.strTeam
                tvPlay.text = data.intPlayed
                tvWin.text = data.intWin
                tvDraw.text = data.intDraw
                tvLoss.text = data.intLoss
                tvGd.text = data.intGoalDifference
                tvPoint.text = data.intPoints

                when {
                    data.strDescription?.contains(Regex("Champions League")) == true -> {
                        bar.setBackgroundColor(Color.parseColor("#010A85"))
                    }
                    data.strDescription?.contains(Regex("Europa League")) == true -> {
                        bar.setBackgroundColor(Color.parseColor("#F16B07"))
                    }
                    data.strDescription?.contains(Regex("Europa Conference League")) == true -> {
                        bar.setBackgroundColor(Color.parseColor("#00BF0C"))
                    }
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
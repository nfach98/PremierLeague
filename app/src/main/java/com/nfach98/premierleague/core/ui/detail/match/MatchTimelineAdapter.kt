package com.nfach98.premierleague.core.ui.detail.match

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nfach98.premierleague.R
import com.nfach98.premierleague.core.domain.model.Timeline
import com.nfach98.premierleague.databinding.ItemTimelineBinding
import java.util.*

class MatchTimelineAdapter(val context: Context): RecyclerView.Adapter<MatchTimelineAdapter.ListViewHolder>() {

    private var listData = ArrayList<Timeline>()
    var onItemClick: ((Timeline) -> Unit)? = null

    fun setData(newListData: List<Timeline>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_timeline, parent, false))

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemTimelineBinding.bind(itemView)
        fun bind(data: Timeline) {
            with(binding) {
                if(listData.indexOf(data) == 0) binding.lineTop.visibility = View.INVISIBLE
                if(listData.indexOf(data) == listData.size - 1) binding.lineBottom.visibility = View.INVISIBLE

                val icon = when{
                    data.strTimeline == "Goal" && data.strTimelineDetail == "Own Goal"-> R.drawable.ic_ball_red_24dp
                    data.strTimeline == "Goal" && data.strTimelineDetail == "Missed Penalty"-> R.drawable.ic_baseline_close_24
                    data.strTimeline == "Goal" -> R.drawable.ic_ball_black_24dp
                    data.strTimeline == "subst" -> R.drawable.ic_substitution_24dp
                    data.strTimeline == "Card" && data.strTimelineDetail == "Yellow Card" -> R.drawable.ic_yellow_card_24dp
                    data.strTimeline == "Card" && data.strTimelineDetail == "Red Card" -> R.drawable.ic_red_card_24dp
                    else -> R.drawable.bg_circle
                }

                var detail = ""
                when(data.strTimelineDetail) {
                    "Own Goal" -> {
                        detail = "(${data.strTimelineDetail})"
                        tvSubLeft.setTextColor(context.resources.getColor(R.color.red_utility))
                        tvSubRight.setTextColor(context.resources.getColor(R.color.red_utility))
                    }
                    "Missed Penalty" -> {
                        detail = "(${data.strTimelineDetail})"
                        tvSubLeft.setTextColor(context.resources.getColor(R.color.red_utility))
                        tvSubRight.setTextColor(context.resources.getColor(R.color.red_utility))
                    }
                    else -> detail = data.strAssist.toString()
                }

                ivIcon.setImageResource(icon)

                if(data.strHome == "Yes") {
                    tvTimeLeft.text = "${data.intTime}\'"
                    tvNameLeft.text = data.strPlayer
                    tvSubLeft.text = detail
                }
                else {
                    tvTimeRight.text = "${data.intTime}\'"
                    tvNameRight.text = data.strPlayer
                    tvSubRight.text = detail
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
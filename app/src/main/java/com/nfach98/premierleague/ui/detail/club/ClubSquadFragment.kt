package com.nfach98.premierleague.ui.detail.club

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.nfach98.premierleague.R
import com.nfach98.premierleague.core.data.Resource
import com.nfach98.premierleague.core.domain.model.Player
import com.nfach98.premierleague.core.ui.TeamSquadAdapter
import com.nfach98.premierleague.databinding.FragmentClubSquadBinding
import com.nfach98.premierleague.ui.detail.player.PlayerActivity
import com.squareup.picasso.Picasso
import org.koin.android.viewmodel.ext.android.viewModel

class ClubSquadFragment(private val id: String?) : Fragment() {

    private val clubViewModel: ClubViewModel by viewModel()

    private var _binding: FragmentClubSquadBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentClubSquadBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null && id != null) {
            val squadAdapter = TeamSquadAdapter()

            squadAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, PlayerActivity::class.java)
                intent.putExtra(PlayerActivity.EXTRA_ID, selectedData.idPlayer)
                startActivity(intent)
            }

            clubViewModel.getSquad(id).observe(viewLifecycleOwner, { players ->
                if(players != null){
                    when(players){
                        is Resource.Success -> {
                            val squad = players.data?.filter { it.strPosition != "Manager" }
                            val manager = players.data?.filter { it.strPosition == "Manager" }

                            binding.tvNameManager.text = manager?.get(0)?.strPlayer
                            Picasso.get()
                                .load("${manager?.get(0)?.strCutout}/preview")
                                .placeholder(R.drawable.placeholder_player)
                                .error(R.drawable.placeholder_player)
                                .into(binding.ivManager)

                            squadAdapter.setData(squad)
                        }
                        else -> {

                        }
                    }
                }
            })

            with(binding.rvPlayers) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(false)
                adapter = squadAdapter
            }
        }
    }
}
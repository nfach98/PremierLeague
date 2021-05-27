package com.nfach98.premierleague.ui.detail.club

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.nfach98.premierleague.BuildConfig
import com.nfach98.premierleague.core.data.Resource
import com.nfach98.premierleague.core.ui.TeamEquipmentAdapter
import com.nfach98.premierleague.databinding.FragmentClubOverviewBinding
import org.koin.android.viewmodel.ext.android.viewModel


class ClubOverviewFragment(private val id: String?) : Fragment() {

    private val clubViewModel: ClubViewModel by viewModel()

    private var _binding: FragmentClubOverviewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentClubOverviewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null && id != null) {
            val equipmentAdapter = TeamEquipmentAdapter()

            clubViewModel.getTeam(id).observe(viewLifecycleOwner, { team ->
                if (team != null) {
                    when (team) {
                        is Resource.Success -> {
                            val data = team.data?.get(0)

                            binding.tvVisitTeam.text = "Visit ${data?.strAlternate}"

                            if (data?.strWebsite != null && data.strWebsite != "") {
                                binding.btnWebsite.visibility = View.VISIBLE
                                binding.btnWebsite.setOnClickListener {
                                    startActivity(Intent(
                                        Intent.ACTION_VIEW,
                                        Uri.parse(
                                            if(data.strWebsite!!.startsWith("https://")) data.strWebsite
                                            else "https://${data.strWebsite}"
                                        )
                                    ))
                                }
                            }

                            if (data?.strFacebook != null && data.strFacebook != ""){
                                binding.btnFacebook.visibility = View.VISIBLE
                                binding.btnFacebook.setOnClickListener {
                                    startActivity(Intent(
                                        Intent.ACTION_VIEW,
                                        Uri.parse(
                                            if(data.strFacebook!!.startsWith("https://")) data.strFacebook
                                            else "https://${data.strFacebook}"
                                        )
                                    ))
                                }
                            }

                            if (data?.strYoutube != null && data.strTwitter != ""){
                                binding.btnTwitter.visibility = View.VISIBLE
                                binding.btnTwitter.setOnClickListener {
                                    startActivity(Intent(
                                        Intent.ACTION_VIEW,
                                        Uri.parse(
                                            if(data.strTwitter!!.startsWith("https://")) data.strTwitter
                                            else "https://${data.strTwitter}"
                                        )
                                    ))
                                }
                            }

                            if (data?.strYoutube != null && data.strYoutube != ""){
                                binding.btnYoutube.visibility = View.VISIBLE
                                binding.btnYoutube.setOnClickListener {
                                    startActivity(Intent(
                                        Intent.ACTION_VIEW,
                                        Uri.parse(
                                            if(data.strYoutube!!.startsWith("https://")) data.strYoutube
                                            else "https://${data.strYoutube}"
                                        )
                                    ))
                                }
                            }

                            if (data?.strInstagram != null && data.strInstagram != ""){
                                binding.btnInstagram.visibility = View.VISIBLE
                                binding.btnInstagram.setOnClickListener {
                                    startActivity(Intent(
                                        Intent.ACTION_VIEW,
                                        Uri.parse(
                                            if(data.strInstagram!!.startsWith("https://")) data.strInstagram
                                            else "https://${data.strInstagram}"
                                        )
                                    ))
                                }
                            }

                            binding.tvDescription.text = data?.strDescriptionEN

                            binding.tvNickname.text = data?.strKeywords
                            binding.tvFormedYear.text = data?.intFormedYear
                            binding.tvStadium.text = data?.strStadium
                            binding.tvLocation.text = data?.strStadiumLocation
                            binding.tvCapacity.text = data?.intStadiumCapacity

                            showLeague(binding.tvLeague, data?.strLeague)
                            showLeague(binding.tvLeague2, data?.strLeague2)
                            showLeague(binding.tvLeague3, data?.strLeague3)
                            showLeague(binding.tvLeague4, data?.strLeague4)
                            showLeague(binding.tvLeague5, data?.strLeague5)
                            showLeague(binding.tvLeague6, data?.strLeague6)
                            showLeague(binding.tvLeague7, data?.strLeague7)
                        }
                        else -> {

                        }
                    }
                }
            })

            clubViewModel.getEquipment(id).observe(viewLifecycleOwner, { equipments ->
                if(equipments != null){
                    when(equipments){
                        is Resource.Success -> {
                            val equipmentSeason = equipments.data?.filter { it.strSeason == BuildConfig.SEASON_ID }
                            equipmentAdapter.setData(equipmentSeason)
                        }
                        else -> {

                        }
                    }
                }
            })

            with(binding.rvKits) {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                setHasFixedSize(true)
                adapter = equipmentAdapter
            }
        }
    }

    private fun showLeague(view: TextView, text: String?) {
        if(text == null || text == "") view.visibility = View.GONE
        else view.text = text
    }
}
package com.nfach98.premierleague.ui.detail.player

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.nfach98.premierleague.R
import com.nfach98.premierleague.core.data.Resource
import com.nfach98.premierleague.databinding.ActivityPlayerBinding
import com.squareup.picasso.Picasso
import org.koin.android.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

class PlayerActivity : AppCompatActivity() {
    private val playerViewModel: PlayerViewModel by viewModel()

    private var _binding: ActivityPlayerBinding? = null
    private val binding get() = _binding!!

    companion object {
        const val EXTRA_ID = "extra_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.homeNoBg.setOnClickListener { finish() }

        val id = intent.getStringExtra(EXTRA_ID)

        if (id != null) {
            playerViewModel.getPlayer(id).observe(this, { players ->
                if(players != null){
                    when(players){
                        is Resource.Success -> {
                            val data = players.data?.get(0)
                            val club = playerViewModel.clubs?.filter { t -> t.idTeam == data?.idTeam }
                            data?.strTeamBadge = club?.get(0)?.strTeamBadge

                            Picasso.get()
                                .load("${data?.strTeamBadge}/tiny")
                                .into(binding.ivTeam)

                            Picasso.get()
                                .load("${data?.strCutout}/preview")
                                .placeholder(R.drawable.placeholder_player)
                                .error(R.drawable.placeholder_player)
                                .into(binding.ivPlayer)

                            Picasso.get()
                                .load("https://www.thesportsdb.com/images/icons/flags/shiny/32/${data?.strNationality?.replace(" ", "-")}.png")
                                .placeholder(android.R.color.darker_gray)
                                .error(android.R.color.darker_gray)
                                .into(binding.ivFlag)

                            binding.tvName.text = data?.strPlayer
                            binding.tvNumber.text = data?.strNumber
                            binding.tvTeam.text = data?.strTeam
                            binding.tvPosition.text = data?.strPosition

                            if ((data?.strFacebook != null && data.strFacebook != "") ||
                                (data?.strTwitter != null && data.strTwitter != "") ||
                                (data?.strInstagram != null && data.strInstagram != "")){
                                binding.tvFollowPlayer.text = "Follow ${data.strPlayer}"
                            }

                            if (data?.strFacebook != null && data.strFacebook != "") {
                                binding.btnFacebook.visibility = View.VISIBLE
                                binding.btnFacebook.setOnClickListener {
                                    startActivity(
                                        Intent(
                                            Intent.ACTION_VIEW,
                                            Uri.parse(
                                                if(data.strFacebook!!.startsWith("https://")
                                                    || data.strFacebook!!.startsWith("http://")) data.strFacebook
                                                else "https://${data.strFacebook}"
                                            )
                                        )
                                    )
                                }
                            }

                            if (data?.strTwitter != null && data.strTwitter != "") {
                                binding.btnTwitter.visibility = View.VISIBLE
                                binding.btnTwitter.setOnClickListener {
                                    startActivity(
                                        Intent(
                                            Intent.ACTION_VIEW,
                                            Uri.parse(
                                                if(data.strTwitter!!.startsWith("https://") ||
                                                    data.strTwitter!!.startsWith("http://")) data.strTwitter
                                                else "https://${data.strTwitter}"
                                            )
                                        )
                                    )
                                }
                            }

                            if (data?.strInstagram != null && data.strInstagram != "") {
                                binding.btnInstagram.visibility = View.VISIBLE
                                binding.btnInstagram.setOnClickListener {
                                    startActivity(
                                        Intent(
                                            Intent.ACTION_VIEW,
                                            Uri.parse(
                                                if(data.strInstagram!!.startsWith("https://") ||
                                                    data.strInstagram!!.startsWith("http://")) data.strInstagram
                                                else "https://${data.strInstagram}"
                                            )
                                        )
                                    )
                                }
                            }

                            val now = Calendar.getInstance()
                            val born = Calendar.getInstance()
                            val format = SimpleDateFormat.getDateInstance()
                            val dateBorn = SimpleDateFormat("yyyy-MM-dd").parse(data?.dateBorn)
                            if(dateBorn != null) born.time = dateBorn

                            val diff: Long = now.time.time - born.time.time
                            val seconds = diff / 1000
                            val minutes = seconds / 60
                            val hours = minutes / 60
                            val days = hours / 24
                            val months = days / 30
                            val years = days / 365

                            binding.tvLocationBirth.text = data?.strBirthLocation
                            binding.tvNationality.text = data?.strNationality
                            binding.tvAge.text = (TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)/365).toString()
                            binding.tvDateOfBirth.text = format.format(dateBorn)
                            binding.tvHeight.text = data?.strHeight
                            binding.tvWeight.text = data?.strWeight

                            var isFavorite = data!!.isFavorite
                            setFavorite(isFavorite)
                            binding.fabFavorite.setOnClickListener {
                                isFavorite = !isFavorite
                                playerViewModel.setFavoritePlayer(data, isFavorite)
                                setFavorite(isFavorite)
                                if(isFavorite) Toast.makeText(this@PlayerActivity, "${data.strPlayer} has added to favorite players", Toast.LENGTH_SHORT).show()
                                else Toast.makeText(this@PlayerActivity, "${data.strPlayer} has removed from favorite players", Toast.LENGTH_SHORT).show()
                            }
                        }
                        else -> {

                        }
                    }
                }
            })
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun setFavorite(state: Boolean) {
        if (state) {
            binding.fabFavorite.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_24))
        } else {
            binding.fabFavorite.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_border_24))
        }
    }
}
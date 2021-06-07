package com.nfach98.premierleague.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.SYSTEM_UI_FLAG_FULLSCREEN
import android.view.View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
import com.nfach98.premierleague.core.data.Resource
import com.nfach98.premierleague.core.utils.DataClubs
import com.nfach98.premierleague.databinding.ActivitySplashBinding
import com.nfach98.premierleague.ui.main.MainActivity
import org.koin.android.viewmodel.ext.android.viewModel
import kotlin.random.Random

class SplashActivity : AppCompatActivity() {

    private val splashViewModel: SplashViewModel by viewModel()

    private var _binding: ActivitySplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        splashViewModel.colors.observe(this, { colors ->
            binding.layoutSplash.setBackgroundColor(colors[Random.nextInt(0, colors.size)])
        })

        splashViewModel.clubs.observe(this, { teams ->
            if(teams != null){
                when (teams) {
                    is Resource.Success -> {
                        DataClubs.listClub = teams.data
                        startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                        finish()
                    }
                    else -> {

                    }
                }
            }
        })
    }
}
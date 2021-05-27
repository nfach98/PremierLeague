package com.nfach98.premierleague.ui.splash

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nfach98.premierleague.R
import com.nfach98.premierleague.core.domain.usecase.LeagueUseCase

class SplashViewModel(context: Context, private val leagueUseCase: LeagueUseCase) : ViewModel() {
    private val _colors = MutableLiveData<List<Int>>().apply {
        value = listOf(
            ContextCompat.getColor(context, R.color.pink),
            ContextCompat.getColor(context, R.color.red),
            ContextCompat.getColor(context, R.color.orange),
            ContextCompat.getColor(context, R.color.yellow),
            ContextCompat.getColor(context, R.color.green),
            ContextCompat.getColor(context, R.color.blue),
            ContextCompat.getColor(context, R.color.purple),
        )
    }

    val colors: LiveData<List<Int>> = _colors

    val clubs = LiveDataReactiveStreams.fromPublisher(leagueUseCase.getAllClubs())
}
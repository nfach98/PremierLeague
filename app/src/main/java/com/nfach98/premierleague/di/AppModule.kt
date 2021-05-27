package com.nfach98.premierleague.di

import com.nfach98.premierleague.core.domain.usecase.LeagueInteractor
import com.nfach98.premierleague.core.domain.usecase.LeagueUseCase
import com.nfach98.premierleague.ui.detail.match.MatchViewModel
import com.nfach98.premierleague.ui.detail.player.PlayerViewModel
import com.nfach98.premierleague.ui.detail.club.ClubViewModel
import com.nfach98.premierleague.ui.main.favorite.FavoriteViewModel
import com.nfach98.premierleague.ui.main.home.HomeViewModel
import com.nfach98.premierleague.ui.main.matchday.MatchdayViewModel
import com.nfach98.premierleague.ui.main.table.TableViewModel
import com.nfach98.premierleague.ui.splash.SplashViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<LeagueUseCase> { LeagueInteractor(get()) }
}

val viewModelModule = module {
    viewModel { TableViewModel(get()) }
    viewModel { HomeViewModel(get()) }
    viewModel { MatchdayViewModel(get()) }
    viewModel { FavoriteViewModel(get()) }
    viewModel { SplashViewModel(get(), get()) }

    viewModel { ClubViewModel(get()) }
    viewModel { PlayerViewModel(get()) }
    viewModel { MatchViewModel(get()) }
}
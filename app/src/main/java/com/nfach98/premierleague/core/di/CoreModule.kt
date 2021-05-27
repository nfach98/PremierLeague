package com.nfach98.premierleague.core.di

import androidx.room.Room
import com.nfach98.premierleague.BuildConfig
import com.nfach98.premierleague.core.data.LeagueRepository
import com.nfach98.premierleague.core.data.source.local.LocalDataSource
import com.nfach98.premierleague.core.data.source.local.room.LeagueDatabase
import com.nfach98.premierleague.core.data.source.remote.RemoteDataSource
import com.nfach98.premierleague.core.data.source.remote.network.ApiService
import com.nfach98.premierleague.core.domain.repository.ILeagueRepository
import com.nfach98.premierleague.core.utils.AppExecutors
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val databaseModule = module {
    factory { get<LeagueDatabase>().leagueDao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            LeagueDatabase::class.java, "PremierLeague.db"
        ).fallbackToDestructiveMigration().build()
    }
}

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.thesportsdb.com/api/v1/json/${BuildConfig.API_KEY}/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    factory { AppExecutors() }
    single<ILeagueRepository> { LeagueRepository(get(), get(), get()) }
}
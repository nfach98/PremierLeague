package com.nfach98.premierleague.core.utils

import com.nfach98.premierleague.core.domain.model.Club

object DataClubs {
    var listClub : List<Club>? = null

    fun getClub(id: String): List<Club>? {
        return listClub?.filter { it.idTeam == id }
    }
}
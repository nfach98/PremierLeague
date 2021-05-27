package com.nfach98.premierleague.core.domain.model

data class Timeline(
    var idTimeline: String,
    var idEvent: String? = null,
    var strTimeline: String? = null,
    var strTimelineDetail: String? = null,
    var strHome: String? = null,
    var strEvent: String? = null,
    var idAPIfootball: String? = null,
    var idPlayer: String? = null,
    var strPlayer: String? = null,
    var strCountry: String? = null,
    var idAssist: String? = null,
    var strAssist: String? = null,
    var intTime: String? = null,
    var idTeam: String? = null,
    var strTeam: String? = null,
    var strComment: String? = null,
    var dateEvent: String? = null,
    var strSeason: String? = null
)
package com.didi.programmer.infrastructure.services.league

import com.didi.programmer.infrastructure.entities.TeamDataCollectionList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface LeagueService {
    @GET("search_all_teams.php{league_name}")
    fun getLeagueTeams(@Path("league_name") teamName: String): Call<TeamDataCollectionList>
}
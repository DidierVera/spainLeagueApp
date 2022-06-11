package com.didi.programmer.spanishleagueapp.presenter
import com.didi.programmer.infrastructure.entities.TeamDataCollectionList
import com.didi.programmer.infrastructure.mapper.MapperConfig
import com.didi.programmer.infrastructure.services.base.RestEngine
import com.didi.programmer.infrastructure.services.league.LeagueService
import com.didi.programmer.spanishleagueapp.contract.ILeaguePresenter
import com.didi.programmer.spanishleagueapp.contract.ITeamView
import com.didi.programmer.spanishleagueapp.contract.ITeamsView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

 class LeaguePresenter(private var leagueService: LeagueService,
        private  val teamsView: ITeamsView,
        private  val mapper: MapperConfig
    ) : ILeaguePresenter {

    override fun getAllTeams() {
        teamsView.showLoading()
        leagueService = RestEngine.getRestEngine().create(LeagueService::class.java)
        val result: Call<TeamDataCollectionList> = leagueService.getLeagueTeams("“Spanish La Liga")
        result.enqueue(object : Callback<TeamDataCollectionList> {
            override fun onResponse(
                call: Call<TeamDataCollectionList>,
                response: Response<TeamDataCollectionList>
            ) {
                teamsView.hideLoading()
                teamsView.loadTeams(mapper.getTeamsByResponse(response.body()!!))
            }

            override fun onFailure(call: Call<TeamDataCollectionList>, t: Throwable) {
                teamsView.hideLoading()
                teamsView.showAlert(t.message.toString())

            }
        })
    }

    override fun getTeamDetail(teamId: String) {
        TODO("Not yet implemented")
    }
}
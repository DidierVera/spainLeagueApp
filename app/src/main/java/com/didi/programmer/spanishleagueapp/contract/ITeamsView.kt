package com.didi.programmer.spanishleagueapp.contract

import com.didi.programmer.domain.model.TeamModel

interface ITeamsView: IGenericView  {
    fun loadTeams(items: List<TeamModel>)
}
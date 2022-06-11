package com.didi.programmer.infrastructure.mapper

import com.didi.programmer.domain.model.TeamModel
import com.didi.programmer.infrastructure.entities.TeamDataCollectionList

class MapperConfig {
    fun getTeamsByResponse(serviceResult: TeamDataCollectionList) : List<TeamModel>{
        val result: MutableList<TeamModel> = arrayListOf()
        for (item in serviceResult.teams){
            result.add(TeamModel( item.strTeam, item.strStadium, item.strTeamBadge))
        }
        return result
    }
}
package com.didi.programmer.spanishleagueapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.didi.programmer.domain.model.TeamModel
import com.didi.programmer.spanishleagueapp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.team_row.view.*

class TeamsAdapter(private val teams:List<TeamModel>) :
    RecyclerView.Adapter<TeamsAdapter.TeamViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.team_row, parent, false)
        return TeamViewHolder(view)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val team = teams[position]
        holder.teamName.text = team.name
        holder.stadium.text = team.stadium
        Picasso.get()
            .load(team.badge)
            .resize(140, 140)
            .centerCrop()
            .into(holder.teamBadge)
    }

    override fun getItemCount() = teams.size

    class TeamViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val teamName: TextView = itemView.tvTeamName
        val stadium: TextView = itemView.tvStadium
        val teamBadge: ImageView = itemView.ivTeamBadge
    }
}
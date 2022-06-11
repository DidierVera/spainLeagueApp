package com.didi.programmer.spanishleagueapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.didi.programmer.domain.model.TeamModel
import com.didi.programmer.infrastructure.mapper.MapperConfig
import com.didi.programmer.infrastructure.services.league.LeagueService
import com.didi.programmer.spanishleagueapp.R
import com.didi.programmer.spanishleagueapp.contract.ITeamsView
import com.didi.programmer.spanishleagueapp.presenter.LeaguePresenter
import com.didi.programmer.spanishleagueapp.view.adapter.TeamsAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity() : AppCompatActivity(), ITeamsView {
    lateinit var presenter: LeaguePresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initPresenter()
        getData()
    }

    private fun initPresenter(){
    }

    private fun getData(){
        presenter.getAllTeams()
    }
    override fun loadTeams(items: List<TeamModel>)  {
        rv_teams.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = TeamsAdapter(items)
        }
    }

    override fun showLoading() {
        prg_car.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        this@MainActivity.runOnUiThread { prg_car.visibility = View.GONE }
    }

    override fun showAlert(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
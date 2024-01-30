package com.prasant.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.prasant.assignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        getSports()
        getLiveMatches()

        getTickrs()

        setContentView(binding.root)
    }

    private fun getSports() {
        val sports = arrayListOf<Sport>(
            Sport(
                "Football",
                R.drawable.football
            ),
            Sport(
                "Cricket",
                R.drawable.cricket
            )
        )
        binding.gamesRecyclerViewInMainActivity.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.gamesRecyclerViewInMainActivity.adapter = SportsAdapter(
            this@MainActivity,
            sports
        )
    }

    private fun getTickrs() {
        val tickrs = arrayListOf<Tickr>(
            Tickr(
                "USAB",
                R.drawable.basket_ball,
                true
            ),
            Tickr(
                "DAL",
                R.drawable.golf,
                false
            ),
            Tickr(
                "NCAAF",
                R.drawable.climbing,
                false
            ),
            Tickr(
                "Madrid",
                R.drawable.tennis,
                false
            ),
            Tickr(
                "PHI",
                R.drawable.swimming,
                false
            )
        )
        if(!tickrs.isEmpty()){
            binding.tickrRecyclerViewInMainActivity.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
            binding.tickrRecyclerViewInMainActivity.adapter = TickrAdapter(
                this@MainActivity,
                tickrs
            )
        }
    }

    private fun getLiveMatches() {
        val matches = arrayListOf<LiveMatch>(
            LiveMatch(
                "Espanyol",
                R.drawable.espanyol,
                2,
                "Atl. Madrid",
                R.drawable.alt_icon,
                0,
                "72 min"
            ),
            LiveMatch(
                "Leeds Utd.",
                R.drawable.united_logo,
                1,
                "Liverpool",
                R.drawable.liverpool,
                3,
                "36 min"
            ),
            LiveMatch(
                "Barcelona",
                R.drawable.united_logo,
                1,
                "Real Madrid",
                R.drawable.liverpool,
                3,
                "36 min"
            )
        )
        binding.matchesRecyclerViewInMainActivity.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.matchesRecyclerViewInMainActivity.adapter = LiveMatchAdapter(
            this@MainActivity,
            matches
        )
    }
}
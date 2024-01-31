package com.prasant.assignment

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.prasant.assignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    var selectedMultiplier = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        getSports()
        getPreviewMatches()
        getLiveMatches()

        getTickrs()


        selectMultiplier(1)
        binding.firstCardInRapidFireInMainActivity.setOnClickListener {
            selectMultiplier(1)
        }

        binding.secondCardInRapidFireInMainActivity.setOnClickListener {
            selectMultiplier(2)
        }

        binding.thirdCardInRapidFireInMainActivity.setOnClickListener {
            selectMultiplier(3)
        }
        binding.fourthCardInRapidFireInMainActivity.setOnClickListener {
            selectMultiplier(4)
        }

        setContentView(binding.root)
    }

    private fun selectMultiplier(multiplier:Int) {
        selectedMultiplier = multiplier
        binding.secondArrowInMainActivity.visibility = View.GONE
        binding.thirdArrowInMainActivity.visibility = View.GONE
        binding.fourthArrowInMainActivity.visibility = View.GONE
        binding.firstArrowInMainActivity.visibility = View.GONE
        binding.firstCardInRapidFireInMainActivity.setBackgroundColor(Color.parseColor("#00000000"))
        binding.firstCardInRapidFireInMainActivity.cardElevation = 0F
        binding.secondCardInRapidFireInMainActivity.setBackgroundColor(Color.parseColor("#00000000"))
        binding.secondCardInRapidFireInMainActivity.cardElevation = 0F
        binding.thirdCardInRapidFireInMainActivity.setBackgroundColor(Color.parseColor("#00000000"))
        binding.thirdCardInRapidFireInMainActivity.cardElevation = 0F
        binding.fourthCardInRapidFireInMainActivity.setBackgroundColor(Color.parseColor("#00000000"))
        binding.fourthCardInRapidFireInMainActivity.cardElevation = 0F
        when(multiplier){
            1->{
                binding.firstArrowInMainActivity.visibility = View.VISIBLE
                binding.firstCardInRapidFireInMainActivity.setBackgroundColor(Color.parseColor("#4DD9D9D9"))
                binding.firstCardInRapidFireInMainActivity.cardElevation = 2F
            }
            2->{
                binding.secondArrowInMainActivity.visibility = View.VISIBLE
                binding.secondCardInRapidFireInMainActivity.setBackgroundColor(Color.parseColor("#4DD9D9D9"))
                binding.secondCardInRapidFireInMainActivity.cardElevation = 2F
            }
            3->{
                binding.thirdArrowInMainActivity.visibility = View.VISIBLE
                binding.thirdCardInRapidFireInMainActivity.setBackgroundColor(Color.parseColor("#4DD9D9D9"))
                binding.thirdCardInRapidFireInMainActivity.cardElevation = 2F
            }
            else->{
                binding.fourthArrowInMainActivity.visibility = View.VISIBLE
                binding.fourthCardInRapidFireInMainActivity.setBackgroundColor(Color.parseColor("#4DD9D9D9"))
                binding.fourthCardInRapidFireInMainActivity.cardElevation = 2F
            }
        }
    }

    private fun getPreviewMatches() {
        val matches = arrayListOf<PreviewMatch>(
            PreviewMatch(R.drawable.first_match),
            PreviewMatch(R.drawable.second_match)
        )
        binding.previewMatchRecyclerViewInMainActivity.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.previewMatchRecyclerViewInMainActivity.adapter = PreviewMatchAdapter(
            this,
            matches
        )
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
            ),
            Sport(
                "Adding Soon",
                R.drawable.f1
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
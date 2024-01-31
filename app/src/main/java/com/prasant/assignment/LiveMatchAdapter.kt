package com.prasant.assignment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.prasant.assignment.databinding.LiveMatchCardBinding

class LiveMatchAdapter(
    var context:Context,
    var matches:ArrayList<LiveMatch>
) : RecyclerView.Adapter<LiveMatchAdapter.LiveMatchViewHolder>(){

    class LiveMatchViewHolder(val binding:LiveMatchCardBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LiveMatchViewHolder {
        val binding = LiveMatchCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return LiveMatchViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return matches.size
    }

    override fun onBindViewHolder(holder: LiveMatchViewHolder, position: Int) {
        holder.binding.firstNameInLiveMatchCard.text = matches[position].firstTeam
        holder.binding.firstLogoInLiveMatchCard.setImageDrawable(ContextCompat.getDrawable(context,matches[position].firstLogo))
        holder.binding.firstScoreInLiveMatchCard.text = matches[position].firstScore.toString()
        holder.binding.secondNameInLiveMatchCard.text = matches[position].secondTeam
        holder.binding.secondLogoInLiveMatchCard.setImageDrawable(ContextCompat.getDrawable(context,matches[position].secondLogo))
        holder.binding.secondScoreInLiveMatchCard.text = matches[position].secondScore.toString()
        holder.binding.timeInLiveMatchCard.text = matches[position].time
    }

}
package com.prasant.assignment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.prasant.assignment.databinding.SportCardBinding

class SportsAdapter(
    var context:Context,
    val sports:ArrayList<Sport>
) : RecyclerView.Adapter<SportsAdapter.SportsViewHolder>(){
    class SportsViewHolder(val binding:SportCardBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportsViewHolder {
        val binding = SportCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SportsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return sports.size
    }

    override fun onBindViewHolder(holder: SportsViewHolder, position: Int) {
        holder.binding.sportNameInSportCard.text = sports[position].name.toString()
        holder.binding.logoInSportCard.setImageDrawable(ContextCompat.getDrawable(context,sports[position].logo))
    }
}
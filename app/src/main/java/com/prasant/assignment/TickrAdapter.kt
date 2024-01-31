package com.prasant.assignment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.prasant.assignment.databinding.TickrCardBinding

class TickrAdapter(
    var context:Context,
    var tickrs:ArrayList<Tickr>
) : RecyclerView.Adapter<TickrAdapter.TickrViewHolder>(){
    class TickrViewHolder(val binding:TickrCardBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TickrViewHolder {
        val binding = TickrCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TickrViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return tickrs.size
    }

    override fun onBindViewHolder(holder: TickrViewHolder, position: Int) {
        holder.binding.nameInTickrCard.text = tickrs[position].name
        holder.binding.logoInTickrCard.setImageDrawable(ContextCompat.getDrawable(context,tickrs[position].logo))
        holder.binding.tickInTickrCard.visibility = if(tickrs[position].ticked) View.VISIBLE else View.GONE
    }
}
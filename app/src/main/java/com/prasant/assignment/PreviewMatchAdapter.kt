package com.prasant.assignment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.prasant.assignment.databinding.PreviewMatchCardBinding

class PreviewMatchAdapter(
    var context:Context,
    var matches:ArrayList<PreviewMatch>
) : RecyclerView.Adapter<PreviewMatchAdapter.PreviewMatchViewHolder>(){
    class PreviewMatchViewHolder(val binding:PreviewMatchCardBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PreviewMatchViewHolder {
        val binding = PreviewMatchCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PreviewMatchViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return matches.size
    }

    override fun onBindViewHolder(holder: PreviewMatchViewHolder, position: Int) {
        holder.binding.imageInPreviewMatchCard.setImageDrawable(ContextCompat.getDrawable(context,matches[position].image))
    }
}
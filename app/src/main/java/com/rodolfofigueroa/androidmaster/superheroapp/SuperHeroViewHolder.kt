package com.rodolfofigueroa.androidmaster.superheroapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.rodolfofigueroa.androidmaster.databinding.ItemSuperheroBinding
import com.squareup.picasso.Picasso

class SuperHeroViewHolder(view: View):RecyclerView.ViewHolder(view) {

    private val binding = ItemSuperheroBinding.bind(view)

    fun bind(superHeroItemResponse: SuperHeroItemResponse, onItemSelected: (String) -> Unit){
        binding.tvName.text = superHeroItemResponse.superHeroName
        Picasso.get().load(superHeroItemResponse.image.url).into(binding.ivPhoto)

        binding.root.setOnClickListener {
            onItemSelected(superHeroItemResponse.superHeroId)
        }
    }
}
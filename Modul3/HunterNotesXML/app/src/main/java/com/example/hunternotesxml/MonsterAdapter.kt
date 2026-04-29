package com.example.hunternotesxml

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hunternotesxml.databinding.ItemMonsterBinding

class MonsterAdapter(
    private val monsters: List<Monster>,
    private val onDetailClick: (Monster) -> Unit
) : RecyclerView.Adapter<MonsterAdapter.MonsterViewHolder>() {

    inner class MonsterViewHolder(private val binding: ItemMonsterBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(monster: Monster) {
            binding.tvName.text = monster.name
            binding.tvSpecies.text = monster.species
            binding.tvDescription.text = monster.description
            binding.ivMonster.setImageResource(monster.imageResId)

            binding.btnWiki.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(monster.wikiUrl))
                it.context.startActivity(intent)
            }

            binding.btnDetail.setOnClickListener {
                onDetailClick(monster)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonsterViewHolder {
        val binding = ItemMonsterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MonsterViewHolder(binding)
    }

    override fun getItemCount(): Int = monsters.size

    override fun onBindViewHolder(holder: MonsterViewHolder, position: Int) {
        holder.bind(monsters[position])
    }
}
package com.example.hunternotesxml

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.hunternotesxml.databinding.FragmentDetailBinding

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDetailBinding.bind(view)
        
        val monsterId = arguments?.getInt("monsterId") ?: return

        val viewModel = ViewModelProvider(requireActivity())[MonsterViewModel::class.java]
        val monster = viewModel.monsterList.find { it.id == monsterId }

        if (monster != null) {
            binding.ivDetailImage.setImageResource(monster.imageResId)
            binding.tvDetailName.text = monster.name
            binding.tvDetailSpecies.text = monster.species
            binding.tvDetailDescription.text = monster.description
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
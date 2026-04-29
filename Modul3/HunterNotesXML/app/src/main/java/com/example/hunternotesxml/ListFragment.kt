package com.example.hunternotesxml

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hunternotesxml.databinding.FragmentListBinding

class ListFragment : Fragment(R.layout.fragment_list) {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentListBinding.bind(view)

        val viewModel = ViewModelProvider(requireActivity())[MonsterViewModel::class.java]

        val adapter = MonsterAdapter(viewModel.monsterList) { monster ->
            val bundle = Bundle().apply { putInt("monsterId", monster.id) }

            findNavController().navigate(R.id.action_list_to_detail, bundle)
        }

        binding.rvHorizontal.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvHorizontal.adapter = adapter

        binding.rvVertical.layoutManager = LinearLayoutManager(requireContext())
        binding.rvVertical.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
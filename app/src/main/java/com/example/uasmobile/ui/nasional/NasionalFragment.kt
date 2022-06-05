package com.example.uasmobile.ui.nasional

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.uasmobile.R
import com.example.uasmobile.databinding.FragmentNasionalBinding

class NasionalFragment : Fragment() {

    private val viewModel: NasionalViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentNasionalBinding.inflate(inflater)

        viewModel.getNasionalList()
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.nasionalRV.adapter = NasionalAdapter(NasionalListener { nasionals ->
            viewModel.onNasionalClicked(nasionals)
            findNavController()
                .navigate(R.id.action_nasionalListFragment_to_nasionalDetailFragment)
        })

        return binding.root
    }
}
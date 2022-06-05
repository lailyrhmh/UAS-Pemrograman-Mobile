package com.example.uasmobile.ui.olahraga

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.uasmobile.R
import com.example.uasmobile.databinding.FragmentOlahragaBinding

class OlahragaFragment : Fragment() {

    private val viewModel: OlahragaViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentOlahragaBinding.inflate(inflater)

        viewModel.getOlahragaList()
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.olahragaRV.adapter = OlahragaAdapter(OlahragaListener { olahragas ->
            viewModel.onOlahragaClicked(olahragas)
            findNavController()
                .navigate(R.id.action_olahragaListFragment_to_olahragaDetailFragment)
        })

        return binding.root
    }
}
package com.example.uasmobile.ui.internasional

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.uas_mobile.R
import com.example.uasmobile.databinding.FragmentInternasionalBinding

class InternasionalFragment : Fragment() {

    private val viewModel: InternasionalViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentInternasionalBinding.inflate(inflater)
        viewModel.getInternasionalList()
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.recyclerView.adapter = InternasionalAdapter(InternasionalListener { internasionals ->
            viewModel.onInternasionalClicked(internasionals)
            findNavController()
                .navigate(R.id.action_internasionalFragment_to_internasionalDetailsFragment)
        })

        (activity as AppCompatActivity).supportActionBar?.title = "News"

        return binding.root
    }
}
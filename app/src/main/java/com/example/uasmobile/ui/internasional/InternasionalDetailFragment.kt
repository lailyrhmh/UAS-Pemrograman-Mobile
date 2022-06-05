package com.example.uasmobile.ui.internasional

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.uasmobile.R
import com.example.uasmobile.databinding.FragmentInternasionalDetailBinding
import com.example.uasmobile.databinding.FragmentNasionalDetailBinding
import com.example.uasmobile.ui.nasional.NasionalAdapter
import com.example.uasmobile.ui.nasional.NasionalListener
import com.example.uasmobile.ui.nasional.NasionalViewModel

class InternasionalDetailFragment : Fragment() {
    private val viewModel: InternasionalViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentInternasionalDetailBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        (activity as AppCompatActivity).supportActionBar?.title = viewModel.internasional.value?.title
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> findNavController().navigate(R.id.action_internasionalDetailFragment_to_internasionalFragment)
        }
        return true
    }
}
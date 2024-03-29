package com.mahesh_prajapati.rxjavaexamples

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.mahesh_prajapati.rxjavaexamples.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment0
        binding = FragmentMainBinding.inflate(layoutInflater)
        val view = binding.root

        binding.btSimpleExample.setOnClickListener {
            findNavController().navigate(R.id.go_main_fragment_to_simple_example_fragment)
        }
        binding.btLemdaExample.setOnClickListener {
            findNavController().navigate(R.id.go_main_fragment_to_lemda_function_fragment)
        }
        binding.btOperators.setOnClickListener {
            findNavController().navigate(R.id.go_main_fragment_to_operator_fragment)
        }
        binding.btObservarObserable.setOnClickListener {
            findNavController().navigate(R.id.go_main_fragment_to_observer_obserable_fragment)
        }

        return view
    }


}
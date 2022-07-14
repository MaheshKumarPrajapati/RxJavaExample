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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment0
        binding = FragmentMainBinding.inflate(layoutInflater)
        val view = binding.root

        binding.btOperators.setOnClickListener {
            findNavController().navigate(R.id.go_main_fragment_to_operator)
        }

        return view
    }


}
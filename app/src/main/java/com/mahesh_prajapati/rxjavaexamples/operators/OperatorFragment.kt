package com.mahesh_prajapati.rxjavaexamples.operators

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.mahesh_prajapati.rxjavaexamples.R
import com.mahesh_prajapati.rxjavaexamples.databinding.FragmentMainBinding
import com.mahesh_prajapati.rxjavaexamples.databinding.FragmentOperatorBinding

class OperatorFragment : Fragment() {

    private lateinit var binding: FragmentOperatorBinding

    private lateinit var viewModel: OperatorViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOperatorBinding.inflate(layoutInflater)
        val view = binding.root
        val adapter = OperatorsAdaptors()
        binding.rvOperators.adapter=adapter
        adapter.setOperatorNameList(getAllNames())
        return view
    }

    private fun getAllNames(): List<String> {
       return resources.getStringArray(R.array.operators_name).toList()
    }

}
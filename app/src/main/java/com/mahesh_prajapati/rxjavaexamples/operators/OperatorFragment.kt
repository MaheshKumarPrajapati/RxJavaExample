package com.mahesh_prajapati.rxjavaexamples.operators

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.mahesh_prajapati.rxjavaexamples.R
import com.mahesh_prajapati.rxjavaexamples.databinding.FragmentOperatorBinding
import androidx.recyclerview.widget.GridLayoutManager
import com.mahesh_prajapati.rxjavaexamples.utils.CellClickListener

import com.mahesh_prajapati.rxjavaexamples.OutputFragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController


class OperatorFragment : Fragment(),CellClickListener {

    private lateinit var binding: FragmentOperatorBinding

    private lateinit var viewModel: OperatorViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOperatorBinding.inflate(layoutInflater)
        val view = binding.root

        viewModel = ViewModelProvider(this)[OperatorViewModel::class.java]

        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(activity, 2)
        binding.rvOperators.setLayoutManager(layoutManager)
        val adapter = OperatorsAdaptors(getAllNames(), this)
        binding.rvOperators.adapter = adapter

        viewModel.justOperatorObserver.observe(requireActivity(), Observer {
            if(it.isNotBlank()) {
                val bundle = OutputFragment.createBundle(it)
                findNavController().navigate(R.id.go_main_fragment_to_output_fragment, bundle)
            }
        })

        viewModel.fromArrayOperatorObserver.observe(requireActivity(), Observer {
            if(it.isNotBlank()) {
                val bundle = OutputFragment.createBundle(it)
                findNavController().navigate(R.id.go_main_fragment_to_output_fragment, bundle)
            }
        })

        viewModel.fromIterableOperatorObserver.observe(requireActivity(), Observer {
            if(it.isNotBlank()) {
                val bundle = OutputFragment.createBundle(it)
                findNavController().navigate(R.id.go_main_fragment_to_output_fragment, bundle)
            }
        })
        viewModel.rangeOperatorObserver.observe(requireActivity(), Observer {
            if(it.isNotBlank()) {
                val bundle = OutputFragment.createBundle(it)
                findNavController().navigate(R.id.go_main_fragment_to_output_fragment, bundle)
            }
        })
        viewModel.repeatOperatorObserver.observe(requireActivity(), Observer {
            if(it.isNotBlank()) {
                val bundle = OutputFragment.createBundle(it)
                findNavController().navigate(R.id.go_main_fragment_to_output_fragment, bundle)
            }
        })

        return view
    }
    private fun getAllNames(): List<String> {
       return resources.getStringArray(R.array.operators_name).toList()
    }

    override fun onCellClickListener(position: Int) {
        when(position){
        0 -> {
            viewModel.justOperator()
        }
        1 -> {
            viewModel.fromArrayOperator()
        }
        2 -> {
            viewModel.fromIterableOperator()
        }
        3 -> {
            viewModel.rangeOperator()
        }
        4 -> {
            viewModel.repeatOperator()
        }

        }
    }

}
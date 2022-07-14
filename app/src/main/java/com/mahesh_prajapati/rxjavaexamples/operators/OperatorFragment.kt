package com.mahesh_prajapati.rxjavaexamples.operators

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mahesh_prajapati.rxjavaexamples.R
import com.mahesh_prajapati.rxjavaexamples.databinding.FragmentOperatorBinding
import androidx.recyclerview.widget.GridLayoutManager




class OperatorFragment : Fragment() {

    private lateinit var binding: FragmentOperatorBinding

    private lateinit var viewModel: OperatorViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOperatorBinding.inflate(layoutInflater)
        val view = binding.root
        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(activity, 2)

        // pass it to rvLists layoutManager
        binding.rvOperators.setLayoutManager(layoutManager)
        val adapter = OperatorsAdaptors(getAllNames())
        binding.rvOperators.adapter=adapter
        return view
    }

    private fun getAllNames(): List<String> {
       return resources.getStringArray(R.array.operators_name).toList()
    }

}
package com.mahesh_prajapati.rxjavaexamples.observar_obserabble


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.mahesh_prajapati.rxjavaexamples.R
import androidx.recyclerview.widget.GridLayoutManager
import com.mahesh_prajapati.rxjavaexamples.utils.CellClickListener
import androidx.lifecycle.ViewModelProvider
import com.mahesh_prajapati.rxjavaexamples.databinding.FragmentObserverObserableBinding

class ObserverObserableFragment : Fragment(),CellClickListener {

    private lateinit var binding: FragmentObserverObserableBinding

    private lateinit var viewModel: ObserverObserableViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentObserverObserableBinding.inflate(layoutInflater)
        val view = binding.root

        viewModel = ViewModelProvider(this)[ObserverObserableViewModel::class.java]

        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(activity, 2)
        binding.rvObservarObserable.setLayoutManager(layoutManager)
        val adapter = ObserverObserableAdaptor(getAllNames(), this)
        binding.rvObservarObserable.adapter = adapter

        viewModel.observerObserableLiveData.observe(requireActivity(), Observer {
            Log.d(getString(R.string.app_name),it)

        })

        return view
    }
    private fun getAllNames(): List<String> {
        return resources.getStringArray(R.array.obserber_obserable_name).toList()
    }

    override fun onCellClickListener(position: Int) {
        when(position){
            0 -> {
                viewModel.obserableAndObserver()
            }
            1 -> {
                viewModel.singleAndSingleObserver()
            }
            2 -> {
                viewModel.mayBeAndMayBeObserver()
            }
            3 -> {
                viewModel.completableAndCompletableObserver()
            }
            4 -> {
                viewModel.flowable()
            }

        }
    }

}
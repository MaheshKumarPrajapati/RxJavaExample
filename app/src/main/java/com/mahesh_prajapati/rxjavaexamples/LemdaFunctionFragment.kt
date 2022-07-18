package com.mahesh_prajapati.rxjavaexamples

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mahesh_prajapati.rxjavaexamples.databinding.FragmentLemdaFunctionBinding
import com.mahesh_prajapati.rxjavaexamples.databinding.FragmentMainBinding
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class LemdaFunctionFragment : Fragment() {

    private lateinit var binding: FragmentLemdaFunctionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLemdaFunctionBinding.inflate(layoutInflater)
        val view = binding.root

        Observable
            .just(1,2,3,4,5,6,7,8,9,10)
            .subscribe(
                {
                    binding.tvOutput.setText("${binding.tvOutput.text.toString()} \nonNext : ${it}")
                },
                {
                    binding.tvOutput.setText("${binding.tvOutput.text.toString()} \nonError : ${it!!.message}")
                },
                {
                    binding.tvOutput.setText("${binding.tvOutput.text.toString()} \nonComplete")
                }
            )



        return view
    }

}
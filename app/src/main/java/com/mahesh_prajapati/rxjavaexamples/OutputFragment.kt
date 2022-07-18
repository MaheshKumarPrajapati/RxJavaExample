package com.mahesh_prajapati.rxjavaexamples

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mahesh_prajapati.rxjavaexamples.databinding.FragmentLemdaFunctionBinding
import com.mahesh_prajapati.rxjavaexamples.databinding.FragmentOutputBinding

private const val RESULT = "param_result"

class OutputFragment : Fragment() {
    private var result: String? = null
    private lateinit var binding: FragmentOutputBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            result = it.getString(RESULT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOutputBinding.inflate(layoutInflater)
        val view = binding.root

        binding.tvOutput.text=result

        return view
    }

    companion object {
        @JvmStatic
        fun createBundle(param1: String): Bundle {
            return  Bundle().apply {
                putString(RESULT, param1)
            }
        }


    }
}
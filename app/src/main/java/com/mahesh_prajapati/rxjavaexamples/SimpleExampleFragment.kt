package com.mahesh_prajapati.rxjavaexamples

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mahesh_prajapati.rxjavaexamples.databinding.FragmentLemdaFunctionBinding
import com.mahesh_prajapati.rxjavaexamples.databinding.FragmentMainBinding
import com.mahesh_prajapati.rxjavaexamples.databinding.FragmentSimpleExampleBinding
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class SimpleExampleFragment : Fragment() {

    private lateinit var binding: FragmentSimpleExampleBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{
        binding = FragmentSimpleExampleBinding.inflate(layoutInflater)
        val view = binding.root

        val observable=Observable.just(1,2,3,4,5,6,7,8,9,10)

        val observer= object : Observer<Int>{

            override fun onSubscribe(d: Disposable?) {
                binding.tvOutput.setText("${binding.tvOutput.text.toString()} \nonSubscribe")
            }

            override fun onNext(t: Int?) {
                binding.tvOutput.setText("${binding.tvOutput.text.toString()} \nonNext : ${t}")

            }

            override fun onError(e: Throwable?) {
                binding.tvOutput.setText("${binding.tvOutput.text.toString()} \nonError : ${e!!.message}")

            }

            override fun onComplete() {
                binding.tvOutput.setText("${binding.tvOutput.text.toString()} \nonComplete")

            }

        }

        observable.subscribe(observer)

        return view
    }



}
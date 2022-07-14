package com.mahesh_prajapati.rxjavaexamples.operators

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData




class OperatorViewModel : ViewModel() {
    var mainRepository = OperatorReposetory()
    var operatorsLiveData: MutableLiveData<ArrayList<String>>? = null

    init{
        operatorsLiveData!!.value = mainRepository.getData()  //fetching local data

    }

}
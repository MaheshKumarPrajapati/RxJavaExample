package com.mahesh_prajapati.rxjavaexamples.operators

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import com.mahesh_prajapati.rxjavaexamples.utils.DummyData
import io.reactivex.rxjava3.core.Observable


class OperatorViewModel : ViewModel() {

    var justOperatorObserver: MutableLiveData<String> =MutableLiveData<String>("")
    var fromArrayOperatorObserver: MutableLiveData<String> =MutableLiveData<String>("")
    var fromIterableOperatorObserver: MutableLiveData<String> =MutableLiveData<String>("")
    var rangeOperatorObserver: MutableLiveData<String> =MutableLiveData<String>("")
    var repeatOperatorObserver: MutableLiveData<String> =MutableLiveData<String>("")
    var string:String=""

    fun justOperator(){
        Observable
        .just(1,2,3,4,5,6,7,8,9,10)
        .subscribe(
                {
                    string="${string} \nonNext : ${it}"
                },
                {
                    string="${string} \nonError : ${it!!.message}"
                },
                {
                    string="${string} \nonComplete"
                    justOperatorObserver!!.postValue("${string}")
                })
    }

    fun fromArrayOperator(){
        Observable
            .fromArray(DummyData().listNum)
            .subscribe(
                {
                    string="${string} \nonNext : ${it}"
                },
                {
                    string="${string} \nonError : ${it!!.message}"
                },
                {
                    string="${string} \nonComplete"
                    fromArrayOperatorObserver!!.postValue("${string}")
                })

    }

    fun fromIterableOperator(){
        Observable
            .fromIterable(DummyData().listNum)
            .subscribe(
                {
                    string="${string} \nonNext : ${it}"
                },
                {
                    string="${string} \nonError : ${it!!.message}"
                },
                {
                    string="${string} \nonComplete"
                    fromIterableOperatorObserver!!.postValue("${string}")
                })

    }

    fun rangeOperator(){
        Observable
            .range(1,20)
            .subscribe(
                {
                    string="${string} \nonNext : ${it}"
                },
                {
                    string="${string} \nonError : ${it!!.message}"
                },
                {
                    string="${string} \nonComplete"
                    rangeOperatorObserver!!.postValue("${string}")
                })

    }

    fun repeatOperator(){
        Observable
            .range(1,10).repeat(3)
            .subscribe(
                {
                    string="${string} \nonNext : ${it}"
                },
                {
                    string="${string} \nonError : ${it!!.message}"
                },
                {
                    string="${string} \nonComplete"
                    repeatOperatorObserver!!.postValue("${string}")
                })

    }

}
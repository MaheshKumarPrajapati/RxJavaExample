package com.mahesh_prajapati.rxjavaexamples.observar_obserabble

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mahesh_prajapati.rxjavaexamples.utils.DummyData
import com.mahesh_prajapati.rxjavaexamples.utils.User
import io.reactivex.rxjava3.core.*
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.schedulers.Schedulers.io

class ObserverObserableViewModel : ViewModel() {

    var observerObserableLiveData: MutableLiveData<String> = MutableLiveData<String>("")


    fun obserableAndObserver(){

        val observable=Observable.create<Int>
        { emmiter ->
        try {
          if(!emmiter.isDisposed) {
              for(i in 0..100) {
                  emmiter.onNext(i)
              }
              emmiter.onComplete()
          }
        }catch (e:Exception){
            emmiter.onError(e)
        }
        }

        val observer= object: Observer<Int>{
            override fun onSubscribe(d: Disposable?) {
                observerObserableLiveData.value="obserable And Observer onSubscribe"
            }

            override fun onNext(t: Int?) {
                observerObserableLiveData.value="obserable And Observer onNext : $t"
            }

            override fun onError(e: Throwable?) {
                observerObserableLiveData.value="obserable And Observer onError : ${e!!.message}"
            }

            override fun onComplete() {
                observerObserableLiveData.value="obserable And Observer onComplete"
            }
        }

        observable.subscribe(observer)
    }


    fun singleAndSingleObserver() {
        val observable= Single.create<List<User>>{ emmiter ->
            try {
                if(!emmiter.isDisposed) {
                        emmiter.onSuccess(DummyData().userList)
                }
            }catch (e:Exception){
                emmiter.onError(e)
            }
        }

        val observer= object: SingleObserver<List<User>>{
            override fun onSubscribe(d: Disposable?) {
                observerObserableLiveData.value="single And Single Observer onSubscribe"
            }

            override fun onSuccess(t: List<User>?) {
                t!!.forEach {
                    observerObserableLiveData.value="single And Single Observer onSuccess : $it"
                }
            }

            override fun onError(e: Throwable?) {
                observerObserableLiveData.value="single And Single Observer onError : ${e!!.message}"
            }

        }

        observable.subscribe(observer)
    }

    fun mayBeAndMayBeObserver() {
      //  val observable= Maybe.just(DummyData().userList)
        val observable= Maybe.just(DummyData().emptyUserList)

        val observer= object: MaybeObserver<List<User>>{
            override fun onSubscribe(d: Disposable?) {
                observerObserableLiveData.value="mayBe And MayBe Observer onSubscribe"
            }

            override fun onSuccess(t: List<User>?) {
                t!!.forEach {
                    observerObserableLiveData.value="mayBe And MayBe Observer onSuccess : $it"
                }
            }

            override fun onError(e: Throwable?) {
                observerObserableLiveData.value="mayBe And MayBe Observer onError : ${e!!.message}"
            }

            override fun onComplete() {
                observerObserableLiveData.value="mayBe And MayBe Observer onComplete"

            }

        }

        observable.subscribe(observer)
    }

    fun completableAndCompletableObserver(){
        val observable=Completable.create {emmiter ->    try {
            if(!emmiter.isDisposed) {
                observerObserableLiveData.value="completable And Completable Observer ${DummyData().getLocation()}"
                emmiter.onComplete()
            }
        }catch (e:Exception){
            emmiter.onError(e)
        } }


        val observer= object: CompletableObserver{
            override fun onSubscribe(d: Disposable?) {
                observerObserableLiveData.value="completable And Completable Observer onSubscribe"
            }

            override fun onError(e: Throwable?) {
                observerObserableLiveData.value="completable And Completable Observer : ${e!!.message}"
            }

            override fun onComplete() {
                observerObserableLiveData.value="completable And Completable Observer onComplete"
            }
        }

        observable.subscribe(observer)

    }

    fun flowable(){

        Flowable.range(1,100)
            .onBackpressureDrop()
            .subscribe(
                {
                    observerObserableLiveData.value="flowable onNext : $it"
                },
                {
                    observerObserableLiveData.value="flowable onError ${it!!.message}"
                },
                {
                    observerObserableLiveData.value="flowable onComplete"
                })

    }

}
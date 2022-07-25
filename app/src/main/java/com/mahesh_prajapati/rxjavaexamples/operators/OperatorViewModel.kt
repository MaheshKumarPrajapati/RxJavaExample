package com.mahesh_prajapati.rxjavaexamples.operators

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import com.mahesh_prajapati.rxjavaexamples.utils.*
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableOnSubscribe
import java.util.concurrent.TimeUnit

class OperatorViewModel : ViewModel() {

    var operatorLiveData: MutableLiveData<String> =MutableLiveData<String>("")

    var string:String=""


    fun justOperator(){
        Observable
        .just(1,2,3,4,5,6,7,8,9,10)
        .subscribe(
                {
                    operatorLiveData.value="just Operator onNext : $it"
                },
                {
                    operatorLiveData.value="just Operator onError ${it!!.message}"
                },
                {
                    operatorLiveData.value="just Operator onComplete"
                })
    }

    fun fromArrayOperator(){
        Observable
            .fromArray(DummyData().listNum)
            .subscribe(
                {
                    operatorLiveData.value="fromArray Operator onNext : $it"
                },
                {
                    operatorLiveData.value="fromArray Operator onError ${it!!.message}"
                },
                {
                    operatorLiveData.value="fromArray Operator onComplete"
                })

    }

    fun fromIterableOperator(){
        Observable
            .fromIterable(DummyData().listNum)
            .subscribe(
                {
                    operatorLiveData.value="fromIterable Operator onNext : $it"
                },
                {
                    operatorLiveData.value="fromIterable Operator onError ${it!!.message}"
                },
                {
                    operatorLiveData.value="fromIterable Operator onComplete"
                })

    }

    fun rangeOperator(){
        Observable
            .range(1,20)
            .subscribe(
                {
                    operatorLiveData.value="range Operator onNext : $it"
                },
                {
                    operatorLiveData.value="range Operator onError ${it!!.message}"
                },
                {
                    operatorLiveData.value="range Operator onComplete"
                })

    }

    fun repeatOperator(){
        Observable
            .range(1,10).repeat(3)
            .subscribe(
                {
                    operatorLiveData.value="repeat Operator onNext : $it"
                },
                {
                    operatorLiveData.value="repeat Operator onError ${it!!.message}"
                },
                {
                    operatorLiveData.value="repeat Operator onComplete"
                })
    }


    fun intervalOperator(){
        Observable
            .interval(2,TimeUnit.SECONDS).takeWhile { value-> value<=10 }
            .subscribe(
                {
                    operatorLiveData.postValue("interval Operator onNext : $it, ${DummyData().getLocation()}")
                },
                {
                    operatorLiveData.postValue("interval Operator onError ${it!!.message}")
                },
                {
                    operatorLiveData.postValue("interval Operator onComplete")
                })

    }

    fun timerOperator(){
        Observable
            .timer(5,TimeUnit.SECONDS)
            .subscribe(
                {
                    operatorLiveData.postValue("timer Operator onNext : $it, ${DummyData().getLocation()}")
                },
                {
                    operatorLiveData.postValue("timer Operator onError ${it!!.message}")
                },
                {
                    operatorLiveData.postValue("timer Operator onComplete")
                })

    }

    fun createOperator(){
        Observable.create(ObservableOnSubscribe<Int>{
                try {
                     for(i in DummyData().listNum) {
                        it.onNext(i*5)
                     }
                     it.onComplete()
                }catch(e:Exception){
                    it.onError(e)
                }
            })
            .subscribe(
                {
                    operatorLiveData.value="create Operator onNext : $it"
                },
                {
                    operatorLiveData.value="create Operator onError ${it!!.message}"
                },
                {
                    operatorLiveData.value="create Operator onComplete"
                })

    }

    fun filterOperator(){
        Observable
            .fromIterable(DummyData().userList)
            .filter { it.age>20 }
            .subscribe(
                {
                    operatorLiveData.value="filter Operator Operator onNext : $it"
                },
                {
                    operatorLiveData.value="filter Operator Operator onError ${it!!.message}"
                },
                {
                    operatorLiveData.value="filter Operator onComplete"
                })

    }

    fun lastOperator(){
        Observable
            .fromIterable(DummyData().userList)
            .last(User(0,"Mahesh",32),)
            .subscribe(
                {
                    operatorLiveData.value="last Operator onNext : $it"
                },
                {
                    operatorLiveData.value="last Operator onError ${it!!.message}"
                })
    }

    fun distinctOperator(){
        Observable
            .fromIterable(DummyData().userList)
            .distinct{it.age}
            .subscribe(
                {
                    operatorLiveData.value="distinct Operator onNext : $it"
                },
                {
                    operatorLiveData.value="distinct Operator onError ${it!!.message}"
                },
                {
                    operatorLiveData.value="distinct Operator onComplete"
                })
    }

    fun skipOperator(){
        Observable
            .fromIterable(DummyData().userList)
            .skip(2)
            .skipLast(2)
            .subscribe(
                {
                    operatorLiveData.value="skip Operator onNext : $it"
                },
                {
                    operatorLiveData.value="skip Operator onError ${it!!.message}"
                },
                {
                    operatorLiveData.value="skip Operator onComplete"
                })
    }

    fun bufferOperator(){
        Observable
            .fromIterable(DummyData().userList)
            .buffer(2)
            .subscribe(
                {
                    operatorLiveData.value="buffer Operator onNext : $it"
                },
                {
                    operatorLiveData.value="buffer Operator onError ${it!!.message}"
                },
                {
                    operatorLiveData.value="buffer Operator onComplete"
                })
    }

    fun mapOperator(){
        Observable
            .fromIterable(DummyData().userList)
            .map { UserProfile(it.id,it.name,it.age,"www.image.com/${it.name}") }
            .subscribe(
                {
                    operatorLiveData.value="map Operator onNext : $it"
                },
                {
                    operatorLiveData.value="map Operator onError ${it!!.message}"
                },
                {
                    operatorLiveData.value="map Operator onComplete"
                })

    }

    fun flatMapOperator(){
        Observable
            .fromIterable(DummyData().userList)
            .flatMap { it1-> Observable.fromIterable(DummyData().userProfileList).filter { it2-> it2.id==it1.id} }
            .subscribe(
                {
                    operatorLiveData.value="flatMap Operator onNext : $it"
                },
                {
                    operatorLiveData.value="flatMap Operator onError ${it!!.message}"
                },
                {
                    operatorLiveData.value="flatMap Operator onComplete"
                })
    }

    fun groupByOperator(){
        Observable
            .fromIterable(DummyData().userListForGroupByOperator)
            .groupBy { it.age}.filter { it.key==34 }
            .subscribe(
                {group ->
                    group.subscribe({
                        operatorLiveData.value="groupBy Operator group onNext : key ${group.key} , value $it"
                    },{
                        operatorLiveData.value="groupBy Operator group onError ${it!!.message}"
                      },
                    {operatorLiveData.value="groupBy Operator group onComplete"
                    })
                },
                {
                    operatorLiveData.value="groupBy Operator main onError ${it!!.message}"
                },
                {
                    operatorLiveData.value="groupBy Operator main onComplete"
                })

    }

    fun mergeOperator(){
        Observable
            .merge(Observable.fromIterable(DummyData().userList),Observable.fromIterable(DummyData().userProfileList))
            .subscribe(
                {
                    operatorLiveData.value="merge Operator onNext : $it"
                },
                {
                    operatorLiveData.value="merge Operator onError ${it!!.message}"
                },
                {
                    operatorLiveData.value="merge Operator onComplete"
                })


    }

    fun concatOperator(){
        /*Observable
            .concat(Observable.range(1,100),Observable.range(101,50))
            .subscribe(
                {
                    operatorObserver.value="concat Operator onNext : $it"
                },
                {
                    operatorObserver.value="concat Operator onError ${it!!.message}"
                },
                {
                    operatorObserver.value="concat Operator onComplete"
                })*/

        // Another way (if we have only two Observable)

       Observable.range(1,100).concatWith(Observable.range(101,50))
        .subscribe({
            operatorLiveData.value="concat Operator onNext : $it"
           },
            {
                operatorLiveData.value="concat Operator onError ${it!!.message}"
            },
            {
                operatorLiveData.value="concat Operator onComplete"
            })
    }

    fun startWithOperator(){
        Observable.range(1,100).startWith(Observable.range(101,50))
            .subscribe({
                operatorLiveData.value="startWith Operator onNext : $it"
            },
                {
                    operatorLiveData.value="startWith Operator onError ${it!!.message}"
                },
                {
                    operatorLiveData.value="startWith Operator onComplete"
                })
    }

    fun zipOperator(){
  /*    val num =Observable.just(1,2,3,4,5)
      val char =Observable.just('A','B','C','D')
        Observable
            .zip(num,char,{t1,t2 -> "t1 t2"})
            .subscribe(
                {
                    operatorObserver.value="zip Operator onNext : $it"
                },
                {
                    operatorObserver.value="zip Operator onError ${it!!.message}"
                },
                {
                    operatorObserver.value="zip Operator onComplete"
                })
    } */
        val observable1= Observable.just(DummyData().userList)
        val observable2= Observable.just(DummyData().blogList)
        Observable
            .zip(observable1,observable2,{t1,t2 ->
              getBlogDetails(t1,t2)
            })
            .subscribe(
                {
                    it.forEach {
                        operatorLiveData.value="zip Operator onNext : $it"
                    }

                },
                {
                    operatorLiveData.value="zip Operator onError ${it!!.message}"
                },
                {
                    operatorLiveData.value="zip Operator onComplete"
                })
    }

    private fun getBlogDetails(t1: List<User>, t2: List<Blog>): List<BlogDetail> {
        val lisBlogDetail : MutableList<BlogDetail> = emptyList<BlogDetail>().toMutableList()
        t1.forEach { user->
            t2.forEach { blog->
                if(user.id == blog.userId) {
                    lisBlogDetail.add(BlogDetail(blog.id,blog.userId,blog.title,blog.content,user))
                }
            }
        }
        return lisBlogDetail
    }

}
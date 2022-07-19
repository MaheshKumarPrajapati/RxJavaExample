package com.mahesh_prajapati.rxjavaexamples.operators

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import com.mahesh_prajapati.rxjavaexamples.utils.*
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableOnSubscribe
import java.util.concurrent.TimeUnit

class OperatorViewModel : ViewModel() {

    var operatorObserver: MutableLiveData<String> =MutableLiveData<String>("")

    var string:String=""

    fun justOperator(){
        Observable
        .just(1,2,3,4,5,6,7,8,9,10)
        .subscribe(
                {
                    operatorObserver.value="just Operator onNext : $it"
                },
                {
                    operatorObserver.value="just Operator onError ${it!!.message}"
                },
                {
                    operatorObserver.value="just Operator onComplete"
                })
    }

    fun fromArrayOperator(){
        Observable
            .fromArray(DummyData().listNum)
            .subscribe(
                {
                    operatorObserver.value="fromArray Operator onNext : $it"
                },
                {
                    operatorObserver.value="fromArray Operator onError ${it!!.message}"
                },
                {
                    operatorObserver.value="fromArray Operator onComplete"
                })

    }

    fun fromIterableOperator(){
        Observable
            .fromIterable(DummyData().listNum)
            .subscribe(
                {
                    operatorObserver.value="fromIterable Operator onNext : $it"
                },
                {
                    operatorObserver.value="fromIterable Operator onError ${it!!.message}"
                },
                {
                    operatorObserver.value="fromIterable Operator onComplete"
                })

    }

    fun rangeOperator(){
        Observable
            .range(1,20)
            .subscribe(
                {
                    operatorObserver.value="range Operator onNext : $it"
                },
                {
                    operatorObserver.value="range Operator onError ${it!!.message}"
                },
                {
                    operatorObserver.value="range Operator onComplete"
                })

    }

    fun repeatOperator(){
        Observable
            .range(1,10).repeat(3)
            .subscribe(
                {
                    operatorObserver.value="repeat Operator onNext : $it"
                },
                {
                    operatorObserver.value="repeat Operator onError ${it!!.message}"
                },
                {
                    operatorObserver.value="repeat Operator onComplete"
                })
    }


    fun intervalOperator(){
        Observable
            .interval(2,TimeUnit.SECONDS).takeWhile { value-> value<=10 }
            .subscribe(
                {
                    operatorObserver.postValue("interval Operator onNext : $it, ${DummyData().getLocation()}")
                },
                {
                    operatorObserver.postValue("interval Operator onError ${it!!.message}")
                },
                {
                    operatorObserver.postValue("interval Operator onComplete")
                })

    }

    fun timerOperator(){
        Observable
            .timer(5,TimeUnit.SECONDS)
            .subscribe(
                {
                    operatorObserver.postValue("timer Operator onNext : $it, ${DummyData().getLocation()}")
                },
                {
                    operatorObserver.postValue("timer Operator onError ${it!!.message}")
                },
                {
                    operatorObserver.postValue("timer Operator onComplete")
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
                    operatorObserver.value="create Operator onNext : $it"
                },
                {
                    operatorObserver.value="create Operator onError ${it!!.message}"
                },
                {
                    operatorObserver.value="create Operator onComplete"
                })

    }

    fun filterOperator(){
        Observable
            .fromIterable(DummyData().userList)
            .filter { it.age>20 }
            .subscribe(
                {
                    operatorObserver.value="filter Operator Operator onNext : $it"
                },
                {
                    operatorObserver.value="filter Operator Operator onError ${it!!.message}"
                },
                {
                    operatorObserver.value="filter Operator onComplete"
                })

    }

    fun lastOperator(){
        Observable
            .fromIterable(DummyData().userList)
            .last(User(0,"Mahesh",32),)
            .subscribe(
                {
                    operatorObserver.value="last Operator onNext : $it"
                },
                {
                    operatorObserver.value="last Operator onError ${it!!.message}"
                })
    }

    fun distinctOperator(){
        Observable
            .fromIterable(DummyData().userList)
            .distinct{it.age}
            .subscribe(
                {
                    operatorObserver.value="distinct Operator onNext : $it"
                },
                {
                    operatorObserver.value="distinct Operator onError ${it!!.message}"
                },
                {
                    operatorObserver.value="distinct Operator onComplete"
                })
    }

    fun skipOperator(){
        Observable
            .fromIterable(DummyData().userList)
            .skip(2)
            .skipLast(2)
            .subscribe(
                {
                    operatorObserver.value="skip Operator onNext : $it"
                },
                {
                    operatorObserver.value="skip Operator onError ${it!!.message}"
                },
                {
                    operatorObserver.value="skip Operator onComplete"
                })
    }

    fun bufferOperator(){
        Observable
            .fromIterable(DummyData().userList)
            .buffer(2)
            .subscribe(
                {
                    operatorObserver.value="buffer Operator onNext : $it"
                },
                {
                    operatorObserver.value="buffer Operator onError ${it!!.message}"
                },
                {
                    operatorObserver.value="buffer Operator onComplete"
                })
    }

    fun mapOperator(){
        Observable
            .fromIterable(DummyData().userList)
            .map { UserProfile(it.id,it.name,it.age,"www.image.com/${it.name}") }
            .subscribe(
                {
                    operatorObserver.value="map Operator onNext : $it"
                },
                {
                    operatorObserver.value="map Operator onError ${it!!.message}"
                },
                {
                    operatorObserver.value="map Operator onComplete"
                })

    }

    fun flatMapOperator(){
        Observable
            .fromIterable(DummyData().userList)
            .flatMap { it1-> Observable.fromIterable(DummyData().userProfileList).filter { it2-> it2.id==it1.id} }
            .subscribe(
                {
                    operatorObserver.value="flatMap Operator onNext : $it"
                },
                {
                    operatorObserver.value="flatMap Operator onError ${it!!.message}"
                },
                {
                    operatorObserver.value="flatMap Operator onComplete"
                })
    }

    fun groupByOperator(){
        Observable
            .fromIterable(DummyData().userListForGroupByOperator)
            .groupBy { it.age}.filter { it.key==34 }
            .subscribe(
                {group ->
                    group.subscribe({
                        operatorObserver.value="groupBy Operator group onNext : key ${group.key} , value $it"
                    },{
                        operatorObserver.value="groupBy Operator group onError ${it!!.message}"
                      },
                    {operatorObserver.value="groupBy Operator group onComplete"
                    })
                },
                {
                    operatorObserver.value="groupBy Operator main onError ${it!!.message}"
                },
                {
                    operatorObserver.value="groupBy Operator main onComplete"
                })

    }

    fun mergeOperator(){
        Observable
            .merge(Observable.fromIterable(DummyData().userList),Observable.fromIterable(DummyData().userProfileList))
            .subscribe(
                {
                    operatorObserver.value="merge Operator onNext : $it"
                },
                {
                    operatorObserver.value="merge Operator onError ${it!!.message}"
                },
                {
                    operatorObserver.value="merge Operator onComplete"
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
            operatorObserver.value="concat Operator onNext : $it"
           },
            {
                operatorObserver.value="concat Operator onError ${it!!.message}"
            },
            {
                operatorObserver.value="concat Operator onComplete"
            })
    }

    fun startWithOperator(){
        Observable.range(1,100).startWith(Observable.range(101,50))
            .subscribe({
                operatorObserver.value="startWith Operator onNext : $it"
            },
                {
                    operatorObserver.value="startWith Operator onError ${it!!.message}"
                },
                {
                    operatorObserver.value="startWith Operator onComplete"
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
                        operatorObserver.value="zip Operator onNext : $it"
                    }

                },
                {
                    operatorObserver.value="zip Operator onError ${it!!.message}"
                },
                {
                    operatorObserver.value="zip Operator onComplete"
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
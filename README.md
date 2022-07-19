# RxJavaExample

## Operators :-

We are covering following operators in this example

1. Just Operator
2. FromArray Operator
3. FromIterator Operator
4. Range Operator
5. Repeat Operator
6. Interval Operator
7. Timer Operator
8. Create Operator
9. Filter Operator
10. Last Operator
11. Distinct Operator
12. Skip Operator
13. Buffer Operator
14. Map Operator
15. FlatMap Operator
16. GroupBy Operator
17. Merge Operator
18. Concat Operator
19. StartWith Operator
20. Zip Operator

### 1. Just Operator:  

* Just operator creates new Observables by converting an object or a set of objects into an Observable and emits that or those objects.
* You can pass up to a maximum of 10 objects.


<img src="https://reactivex.io/documentation/operators/images/just.c.png"/>

```kotlin
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
  ``` 
 output : 

just Operator onNext : 1
just Operator onNext : 2
just Operator onNext : 3
just Operator onNext : 4
just Operator onNext : 5
just Operator onNext : 6
just Operator onNext : 7
just Operator onNext : 8
just Operator onNext : 9
just Operator onNext : 10
just Operator onComplete 
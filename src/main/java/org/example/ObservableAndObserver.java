package org.example;

import io.reactivex.rxjava3.core.Observable;

import java.util.List;

public class ObservableAndObserver {

    public static void main(String[] args) {
        //create
        Observable<Integer>source=Observable.create(e->{
            e.onNext(10);
            e.onNext(11);
            e.onNext(12);
            e.onComplete();
        });

        source.subscribe(System.out::println);

        //fromIterable
        List<String> list= List.of("a","e","i");
        Observable<String>fromIterable=Observable.fromIterable(list);
        fromIterable.subscribe(System.out::println);

        //just
        Observable<Integer>just=Observable.just(1,2,3);
        just.subscribe(System.out::println);

        // creacion de observe
        just.subscribe(System.out::println,Throwable::printStackTrace,()->System.out.println("Completed"));




    }
}

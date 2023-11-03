package org.example;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public class Variants {

    public static void main(String[] args) {
        Observable<String>source=Observable.just("Alex","Aaron","Peque");
        Observable<String>source1=Observable.empty();
        source.first("nombre")
                .subscribe(System.out::println);

        Single.just("Alex")
                .subscribe(System.out::println);

        source1
                .firstElement()
                .subscribe(System.out::println,e->e.printStackTrace(),()->System.out.println("Completed"));

        System.out.println("");
        Completable completable=Completable.complete();
        completable.subscribe(()->System.out.println("COmpleted"));

        Completable
                .fromRunnable(()-> System.out.println("Some process executing"))
                .subscribe(()-> System.out.println("The process executed succesfully"));



    }
}

package org.example;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SubscribeOn {

    public static void main(String[] args) throws InterruptedException {
        Observable.just("Pasta","Pizza","Fries","Curry","Chow mein")
                .subscribeOn(Schedulers.computation())
                .map(e->e.toUpperCase())    
                .subscribeOn(Schedulers.newThread())
                .filter(e->e.startsWith("P"))
                .subscribe(e->print(e));

        Thread.sleep(6000);
    }

    public static void print(String element) throws InterruptedException{
        System.out.println(element+" : Printed By : "+Thread.currentThread().getName());
    }
}

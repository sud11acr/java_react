package org.example;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class Disposing {
    public static void main(String[] args) throws InterruptedException {
        Observable<Long>src=Observable.interval(1, TimeUnit.SECONDS);
        src.subscribe(e->System.out.println("Observer 1: "+e));
        src.subscribe(e->System.out.println("Observer 2: "+e));

        Thread.sleep(10000);
    }
}

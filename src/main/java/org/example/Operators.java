package org.example;

import io.reactivex.rxjava3.core.Observable;

public class Operators {

    public static void main(String[] args) {
        Observable.just(60,50,100,69,85)
                .filter(e->e>75)
                .sorted()
                .subscribe(e-> System.out.println("Grade a with : "+e));
    }
}

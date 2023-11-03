package org.example;

import java.math.BigDecimal;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Function {


    public static void main(String[] args) {
        // return void
        Consumer<String> printIt=System.out::println;
        printIt.accept("Hi");

        //return boolean
        Predicate<String> filter=valor->valor.length()>10;
        filter.test("peque");

        // recieve 2 parameters one it's a input and another it's a output apply
        java.util.function.Function<String, Integer> transform= String::length;
        transform.apply("thanks");

        Supplier<Double> ram=()->Math.random();
        ram.get();







    }
}


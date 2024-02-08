package com.kelsonthony;

import io.reactivex.rxjava3.core.Observable;

public class A_SimpleObservable {
    public static void main(String[] args) {

        Observable<String> observable = Observable.create(emitter -> {
            emitter.onNext("Click number 1");
            emitter.onNext("Click number 2");
            emitter.onNext("Click number 3");
            emitter.onNext("Click number 4");
            //throw new Exception("Something bad happened");
            emitter.onComplete();
        });

        observable.subscribe(item -> {
            System.out.println("My: " + item);
        }, throwable -> {
            System.out.println(throwable.getMessage());
        }, () -> {
            System.out.println("On complete!");
        });

    }
}

package com.kelsonthony;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class O_ObserveOn {
    public static void main(String[] args) {
        Observable.just("Hello World")
                .subscribeOn(Schedulers.io())
                .doOnNext(item -> System.out.println("Emitting item: "
                + Thread.currentThread().getName()))
                .observeOn(Schedulers.single())
                .subscribe(item -> System.out.println("Observing item: "
                + Thread.currentThread().getName()));

        //prevent Main thread of this console application to finish
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

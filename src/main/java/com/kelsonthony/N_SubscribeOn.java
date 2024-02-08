package com.kelsonthony;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class N_SubscribeOn {
    public static void main(String[] args) {
        Observable.just(1,2,3,4, 5)
                .doOnNext(item -> System.out.println("Pushing item " + item + " on "
                        + Thread.currentThread().getName() + " thread \n"))
                .subscribeOn(Schedulers.computation())
                .subscribe(item -> System.out.println("Pushing item " + item
                        + " on " + Thread.currentThread().getName() + " thread \n"));

        //prevent Main thread of this console application to finish
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package com.kelsonthony;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;

public class G_HotColdObservable {
    public static void main(String[] args) throws InterruptedException {
        //coldObservableExample();
        hotObservableExample();
    }



    private static void coldObservableExample() {
        Observable observable = Observable.just("a", "b", "c");

        observable.subscribe((item) -> System.out.println("Observer 1 - " + item));
        observable.subscribe((item) -> System.out.println("Observer 2 - " + item));
        observable.subscribe((item) -> System.out.println("Observer 3 - " + item));
    }

    private static void hotObservableExample() throws InterruptedException {
        ConnectableObservable observable = Observable.interval(1, TimeUnit.SECONDS).publish();

        observable.connect();

        observable.subscribe(item -> {
            System.out.println("Observer 1, sec: " + item);
        });

        Thread.sleep(5000);

        observable.subscribe(item -> {
            System.out.println("Observer 2, sec: " + item);
        });

        Thread.sleep(100000);
    }
}

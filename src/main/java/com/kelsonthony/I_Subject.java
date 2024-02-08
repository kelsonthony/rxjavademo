package com.kelsonthony;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

import java.util.concurrent.TimeUnit;

public class I_Subject {

    public static void main(String[] args) {


        //create two sources
        Observable<Long> source1 = Observable.interval(1, TimeUnit.SECONDS);
        Observable<Long> source2 = Observable.interval(1, TimeUnit.SECONDS);

        //create PublishSubject object
        Subject<Long> subject = PublishSubject.create();

        // subscribe to the PublishSubject object
        subject.subscribe(item -> System.out.println("Received item: " + item));

        // we still need to tell our subject that it will receive items
        // from two differents sources
        source1.subscribe(subject);
        source2.subscribe(subject);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            ;
        }
    }
}






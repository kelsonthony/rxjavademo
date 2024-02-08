package com.kelsonthony;

import io.reactivex.rxjava3.subjects.ReplaySubject;
import io.reactivex.rxjava3.subjects.Subject;

public class K_ReplaySubject {
    public static void main(String[] args) {
        //represents Teacher
        Subject<Integer> subject = ReplaySubject.create();

        subject.subscribe(item -> System.out.println("Student A received: " + item));

        //teacher talks about some imports topics
        subject.onNext(1);
        subject.onNext(2);
        subject.onNext(3);

        //student B entered classroom, but he is late
        subject.subscribe(item -> System.out.println("Student B received: " + item));
    }
}

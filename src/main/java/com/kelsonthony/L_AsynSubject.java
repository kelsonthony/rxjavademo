package com.kelsonthony;

import io.reactivex.rxjava3.subjects.AsyncSubject;
import io.reactivex.rxjava3.subjects.ReplaySubject;
import io.reactivex.rxjava3.subjects.Subject;

public class L_AsynSubject {
    public static void main(String[] args) {
        //represents Teacher
        AsyncSubject<Integer> subject = AsyncSubject.create();

        //student A entres the classroom
        subject.subscribe(item -> System.out.println("Student A received: " + item));

        //teacher talks about some boring topics
        subject.onNext(1);
        subject.onNext(2);
        subject.onNext(3);

        //student B entered classroom
        subject.subscribe(item -> System.out.println("Student B received: " + item));

        //teacher talks about very imports information about exam!!!
        subject.onNext(4);

        //teacher ends the lesson
        subject.onComplete();
    }
}

package com.kelsonthony;

import io.reactivex.rxjava3.subjects.BehaviorSubject;
import io.reactivex.rxjava3.subjects.Subject;

public class J_BehaviorSubject {


    public static void main(String[] args) {
        // represent radio which play song on some room
        Subject<Integer> subject = BehaviorSubject.create();

        // person 1 enters the room and starts listening to the radio
        subject.subscribe(item -> System.out.println("Person 1  listen to song: " + item));


        subject.onNext(1);
        subject.onNext(2);
        subject.onNext(3);

        // person 2 entrers the room and starts listening to radio
        subject.subscribe(item -> System.out.println("Person 2 listen to song: " + item));
    }
}

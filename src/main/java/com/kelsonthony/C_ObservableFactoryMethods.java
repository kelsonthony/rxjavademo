package com.kelsonthony;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.ArrayList;
import java.util.List;

public class C_ObservableFactoryMethods {
    public static void main(String[] args) {
        Observable<String> observable = Observable.just("Item 1", "Item 2");
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);

        Observable<Integer> observable2 = Observable.fromIterable(numbers);

        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String s) {
                System.out.println(s);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                System.out.println("On Complete String");
            }
        };

        Observer<Integer> observer2 = new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Integer integer) {
                System.out.println(integer);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                System.out.println("On Complete numbers");
            }
        };

        observable.subscribe(observer);
        observable2.subscribe(observer2);
    }


}

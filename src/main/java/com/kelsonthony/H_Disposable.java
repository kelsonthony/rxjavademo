package com.kelsonthony;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.observers.ResourceObserver;

import java.util.concurrent.TimeUnit;

public class H_Disposable {
    public static void main(String[] args) {
        disposableExample1();
        disposableExample2();
        disposableExample3();
    }

    private static void disposableExample1() {
        Observable<Long> seconds = Observable.interval(1, TimeUnit.SECONDS);
        Disposable disposable = seconds.subscribe(l -> {
            System.out.println("Item: " + l);
        });

        if (disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    private static void disposableExample2() {
        Observable<Long> seconds = Observable.interval(1, TimeUnit.SECONDS);

        CompositeDisposable compositeDisposable = new CompositeDisposable();

        seconds.subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                compositeDisposable.add(d);
            }

            @Override
            public void onNext(@NonNull Long aLong) {

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
        compositeDisposable.dispose();
    }

    private static void disposableExample3() {
        Observable<Long> seconds = Observable.interval(1, TimeUnit.SECONDS);

        ResourceObserver<Long> resourceObserver = new ResourceObserver<Long>() {
            @Override
            public void onNext(@NonNull Long item) {
                System.out.println("Item: " + item);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        seconds.subscribe(resourceObserver);
        resourceObserver.dispose();
    }
}

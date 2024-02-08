package com.kelsonthony;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class F_Flowable {
    public static void main(String[] args) {
        //syncronousObservableExample();
        //asyncObservableExample();
        asyncFlowableExample();


    }

    private static void syncronousObservableExample() {
        Observable.range(1, 1000000)
                .map(id -> new Item(id))
                .subscribe(item -> {
                    Thread.sleep(1000);
                    System.out.println("Received MyItem sync: " + item.id + "\n");
                });


    }

    private static void asyncObservableExample() {
        Observable.range(1, 1000000)
                .map(Item::new)
                .observeOn(Schedulers.io())
                .subscribe(item -> {
                    Thread.sleep(1000);
                    System.out.println("Received MyItem Async: " + item.id + "\n");
                });
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void asyncFlowableExample() {
        Flowable.range(1, 1000000)
                .map(Item::new)
                .observeOn(Schedulers.io())
                .subscribe(item -> {
                    Thread.sleep(20);
                    System.out.println("Received MyItem Flowable: " + item.id + "\n");
                });

        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}

class Item {
    int id;

    public Item(int id) {
        this.id = id;
        System.out.println("Item is created: " + id);
    }
}
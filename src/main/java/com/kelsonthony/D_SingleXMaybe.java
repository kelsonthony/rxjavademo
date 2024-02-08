package com.kelsonthony;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;

public class D_SingleXMaybe {
    public static void main(String[] args) {
//        Single<String> single = createSingle();
//        single.subscribe(new SingleObserver<String>() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//
//            }
//
//            @Override
//            public void onSuccess(@NonNull String s) {
//                System.out.println(s);
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//                System.out.println(e.getMessage());
//
//            }
//        });

        Maybe<String> maybe = createMaybe();
        maybe.subscribe(new MaybeObserver<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onSuccess(@NonNull String s) {
                System.out.println(s);

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                System.out.println("No new content ");
            }
        });
    }

    public static Single<String> createSingle() {
        return Single.create(emitter -> {
           var user = fetchUser();

           if (user != null) {
               emitter.onSuccess(user);
           }
            else {
                emitter.onError(new Exception("User not found"));
           }
        });

    }

    public static String fetchUser() {
        return "John";
    }

    private static Maybe<String> createMaybe() {
        return Maybe.create(emitter -> {
            var newContent = readFile();

            if (newContent != null) {
                emitter.onSuccess(newContent);
            } else {
                emitter.onComplete();
            }
        });
    }

    private static String readFile() {
        return "New content is here"; // or return null
    }
}

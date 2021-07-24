package com.qooapp.kotlin.example.part3;

public class SingletonUtil_2 {

    private SingletonUtil_2() {
    }

    private static final SingletonUtil_2 INSTANCE;

    static {
        INSTANCE = new SingletonUtil_2();
    }

    public final boolean checkIsNull(Object arg) {
        return arg == null;
    }

    public static SingletonUtil_2 getInstance() {
        return INSTANCE;
    }
}

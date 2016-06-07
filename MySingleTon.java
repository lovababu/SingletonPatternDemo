package com.avol.test;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * Created by Durga on 4/11/2016.
 */
public class MySingleTon implements Serializable{

    private static MySingleTon INSTANCE;

    private MySingleTon() {
        if (INSTANCE != null) {
            throw new IllegalArgumentException("Operation not allowed.");
        }
    }

    public static MySingleTon getInstance() throws InterruptedException {
        if (INSTANCE == null) {
            synchronized (MySingleTon.class) {
                System.out.println("Thread entered into critical section: " + Thread.currentThread().getId());
                Thread.sleep(2000);
                //double check.
                if (INSTANCE == null) {
                    INSTANCE = new MySingleTon();
                }
            }
        }
        return INSTANCE;
    }

    private Object readResolve() throws ObjectStreamException {
        System.out.println("I am in readResolve.");
        return INSTANCE;
    }
}

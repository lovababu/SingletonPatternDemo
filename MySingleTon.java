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

    public synchronized static MySingleTon getInstance() throws InterruptedException {
        if (INSTANCE == null) {
            Thread.sleep(2000);
            INSTANCE = new MySingleTon();
        }
        return INSTANCE;
    }

    private Object readResolve() throws ObjectStreamException {
        System.out.println("I am in readResolve.");
        return INSTANCE;
    }
}
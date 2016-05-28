package com.avol.test;

import java.lang.reflect.Constructor;

/**
 * Tests with Reflection.
 * <p>
 * Created by Durga on 5/28/2016.
 */
public class SingleTonClient2 {

    public static void main(String[] args) {
        try {
            MySingleTon m1 = MySingleTon.getInstance();
            Class claz = MySingleTon.class;
            Constructor<MySingleTon> mySingleTonConstructor = claz.getDeclaredConstructor();
            mySingleTonConstructor.setAccessible(true);
            MySingleTon m2 = mySingleTonConstructor.newInstance();
            System.out.println("New instance has created :" + m2 + ", Ooops..! singleton broken.");
        } catch (Exception e) {
            System.out.println("Hurray, It's working. " + e.getCause().getMessage());
        }
    }
}

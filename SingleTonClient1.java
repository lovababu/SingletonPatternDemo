package com.avol.test;

/**
 * Tests with multiple calls to getInstance()
 *
 * Created by Durga on 5/28/2016.
 */
public class SingleTonClient1 {

    public static void main(String[] args) throws InterruptedException {
        MySingleTon m1 = MySingleTon.getInstance();
        MySingleTon m2 = MySingleTon.getInstance();
        if (m1 == m2) {
            System.out.println("Both m1 and m2 are identical.");
        } else {
            System.out.println("m1 and m2 are not identical, singleton failed.");
        }
    }
}

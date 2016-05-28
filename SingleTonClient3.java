package com.avol.test;

/**
 *  Tests the singleton when multiple threads trying to access getInstance()
 *
 * Created by Durga on 4/11/2016.
 */
public class SingleTonClient3 {

    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                try {
                    MySingleTon m1 = MySingleTon.getInstance();
                    System.out.println("m1 : " + m1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                try {
                    MySingleTon m2 = MySingleTon.getInstance();
                    System.out.println("m2 : " + m2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t3 = new Thread() {
            @Override
            public void run() {
                try {
                    MySingleTon m3 = MySingleTon.getInstance();
                    System.out.println("m3 : " + m3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        t1.start();
        t2.start();
        t3.start();

    }
}

package com.avol.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Paths;

/**
 * Created by Durga on 5/28/2016.
 */
public class SingleTonClient4 {

    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException {
        File file = Paths.get(System.getProperty("user.dir"), "singleTon.txt").toFile();
        MySingleTon m1 = MySingleTon.getInstance();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        objectOutputStream.writeObject(m1);

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        MySingleTon m2 = (MySingleTon) objectInputStream.readObject();
        if (m1 == m2) {
            System.out.println("Both m1, m2 are identical. Hurray its working.");
        }

        objectOutputStream.close();
        objectInputStream.close();
    }
}

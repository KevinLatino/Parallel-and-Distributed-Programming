package com.mycompany.ejercicio7;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SolucionEjercicio7 {

    public static final List<Integer> LIST = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws InterruptedException {

        Thread modifier = new Thread(new ModifierRunnable());
        Thread iterator = new Thread(new IteratorRunnable());

        modifier.start();
        iterator.start();

        modifier.join();
        iterator.join();
    }

    public static final class ModifierRunnable implements Runnable {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 50000; i++) {
                    LIST.add(i);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static final class IteratorRunnable implements Runnable {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 10000; i++) {
                    long total = 0;
                    for (Integer inList : LIST) {
                        total += inList;
                    }
                    System.out.println(total);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

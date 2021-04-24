package com.thread;

public class Testthread2 {
    public static void main(String[] args) {
        Myrunnable3 myrunnable3 = new Myrunnable3();
        Thread thread3 = new Thread(myrunnable3);
        thread3.setName("TTT");
        thread3.setDaemon(true);
        thread3.start();

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+"--"+i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class Myrunnable3 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+"--"+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

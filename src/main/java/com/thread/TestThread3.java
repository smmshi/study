package com.thread;

import java.util.concurrent.locks.ReentrantLock;

public class TestThread3 {
    public static void main(String[] args) {
        Myrunnable4 myrunnable4 = new Myrunnable4();
        Thread thread1 = new Thread(myrunnable4);
        Thread thread2 = new Thread(myrunnable4);
        thread1.start();
        thread2.start();

    }
}
class Myrunnable4 implements Runnable {
    private int ticket = 10;

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            if (ticket > 0) {
//                synchronized (this) {
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                    System.out.println("还剩下" + ticket + "张票");
//                    ticket--;
//                }
                method();

            }
        }
    }

    ReentrantLock lock = new ReentrantLock();
    private  void method() {
        lock.lock();
        try {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("还剩下" + ticket + "张票");
            ticket--;
        }finally {
            lock.unlock();
        }

    }

//    private synchronized void method() {
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("还剩下" + ticket + "张票");
//        ticket--;
//    }
}
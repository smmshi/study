package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThread5 {
    public static void main(String[] args) {
        //创建线程池怼放肆
        //1
//        ExecutorService es = Executors.newSingleThreadExecutor();
        //2
        ExecutorService es = Executors.newFixedThreadPool(2);

        es.execute(new Myrunnable10());
        es.execute(new Myrunnable10());
        es.shutdown();



    }
}
class Myrunnable10 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"-->"+i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

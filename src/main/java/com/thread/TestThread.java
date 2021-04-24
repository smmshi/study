package com.thread;


public class TestThread {
    public static void main(String[] args) {
//        Mythread mythread = new Mythread();
//        mythread.start();

        //Myrunnable myrunnable = new Myrunnable();
        //Thread thread = new Thread(myrunnable);
       // thread.start();
        Myrunnable2 myrunnable2 = new Myrunnable2();
        Thread thread2 = new Thread(myrunnable2);
        thread2.start();


        for (int i =0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+"--"+i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i==20){
                //join的用法
//                try {
//                    thread.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                //thread.interrupt();//中断标记
                myrunnable2.setFlag(false);
            }


        }



    }
}

class Mythread extends Thread{
    @Override
    public void run() {
        for (int i =0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+"--"+i);
        }
    }
}

class Myrunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (Thread.interrupted()){
                break;
            }
            System.out.println(Thread.currentThread().getName() + "--" + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }
}


class Myrunnable2 implements Runnable{
    private boolean flag = true;
    public void setFlag(boolean flag){
        this.flag=flag;
    }

    @Override
    public void run() {
        int i =0;
        while (flag){
            System.out.println(Thread.currentThread().getName()+"--"+(i++));
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
package com.thread;

public class TestThread4 {
    public static void main(String[] args) {
        Food food = new Food();
        Chief chief = new Chief(food);
        Consumer consumer = new Consumer(food);
        Thread thread1 = new Thread(chief);
        Thread thread2 = new Thread(consumer);
        thread1.start();
        thread2.start();
    }
}

class Chief implements Runnable{
    private Food food;
    public Chief(Food food){
        this.food=food;

    }
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            if (i%2==0){
                food.set("玉米","主食");
            }else {
                food.set("五花肉", "大菜");
            }
        }
    }
}
class Consumer implements Runnable{
    private Food food;
    public Consumer(Food food){
        this.food=food;

    }
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            food.get();
            System.out.println("吃了");

        }

    }
}
class Food{
    private String name;
    private  String desc;
    private boolean flag =true;

    public  synchronized void set(String name, String desc){
        if(flag != true){
            try {
                this.wait(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name=name;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.desc=desc;
        flag=false;
    }

    public synchronized void get(){
        if(flag){
            try {
                this.wait(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getName()+"->"+this.getDesc());
        flag=true;
    }

    public Food(){

    }
    public Food(String name,String desc){
        this.name=name;
        this.desc=desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}

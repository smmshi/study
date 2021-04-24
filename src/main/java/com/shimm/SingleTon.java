package com.shimm;

public class SingleTon {
    public static void main(String[] args) {
        singleton1 s1 = singleton1.getInstance();
        s1.test1();
    }

}
class  singleton1{
    private singleton1() {
    }
    private static singleton1 s =new singleton1();
    public  static  singleton1 getInstance(){
        return s;
    }
    public void test1(){
        System.out.println("singleton1");
    }
}

class singleton2{
    private singleton2(){}
    private static singleton2 s;
    public  static  singleton2 getInstance(){
        if (s==null){
            s =new singleton2();
        }
        return s;
    }
    public void test1(){
        System.out.println("singleton2");
    }

}

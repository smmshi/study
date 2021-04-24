package com.shimm;

public class SimpleFactory {
    public static void main(String[] args) {
        Factory ft = new Factory();
        Product pr = ft.produce("Phone");
        pr.work();
    }
}

class Factory{
    public Product produce(String name){
        if ("Phone".equals(name)){
            return  new Phone();
        }
        if ("Computer".equals(name)){
            return  new Computer();
        }
        return null;
    }
}

interface Product{
    public void work();
}
class Phone implements Product{
    public void work(){
        System.out.println("手机工作");
    }
}

class Computer implements Product{
    public  void  work(){
        System.out.println("电脑工作");
    }
}
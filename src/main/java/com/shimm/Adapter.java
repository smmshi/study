package com.shimm;

public class Adapter {
    public static void main(String[] args) {
        PowerA pa = new PoweraImp();
        work(pa);
        PowerB pb =new PowerbImp();
        Adapter1 adapter = new Adapter1(pb);
        work(adapter);

    }
    public static void  work (PowerA a){
        a.insert();
    }
}

class Adapter1 implements PowerA{
    private PowerB pb;
    public Adapter1(PowerB pb) {
        this.pb = pb;
    }
    @Override
    public void insert() {
        pb.newinsert();
    }
}
interface PowerA{
    public void insert();
}
class PoweraImp implements  PowerA{
    public void insert(){
        System.out.println("电源A开始工作");
    }
}
interface PowerB{
    public void newinsert();
}

class PowerbImp implements PowerB{
    @Override
    public void newinsert() {
        System.out.println("电源B开始工作");
    }
}

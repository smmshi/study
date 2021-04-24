package com.shimm;

public class InnerOutter {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.inner inner = outer.new inner();
        inner.print();

        Outer.inner2 inner2 = new Outer.inner2();
        inner2.print();

        outer.methodprint();

        outer.print();

        outer.print2();


        outer.print3(new A() {
            @Override
            public void eat() {
                System.out.println("方法匿名类");
            }
        });
    }
}

class Outer {
    //----------成员内部类----------------
    class inner{
        public void print(){
            System.out.println("成员内部类");
        }
    }
    //----------静态内部类----------------
    static class  inner2{
        public  void  print(){
            System.out.println("静态内部类");
        }
    }

    //--------方法内部类-------------------
    public void methodprint(){
        final int x =10;
        class innner3{
            public  void  print(){
                System.out.println("方法内部类"+x);
            }
        }
        innner3 innner3 = new innner3();
        innner3.print();
    }

    //---------继承匿名内部类----------------
    public  void  print(){
        A a = new A() {
            @Override
            public void eat() {
                System.out.println("继承匿名内部类");
            }
        };
        a.eat();
    }

    //---------接口匿名内部类----------------

    public  void print2(){
        B b = new B() {
            @Override
            public void run() {
                System.out.println("接口匿名内部类");
            }
        };
        b.run();
    }

    //----------方法匿名类------------------
    public void print3(A a){
        a.eat();
    }


}

abstract class A{
    public abstract void eat();
}

interface  B {
    public void run();
}

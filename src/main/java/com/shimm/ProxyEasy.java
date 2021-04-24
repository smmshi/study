package com.shimm;

public class ProxyEasy {
    public static void main(String[] args) {
        Proxy proxy = new Proxy(new UserAction());
        proxy.dothings();
    }
}
interface Action{
    public void dothings();
}
class UserAction implements Action{
    public void dothings(){
        for (int i =0;i<100;i++) {
            System.out.println("用户工作啦");
        }
    }
}
class Proxy implements Action{
    private Action action;
    public Proxy() {
    }
    public Proxy(Action action) {
        this.action = action;
    }
    public void dothings(){
        long start = System.currentTimeMillis();
        action.dothings();
        long end = System.currentTimeMillis();
        System.out.println("用户工作时间="+(end-start));
    }
}

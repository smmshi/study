package com.shimm;

public class TemplateMethod {
    public static void main(String[] args) {
        Usermanage um = new Usermanage();
        um.action("qqq","add");

    }
}
abstract class  Basemanage{
    public void action(String username,String method){
        if ("admin".equals(username)){
            System.out.println("登陆成功");
            exec(method);

        }
        else {
            System.out.println("没有权限");
        }
    }

    public abstract void  exec(String method);
}

class Usermanage extends Basemanage{
    public void exec(String method){
        if ("add".equals(method)){
            System.out.println("使用添加方法");
        }else
            System.out.println("使用其他方法");
    }
}

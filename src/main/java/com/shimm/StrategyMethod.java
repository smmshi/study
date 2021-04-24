package com.shimm;

public class StrategyMethod {
    public static void main(String[] args) {
        BaseService um = new UserManage();
        um.setIsave(new FileSave());
        um.add();
    }
}

interface Isave{
    public void save();
}

class FileSave implements Isave{
    public void save(){
        System.out.println("使用文件存储");
    }
}
class  NetSave implements Isave{
    public void save(){
        System.out.println("使用网络存储");
    }
}

abstract class BaseService{
    private Isave isave;
    public void setIsave(Isave isave){
        this.isave =isave;
    }
    public void add(){
        isave.save();
    }
}

class UserManage extends BaseService{

    public UserManage() {
    }
}
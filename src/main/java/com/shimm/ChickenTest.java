package com.shimm;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
public class ChickenTest {
    public static void main(String[] args) {
        ChickenManage cm = new ChickenManage(5);
        cm.add(new Chicken(1,"xiaoji1","3"));
        cm.add(new Chicken(2,"xiaoji2","3"));
        cm.add(new Chicken(3,"xiaoji3","3"));
        cm.add(new Chicken(4,"xiaoji4","3"));
        cm.add(new Chicken(5,"xiaoji5","3"));
        cm.add(new Chicken(6,"xiaoji6","3"));
        System.out.println("---------findall-----------");
        cm.printall();
        System.out.println("---------find-----------");
        Chicken ck1 = cm.find(1);
        ck1.print();
        System.out.println("---------Update-----------");
        cm.update(new Chicken(3,"gaibai","22"));
        cm.printall();
        System.out.println("---------delete-----------");
        cm.delete(1);
        cm.printall();



    }
}

class ChickenManage{
    private int count =0;
    private Chicken[] cs =null;
    public ChickenManage(int size){
        if (size>0){
            cs=new Chicken[size];
        }
        cs=new Chicken[5];
    }

    public void add(Chicken c){
        if (count>=cs.length){
            //扩充鸡舍怼大小   扩充为原来的1倍
            cs = Arrays.copyOf(cs, cs.length * 3 / 2 + 1);
        }
        cs[count]=c;
        count ++;
    }

    public void update(Chicken c){
        Chicken temp = find(c.getId());
        if (temp!=null){
            temp.setName(c.getName());
            temp.setAge(c.getAge());

        }

    }

    public Chicken find(int id){
        for (int i=0;i<count;i++){
            if(id==i){
                return cs[i];
            }
        }
        return null;
    }

    public void delete(int id){
        for (int i=0 ;i<count;i++){
            if (cs[i].getId()==id){
                for (int j=i; j<count-1;j++) {
                    cs[j] = cs[j + 1];
                }
                cs[count-1]=null;
                count--;
                break;
            }
        }

    }

    public void printall(){
        for (int i =0 ;i<count;i++){
            cs[i].print();
        }
    }


}

class Chicken {
    int id;
    String name;
    String age;

    public Chicken() {
    }

    public Chicken(int id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "chicken{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public void print(){
        System.out.println("id="+id+"name="+name+"age="+age);
    }


}

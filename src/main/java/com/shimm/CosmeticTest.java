package com.shimm;

import java.util.Arrays;

public class CosmeticTest {
    public static void main(String[] args) {
        CosmeticMange cm =new SortCosmetic();
        cm.add(new Cosmetic("ysl","guowai",200));
        cm.add(new Cosmetic("dabao","guone",13));
        cm.add(new Cosmetic("channel","guowai",300));
        cm.add(new Cosmetic("kkl","guowai",100));
        cm.add(new Cosmetic("zst","guowai",150));
        cm.add(new Cosmetic("cn","guone",10));
        cm.printall();

    }
}
class SortCosmetic extends CosmeticMange{
    public void  printall(){
        Cosmetic[] temp =Arrays.copyOf(cs,count);
        for (int i=0;i<temp.length-1;i++){
            for (int j=i+1;j<temp.length;j++){
                if (temp[i].getPrice()>= temp[j].getPrice()){
                    Cosmetic a = temp[i];
                    temp[i]=temp[j];
                    temp[j]=a;
                }
            }
        }
        for (Cosmetic c:temp) {
            c.print();
        }

    }

}
class CosmeticMange{
    public CosmeticMange() {
    }

    protected int count = 0;
    protected Cosmetic[] cs = new Cosmetic[5];
    public void add(Cosmetic c){
        if (count>=cs.length){
            cs = Arrays.copyOf(cs,cs.length*2);
        }
        cs[count]=c;
        count++;
    }

    public void  printall(){
        for (int i=0 ; i<count;i++){
            cs[i].print();
        }
    }
}
class Cosmetic{
    private String name;
    private String type;
    private float price;

    public Cosmetic() {
    }

    public Cosmetic(String name, String type, float price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Cosmetic{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }

    public void print(){
        System.out.println("name:"+name+",type:"+type+",price:"+price);
    }
}

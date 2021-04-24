package com.shimm;

import org.omg.CORBA.PUBLIC_MEMBER;

public class LinkList {
    public static void main(String[] args) {
        ManageNode mn = new ManageNode();
        mn.add(1);
        mn.add(2);
        mn.add(2);
        mn.add(5);
        mn.print();
//        System.out.println(mn.find(8));
//        mn.delete(2);
//        mn.print();
//        System.out.println("------update---------");
//        System.out.println(mn.update(5,3));
//        mn.print();
        System.out.println("------insert---------");
        mn.insert(9,1);
        mn.print();
    }
}
class  ManageNode {
    private Node root;
    private int currentid = 0;
    //添加
    public  void add(int data){
        if (root == null){
            root =new Node(data);
        }else{
            root.addNode(data);
        }

    }
    //删除
    public void delete(int data){
        if (root ==null){
            System.out.println("root null");
        }else if (root.getData() ==data){
            root=root.next;
        }else {
            root.deleteNode(data);
        }

    }
    //查找
    public  boolean  find(int data){
        if (root == null){
            return false;
        }
        if (root.getData()==data){
            return true;
        }else {
            return root.findNode(data);
        }
    }
    //更新
    public boolean update(int olddata,int newdata){
        if (root!=null){
            if (root.getData()==olddata){
                root.setData(newdata);
                return true;
            }else {
                return  root.updateNode(olddata,newdata);
            }
        }
        return false;
    }

    //往前面插入
    public void insert(int data,int id){
        if (root==null){
            root=new Node(data);
        }else{
            if (id == currentid){
                Node temp =root;
                root= new Node(data);
                root.next =temp;

            }else {
                root.insertNode(data,id);
            }
        }
    }

    //打印所有
    public  void  print(){
        if(root != null){
            System.out.print(root.getData()+"->");
            root.prinNode();
            System.out.println();
        }
    }

    class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void addNode(int data) {
            if (this.next == null) {
                this.next = new Node(data);
            }else {
                this.next.addNode(data);
            }
        }
        //删除
        public void deleteNode(int data){
            if (this.next != null){
                if (this.next.getData() == data){
                    this.next=this.next.next;
                }else {
                    this.next.deleteNode(data);
                }
            }
        }
        //查找
        public boolean findNode(int data){
            if (this.next!=null) {
                if (this.next.getData() == data) {
                    return true;
                }else {
                    this.next.findNode(data);
                }
            }
            return false;

        }
        //更新
        public  boolean updateNode(int olddata,int newdata){
            if (this.next !=null){
                if (this.next.getData() == olddata){
                    this.next.setData(newdata);
                    return true;
                }else {
                    this.next.updateNode(olddata,newdata);
                }
            }
            return false;
        }
        //插入
        public void insertNode(int data,int id){
            currentid++;
            if (this.next!= null){
                if (id ==currentid){
                    Node temp =this.next;
                    this.next=new Node(data);
                    this.next.next=temp;
                }else {
                    this.next.insertNode(data,id);
                }
            }

        }
        public void prinNode(){
            if (this.next != null){
                System.out.print(this.next.getData()+"->");
                this.next.prinNode();
            }

        }
    }
}


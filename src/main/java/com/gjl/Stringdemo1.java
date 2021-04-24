package com.gjl;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Locale;

public class Stringdemo1 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s1 = "11aass";
        String s0 = "999kkk";
        char c = s1.charAt(2);
        System.out.println(c);
        char[] chars = s1.toCharArray();
        for (char s:chars
             ) {
            System.out.println(s);

        }
        char[] aa ={'a','b','c','d'};
        String s2 =new String(aa);
        System.out.println("s2="+s2);
        String s3 =new String(aa,0,2);
        System.out.println("s3="+s3);
        byte[] bytes1 = s1.getBytes(StandardCharsets.UTF_8);
        System.out.println(Arrays.toString(bytes1));
        String s4= new String(bytes1);
        System.out.println("s4="+s4);
        String s5= new String(bytes1,1,3);
        System.out.println("s5="+s5);
        String s6= new String(bytes1,"utf-8");
        System.out.println("s6="+s6);

        s1.replace('a','c');
        System.out.println("------------------");
        System.out.println("1"+s1);

        s1.replace("ss","bb");
        System.out.println("------------------");
        System.out.println("2"+s1);
        s1.replaceAll("[0-9]", "*");
        System.out.println("------------------");
        System.out.println("3"+s1);
        s0.replaceFirst("[0-9]","a");
        System.out.println("------------------");
        System.out.println("4"+s1);
        s0.substring(2);
        System.out.println("------------------");
        System.out.println("5"+s0);
        s0.substring(3,4);
        System.out.println("------------------");
        System.out.println("6"+s0);
        boolean a = s0.contains("a");
        System.out.println("------------------");
        System.out.println("7"+a);
        int i = s0.indexOf(2);

        int a1 = s0.indexOf("a", 1);


        int aaa = s0.indexOf("aaa");


        boolean empty = s0.isEmpty();
        int length = s0.length();
        s0.toLowerCase();
        s0.toUpperCase();
        s0.trim();
        s0.concat("llll");


    }


}

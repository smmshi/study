package com.shimm;

import com.google.protobuf.InvalidProtocolBufferException;
import org.apache.http.client.HttpClient;
import org.junit.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class protobufTest {
    @Test
    public void testN() throws IOException {
        Firstprotobuf.Person.Builder builder = Firstprotobuf.Person.newBuilder();
        builder.setName("xinyijun");
        builder.setMobile("15757164023");
        builder.setSex("nv");

        Firstprotobuf.Person info = builder.build();

        byte[] result = info.toByteArray();

        try {
            Firstprotobuf.Person newP = Firstprotobuf.Person.parseFrom(result);
            System.out.println(newP);
        }catch(InvalidProtocolBufferException e){
            e.printStackTrace();
        }
//        HttpClient httpClient = new HttpClient();
        URL url = new URL("http://123.com");
        URLConnection connection = url.openConnection();
        connection.setDoInput(true);
        info.writeTo(connection.getOutputStream());
        Firstprotobuf.Person personres = Firstprotobuf.Person.parseFrom(connection.getInputStream());



    }
}


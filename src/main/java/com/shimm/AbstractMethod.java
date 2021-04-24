package com.shimm;


import com.google.protobuf.Message;
import com.googlecode.protobuf.format.JsonFormat;
import org.junit.Test;

public class AbstractMethod {
    @Test

    public void js2Pb() throws JsonFormat.ParseException {
        String jsonStr = "{\"message\" : \"success\"}";
//        Firstprotobuf.Person.Builder builder = Firstprotobuf.Person.newBuilder();
////        JsonFormat.merge(JsonFormat,builder);
//        Firstprotobuf.Person data = builder.build();

        Message instance = Firstprotobuf.Person.getDefaultInstance();
        String jsonFormat = JsonFormat.printToString(instance);

        Message.Builder builder = Firstprotobuf.Person.newBuilder();
        JsonFormat.merge(jsonStr, builder);


//        Protocol_100.Response.Builder builder=Protocol_100.Response.newBuilder();
//        try {
//            JsonFormat.merge(jsonFormat, builder);
//        } catch (com.googlecode.protobuf.format.JsonFormat.ParseException e) {
//// TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        Protocol_100.Response rb=builder.build();
//        System.out.println("getId:" + rb.getPlayer().getId());  
//        System.out.println("getName:" + rb.getPlayer().getName());  

    }
}

package Nettest;

import java.io.*;
import java.net.Socket;

public class ClientNet {
    public static void main(String[] args) {
        try {
            Socket clsocket = new Socket("localhost", 8888);
            PrintStream ps = new PrintStream(new FilterOutputStream(clsocket.getOutputStream()));
            ps.println("一号客户端发送消息");
            BufferedReader br = new BufferedReader(new InputStreamReader(clsocket.getInputStream()));
            String s = br.readLine();
            System.out.println(s);
            ps.flush();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

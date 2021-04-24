package Nettest;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerNet {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(7777);
            System.out.println("服务端开启，等待链接");
            Socket socket = server.accept();
            System.out.println("客户端已经链接");
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String info =br.readLine();
            System.out.println(info);
            PrintStream ps = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
            ps.println("echo:"+info);
            ps.flush();
            br.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

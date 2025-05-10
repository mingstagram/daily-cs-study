package network;

import java.io.*;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 9999);

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println("TCP로 전송하는 메시지입니다!");

        out.close();
        socket.close();
    }
}
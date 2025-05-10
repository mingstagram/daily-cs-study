package network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("TCP 서버 대기 중...");

        Socket clientSocket = serverSocket.accept();
        System.out.println("클라이언트 연결 완료!");

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String message = in.readLine();
        System.out.println("받은 메시지: " + message);

        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}

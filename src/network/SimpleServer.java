package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999); // 9999번 포트로 서버 열기
        System.out.println("서버 대기 중...");

        Socket clientSocket = serverSocket.accept(); // 클라이언트 접속 대기
        System.out.println("클라이언트 연결 완료!");

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println("받은 메시지: " + inputLine);
        }

        in.close();
        clientSocket.close();
        serverSocket.close();

    }

}

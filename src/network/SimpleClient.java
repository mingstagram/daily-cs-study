package network;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 9999); // 서버에 접속 (localhost 기준)

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println("안녕하세요 서버님!");

        out.close();
        socket.close();
    }
}

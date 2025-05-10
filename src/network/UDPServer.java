package network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(9999);
        byte[] buffer = new byte[1024];

        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        System.out.println("UDP 서버 대기 중...");

        socket.receive(packet); // 데이터 수신
        String message = new String(packet.getData()).trim();
        System.out.println("받은 메시지: " + message);

        socket.close();
    }
}

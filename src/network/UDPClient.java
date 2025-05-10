package network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress address = InetAddress.getByName("localhost");

        byte[] buffer = "UDP로 전송하는 메시지입니다!".getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 9999);

        socket.send(packet); // 데이터 전송
        socket.close();
    }
}

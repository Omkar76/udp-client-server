import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        byte[] buffer = new byte[256];

        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getLocalHost(), 4000);

        boolean running = true;
        Scanner sc = new Scanner(System.in);

        try (DatagramSocket socket = new DatagramSocket()) {
            while(running){
                String data = sc.nextLine();
                packet.setData(data.getBytes());
                packet.setLength(data.length());
                socket.send(packet);

                if(packet.getData().length == 1) {
                    running = false;
                }
            }
        }
    }
}

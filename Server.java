import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.util.Arrays;

public class Server {

    public static void main(String[] args) throws IOException {
        byte[] buffer = new byte[256];

        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        boolean running = true;

        try (DatagramSocket socket = new DatagramSocket(4000)) {
            while(running){
                socket.receive(packet);
                System.out.println(new String(packet.getData(), packet.getOffset(), packet.getLength()));

                if(packet.getData().length == 1) {
                    running = false;
                }
            }
        }
    }
}

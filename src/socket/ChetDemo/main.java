package socket.ChetDemo;

import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by lenovo on 2017/3/9.
 */
public class main {
    public static void main(String[] args) throws SocketException {
        DatagramSocket send=new DatagramSocket();
        DatagramSocket rece=new DatagramSocket(10001);
        new Thread(new sender(send)).start();
        new Thread(new receiver(rece)).start();
    }
}

package socket.UDP;

import java.io.IOException;
import java.net.*;

/**
 * 创建UDP传输的发送端的
 * /        *思路：
 * /          1.建立UDP的socket服务
 * /          2.将要发送的数据封装到datagram中
 * /          3.通过UDP的socket服务将datagram发送出去
 * /          4.关闭socket服务
 */
public class UdpSender {
    public static void main(String[] args) throws IOException {

        //1.建立UDP的socket服务
        DatagramSocket ds=new DatagramSocket();

        //2.将要发送的数据封装到datagram中
        String str="this is a text to send";
        byte[] buf=str.getBytes();
        DatagramPacket dp=new DatagramPacket(buf, buf.length, InetAddress.getByName("10.0.0.3"),10000);

        //3.通过UDP的socket服务将datagram发送出去,使用send方法
        ds.send(dp);

        //4.关闭socket服务
        ds.close();
        System.out.println("sender closed");

    }

}
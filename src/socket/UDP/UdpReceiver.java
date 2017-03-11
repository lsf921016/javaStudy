package socket.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by lenovo on 2017/3/9.
 */
public class UdpReceiver {
    public static void main(String[] args) throws IOException {
        System.out.println("receiving.......");
        //1.建立udp服务
        DatagramSocket ds = new DatagramSocket(10000);
        //2.创建数据包，用于储存收到的数据，方便用数据包对象的方法解析这些数据
        byte[] buf = new byte[1024];
        DatagramPacket dp = new DatagramPacket(buf, buf.length);

        //3.使用socket服务的receive方法，将接受到的数据存入数据包中
        ds.receive(dp);//阻塞式

        //4.通过数据包中的方法解析包内数据,包括地址，端口，数据
        String ip=dp.getAddress().getHostAddress();
        int port=dp.getPort();
        String text=new String(dp.getData(),0,dp.getLength());
        System.out.println(ip+":"+port+":"+text);
        //5.关闭资源
        ds.close();
        System.out.println("receiver closed");
    }
}

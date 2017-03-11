package socket.ChetDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by lenovo on 2017/3/9.
 */
public class sender implements Runnable{
DatagramSocket ds;
public sender(DatagramSocket ds){
    this.ds=ds;
}

    @Override
    public void run() {
        BufferedReader bufr=new BufferedReader(new InputStreamReader(System.in));
        String line=null;
        try {
            while((line=bufr.readLine())!=null){
                byte[] buf=line.getBytes();
                DatagramPacket dp=new DatagramPacket(buf, buf.length, InetAddress.getByName("10.0.0.3"),10001);
                try {
                    ds.send(dp);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if(line.equals("over"))
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

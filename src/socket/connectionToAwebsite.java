package socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by lenovo on 2017/3/9.
 */
public class connectionToAwebsite {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("www.google.com", 13);//create connection and get a socket instance
            s.setSoTimeout(10000);//set the timeout
            //second method to create a socket
            Socket s2 = new Socket();
            s2.connect(new InetSocketAddress("www.google.com", 13), 10000);
            InputStream inStream = s.getInputStream();//get inputStream from socket by getInputsocketStream()
            Scanner in = new Scanner(inStream);
            while (in.hasNextLine()) {
                String line = in.nextLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

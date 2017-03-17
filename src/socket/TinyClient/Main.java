package socket.TinyClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by lenovo on 2017/3/16.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket(InetAddress.getLocalHost().getHostAddress(),8080);
        String localIp=InetAddress.getLocalHost().getHostAddress();

        PrintWriter pw=new PrintWriter(socket.getOutputStream(),true);

        pw.println("GET /examples/index.html HTTP/1.1");
        pw.println("Accept: */*");
        pw.println("Host: 10.0.0.3:8080");
        pw.println("Connection: close");
        pw.println();

        BufferedReader bufr=new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String line=null;
        int len=0;
        while((line=bufr.readLine())!=null){
            System.out.println(line);
        }
    }
}

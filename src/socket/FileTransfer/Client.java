package socket.FileTransfer;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by lenovo on 2017/3/14.
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 11111);

        BufferedReader bufr = new BufferedReader(new FileReader("E:\\javaStudy\\src\\socket\\FileTransfer\\cc"));
        PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);

        String line = null;
        while ((line = bufr.readLine()) != null) {
            pw.println(line);
        }
        bufr.close();
        socket.shutdownOutput();

        BufferedReader bufIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String response = bufIn.readLine();
        System.out.println(response);


        socket.close();
    }
}

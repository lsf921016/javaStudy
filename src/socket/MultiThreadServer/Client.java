package socket.MultiThreadServer;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by lenovo on 2017/3/15.
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 10011);

        //读取字节流
        BufferedInputStream bufis = new BufferedInputStream(new FileInputStream("E:\\javaStudy\\src\\1.jpg"));
        BufferedOutputStream bufos = new BufferedOutputStream(socket.getOutputStream());

        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = bufis.read(buf)) != -1) {
            bufos.write(buf, 0, len);
            bufos.flush();
        }
        bufis.close();
        socket.shutdownOutput();

        BufferedReader bufr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line = bufr.readLine();
        System.out.println(line);
        socket.close();
    }

}

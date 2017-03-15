package socket.FileTransfer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by lenovo on 2017/3/14.
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket(11111);
        Socket socket=ss.accept();
        System.out.println(socket.getInetAddress().getHostAddress()+"has connected");

        BufferedReader bufIn=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter pw=new PrintWriter(new FileWriter("E:\\javaStudy\\src\\socket\\FileTransfer\\pp"),true);

        String line=null;
        while ((line=bufIn.readLine())!=null){
            pw.println(line);
        }
        pw.close();

        PrintWriter pwOut=new PrintWriter(socket.getOutputStream(),true);
        pwOut.println("file has been uploaded");

        pwOut.close();
        ss.close();

    }
}

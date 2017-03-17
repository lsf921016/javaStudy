package socket.MultiThreadServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by lenovo on 2017/3/15.
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10011);
        while (true){
            Socket socket = ss.accept();

            new Thread(new UploadTask(socket)).start();
        }


    }
}

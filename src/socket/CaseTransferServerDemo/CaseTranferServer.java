package socket.CaseTransferServerDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 本demo实现一个TCP连接的服务器，接受来自客户端的数据，并：
 * 1.将其打印在控制台
 * 2.处理数据，转成大写字母返回给客户端
 */
public class CaseTranferServer {
    public static void main(String[] args) throws IOException {
        //建立serversocket服务
        ServerSocket ss=new ServerSocket(10001);

        //获取socket对象
        Socket socket=ss.accept();
        //获取socket输入流并装饰
        BufferedReader bufIn=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //获取socket输出流并装饰
        PrintWriter out=new PrintWriter(socket.getOutputStream(),true);

        String line=null;
        while ((line=bufIn.readLine())!=null){
            System.out.println(line);
            out.println(line.toUpperCase());
        }
        socket.close();
        ss.close();
    }

}

package socket.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by lenovo on 2017/3/9.
 * 建立tcp服务端的思路：
 * 1.通过Serversocket创建服务端socket服务
 * 2.服务端必须对外提供一个端口
 * 3.获取连接的客户端对象
 * 4.通过客户端对象获取socket流，读取客户端发来的数据
 * 5.关闭资源，关闭客户端，服务端
 */
public class Server {
    public static void main(String[] args) throws IOException {
        //创建服务端对象
        ServerSocket ss=new ServerSocket(9999);

        //获取连接的客户端对象
        Socket s=ss.accept();
        String ip=s.getInetAddress().getHostAddress();

        //通过socket对象获取输入流，来读取客户端发来的数据
        InputStream in=s.getInputStream();
        byte[] buf=new byte[1024];
        int len=in.read(buf);
        String text=new String(buf,0,len);
        System.out.println(ip+"server:"+text);

        //使用客户端socket对象的输出流给客户端返回数据
        OutputStream out=s.getOutputStream();
        out.write("gocha".getBytes());

        s.close();
    }
}

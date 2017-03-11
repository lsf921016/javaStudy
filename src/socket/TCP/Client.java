package socket.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by lenovo on 2017/3/9.
 *
 * TCP 传输，客户端建立的过程：
 *
 1.创建客户端socket对象，建议对象创建时就明确目的地
 2.如果连接建立成功，说明数据通道（socket流）已建立，
 可以通过getInputStream或getOutputStream来获取。
 3.用输出流将数据写出
 */
public class Client {
    public static void main(String[] args) throws IOException {
        //创建客户端socket服务
        Socket socket=new Socket("10.0.0.3",9999);

        //获取socket流中的输出流
        OutputStream out = socket.getOutputStream();

        //使用输出流将指定数据写出去
        out.write("第一条tcp发送的数据".getBytes());

        //读取服务端返回的数据，使用socket输入流
        InputStream in=socket.getInputStream();
        byte[] buf=new byte[1024];
        int len=in.read(buf);
        String text=new String(buf,0,len);
        System.out.println(text);

        //关闭资源
        socket.close();
    }
}

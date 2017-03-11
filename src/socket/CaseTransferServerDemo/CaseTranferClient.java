package socket.CaseTransferServerDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by lenovo on 2017/3/9.
 */
public class CaseTranferClient {
    public static void main(String[] args) throws IOException {
        //创建socket客户端对象
        Socket socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 10001);

        //获取键盘录入
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

        //socket输出流
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);

        //socket输入流，读取服务端返回的大写数据
        BufferedReader bufIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String line = null;
        while ((line = bufr.readLine()) != null) {

            if ("over".equals(line)) {
                break;
            }
            printWriter.println(line);

            //读取服务端发回的一行大写数据
            String UpperStr = bufIn.readLine();
            System.out.println(UpperStr);
        }
        socket.close();
    }
}

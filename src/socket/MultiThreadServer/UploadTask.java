package socket.MultiThreadServer;

import java.io.*;
import java.net.Socket;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by lenovo on 2017/3/15.
 */
public class UploadTask implements Runnable {
    private Socket socket;
    int count=0;
    public UploadTask(Socket socket) {
        this.socket=socket;
    }

    @Override
    public void run() {
        String ip=socket.getInetAddress().getHostAddress();
        System.out.println(ip+"has connected");
        try {
            BufferedInputStream bufis = new BufferedInputStream(socket.getInputStream());

            Path path=Paths.get("E:\\javaStudy\\src\\socket\\MultiThreadServer\\",ip);
            File file=path.toFile();
            while (file.exists()){
                Path newPath=Paths.get("E:\\javaStudy\\src\\socket\\MultiThreadServer\\",ip+count++);
               file=newPath.toFile();
            }
            BufferedOutputStream bufos = new BufferedOutputStream(new FileOutputStream
                    (file));

            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = bufis.read(buf)) != -1) {
                bufos.write(buf, 0, len);
                bufos.flush();
            }
            bufos.close();

            PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
            pw.println("the byte file has been uploaded");
            socket.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}

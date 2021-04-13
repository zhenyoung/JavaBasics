package pers.yangzhen.internet;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端接收到客户端的数据后，发送反馈给客户端
 * @author yangzhen
 * @create 2021-04-11 20:19
 */
public class TCPTest3 {

    @Test
    public void server() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        BufferedOutputStream bos = null;
        OutputStream os = null;
        try {
            serverSocket = new ServerSocket(9090);
            socket = serverSocket.accept();

            //获取输入流读取服务端的输出流的文件
            is = socket.getInputStream();

            //输出文件路径
            bos = new BufferedOutputStream(new FileOutputStream("E:/IDEAProject/JavaBasics/src/pers/yangzhen/internet/头像(CS端2).jpg"));

            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                bos.write(buffer, 0, len);//将文件通过bos流写到指定路径下
            }
            System.out.println("接收成功");

            //服务器给与客户端反馈
            os = socket.getOutputStream();
            os.write("服务器成功接收到数据，现反馈给你客户端".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        BufferedInputStream bis = null;
        ByteArrayOutputStream baos = null;
        try {
            socket = new Socket("127.0.0.1", 9090);
            os = socket.getOutputStream();

            //客户端从本地读取文件
            bis = new BufferedInputStream(new FileInputStream("E:/IDEAProject/JavaBasics/src/pers/yangzhen/io/iostreamdocuments/头像.jpg"));
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {//将文件从指定位置读到输入流中
                os.write(buffer, 0, len);//将文件通过输出流写出去，发送给指定IP地址下的端口
            }
            socket.shutdownOutput();//关闭数据的输出

            //接受来自于服务器端的数据，并显示到控制台上
            InputStream is = socket.getInputStream();
            //为了使得数据不乱码，使用ByteArrayOutputStream流
            baos = new ByteArrayOutputStream();
            byte[] buffer1 = new byte[20];
            int len1;
            while ((len1 = is.read(buffer1)) != -1){
                baos.write(buffer1,0,len1);
            }
            System.out.println(baos);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}

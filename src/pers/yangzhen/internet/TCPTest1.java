package pers.yangzhen.internet;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 客户端与服务端之间的数据通信
 * @author yangzhen
 * @create 2021-04-10 17:04
 */
public class TCPTest1 {


    //客户端发送信息给服务端，服务端将数据显示在控制台上
    //服务端
    @Test
    public void server(){
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;

        try {
            //1.创建服务器端的Socket，指明服务器的端口号（由于服务器就是在本机上跑的，所以服务器的ip不用指明）
            serverSocket = new ServerSocket(8899);

            //2.调用accept()表示接收来自客户端的Socket
            socket = serverSocket.accept();

            //3.获取输入流
            is = socket.getInputStream();

            //4.读取输入流的数据
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[5];
            int len;
            while ((len = is.read(buffer)) != -1){//字符读入buffer
                //InputStream字节流读取汉字可能会出现乱码，所以这里用ByteArrayOutputStream流来读取
                baos.write(buffer,0,len);
                //将字符写到ByteArrayOutputStream中的一个数组中，不需要关注到底是哪个数组
            }
            System.out.println(baos);//将读取的字符输出到控制台上
            System.out.println("收到了来自于：" + socket.getInetAddress().getHostAddress() + "的信息");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //5.资源关闭
            if(serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(baos != null){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    @Test
    public void client(){
        Socket socket = null;
        OutputStream os = null;
        try {

            //1.创建Socket对象，指明服务器的ip和端口号
//            InetAddress inet1 = InetAddress.getByName("127.0.0.1");//服务器的ip
//            socket = new Socket(inet1, 8899);
            socket = new Socket("127.0.0.1", 8899);//指明IP和端口

            //2.获取一个输出流，用于输出数据
            os = socket.getOutputStream();
            //3.写出数据
            os.write("这是来自客户端的一则信息".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}

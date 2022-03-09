package pers.yangzhen.io.iostream;

import org.junit.Test;

import java.io.*;

/**
 * 了解即可，用得较少
 * 1.标准输入输出流
 * 2.打印流
 * 3.数据流
 *
 * @author yangzhen
 * @create 2021-04-09 15:19
 */
public class OtherStream {
    public static void main(String[] args) {
        /*
         * 从键盘输入字符串，要求将读取到的整行字符串转换成大写输出。然后继续进行输入操作
         * 直到输入“e”或者”exit“时，退出程序
         * 尽管可以使用 Scanner，但是这里为了说明问题，用 System.in 流来解决问题
         * */
        BufferedReader bufferedReader = null;
        try {
            // 转换流，先打开控制台，允许用户输入，然后将 PrintStream 字节流转换成字符流读入
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            // 缓冲字符流
            bufferedReader = new BufferedReader(inputStreamReader);
            while (true) {
                System.out.println("输入信息(输入 e 或 exit 退出)：");
                String data = bufferedReader.readLine();
                if ("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)) {
                    System.out.println("程序结束");
                    break;
                }
                // 将读取的字符串转换成大写
                System.out.println(data.toUpperCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    // 数据输出流：将内存中的字符串、基本数据类型写入到文件中
    @Test
    public void test1() {
        DataOutputStream dataOutputStream = null;
        try {
            dataOutputStream = new DataOutputStream(
                    new FileOutputStream("./src/pers/yangzhen/io/iostreamfiles/destFile3.txt"));
            dataOutputStream.writeUTF("张三");
            dataOutputStream.flush();
            dataOutputStream.writeInt(20);
            dataOutputStream.flush();
            dataOutputStream.writeBoolean(true);
            dataOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dataOutputStream != null) {
                try {
                    dataOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    // 数据输入流：读出文件中的数据
    @Test
    public void test2() {
        DataInputStream dataInputStream = null;
        try {
            dataInputStream = new DataInputStream(
                    new FileInputStream("./src/pers/yangzhen/io/iostreamfiles/destFile3.txt"));
            System.out.println("name = " + dataInputStream.readUTF());
            System.out.println("age = " + dataInputStream.readInt());
            System.out.println("isMale = " + dataInputStream.readBoolean());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dataInputStream != null) {
                try {
                    dataInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    // 随机存取文件流
    @Test
    public void test3() {
        RandomAccessFile randomAccessFile1 = null;
        RandomAccessFile randomAccessFile2 = null;
        try {
            // r，read
            randomAccessFile1 = new RandomAccessFile(
                    new File("./src/pers/yangzhen/io/iostreamfiles/头像src.jpg"), "r");
            // rw，read write
            randomAccessFile2 = new RandomAccessFile(
                    new File("./src/pers/yangzhen/io/iostreamfiles/头像dest2.jpg"), "rw");
            byte[] buffer = new byte[1024];
            int len;
            while ((len = randomAccessFile1.read(buffer)) != -1) {
                randomAccessFile2.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (randomAccessFile1 != null) {
                try {
                    randomAccessFile1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (randomAccessFile2 != null) {
                try {
                    randomAccessFile2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
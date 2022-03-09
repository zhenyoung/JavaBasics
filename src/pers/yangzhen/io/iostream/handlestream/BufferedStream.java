package pers.yangzhen.io.iostream.handlestream;

import org.junit.Test;

import java.io.*;

/**
 * 缓冲流
 *
 * @author yangzhen
 * @create 2021-04-08 20:48
 */
public class BufferedStream {
    
    @Test
    public void test1() {
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            bufferedInputStream = new BufferedInputStream(
                    new FileInputStream("./src/pers/yangzhen/io/iostreamfiles/头像src.jpg"));
            bufferedOutputStream = new BufferedOutputStream(
                    new FileOutputStream("./src/pers/yangzhen/io/iostreamfiles/头像dest1.jpg"));
            
            byte[] buffer = new byte[5];
            int len;
            while ((len = bufferedInputStream.read(buffer)) != -1) {
                bufferedOutputStream.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 资源关闭：先关闭外层的流，再关闭内层的流，同一层的流顺序随意(类似关门)
            // 在关闭外层流的同时，内层流会自动地进行关闭
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    @Test
    public void test2() {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedReader = new BufferedReader(
                    new FileReader("./src/pers/yangzhen/io/iostreamfiles/srcFile.txt"));
            bufferedWriter = new BufferedWriter(
                    new FileWriter("./src/pers/yangzhen/io/iostreamfiles/destFile1.txt"));
            // 方式一：使用 char[]
//            char[] cbuf = new char[5];
//            int len;
//            while((len = bufferedReader.read(cbuf)) != -1){
//                bufferedWriter.write(cbuf,0,len);
//            }
            // 方式二：使用 String (缓冲字符流特有，之前普通的字符流并不能这样)
            String data;
            // 未到文件尾部
            while ((data = bufferedReader.readLine()) != null) {
                bufferedWriter.write(data);
                // 每读完一行就换行
                bufferedWriter.newLine();
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
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
package pers.yangzhen.io.iostream.handlestream;

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 转换流
 *
 * @author yangzhen
 * @create 2021-04-09 13:50
 */
public class ConvertStream {
    
    // 将一个字节的输入流转换为字符的输入流，InputStream-->Reader
    // 将一个字符的输出流转换为字节的输出流，Writer-->OutputStream
    
    // InputStream-->Reader
    @Test
    public void test1() {
        BufferedInputStream bufferedInputStream = null;
        InputStreamReader inputStreamReader = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(
                    "./src/pers/yangzhen/io/iostreamfiles/srcFile.txt"));
            // 使用默认编码
//        InputStreamReader inputStreamReader = new InputStreamReader(bufferedInputStream);
            // 使用指定编码
            inputStreamReader = new InputStreamReader(bufferedInputStream, StandardCharsets.UTF_8);
            char[] cbuf = new char[20];
            int len;
            while ((len = inputStreamReader.read(cbuf)) != -1) {
                // 输出到控制台。若要写到文件中，使用 write()new String(cbuf, 0, len)
                System.out.print(new String(cbuf, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    // Writer-->OutputStream
    @Test
    public void test2() {
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(
                    "./src/pers/yangzhen/io/iostreamfiles/srcFile.txt");
            FileOutputStream fileOutputStream = new FileOutputStream(
                    "./src/pers/yangzhen/io/iostreamfiles/destFile2.txt");
            inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            // 编码解码不一致会导致乱码
//            outputStreamWriter = new OutputStreamWriter(fileOutputStream, "GBK");
            outputStreamWriter = new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8);
            char[] cbuf = new char[20];
            int len;
            while ((len = inputStreamReader.read(cbuf)) != -1) {
                outputStreamWriter.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStreamWriter != null) {
                try {
                    outputStreamWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
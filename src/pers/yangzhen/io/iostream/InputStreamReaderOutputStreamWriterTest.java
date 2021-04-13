package pers.yangzhen.io.iostream;

import org.junit.Test;

import java.io.*;

/**
 * 转换流
 * @author yangzhen
 * @create 2021-04-09 13:50
 */
public class InputStreamReaderOutputStreamWriterTest {

    //将一个字节的输入流转换为字符的输入流，InputStream-->Reader
    //将一个字符的输出流转换为字节的输出流，Writer-->OutputStream

    //实现字节的输入流到字符的输入流的转换
    @Test
    public void test1(){
        BufferedInputStream bis = null;
        InputStreamReader isr = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(new File("E:\\IDEAProject\\JavaBasics\\src\\pers\\yangzhen\\io\\iostreamdocuments\\srcFile.txt")));
//        InputStreamReader isr = new InputStreamReader(bis);//默认使用IDEA自带的编码
            isr = new InputStreamReader(bis, "UTF-8");

            char[] cbuf = new char[20];
            int len;
            while ((len = isr.read(cbuf)) != -1){
                String str = new String(cbuf,0,len);
                System.out.println(str);//输出到控制台，若要写到文件中，使用write()
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(isr != null){
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @Test
    public void test2(){
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            File file1 = new File("E:\\IDEAProject\\JavaBasics\\src\\pers\\yangzhen\\io\\iostreamdocuments\\srcFile.txt");
            File file2 = new File("E:\\IDEAProject\\JavaBasics\\src\\pers\\yangzhen\\io\\iostreamdocuments\\destFile2.txt");

            FileInputStream fis = new FileInputStream(file1);
            FileOutputStream fos = new FileOutputStream(file2);

            isr = new InputStreamReader(fis,"UTF-8");
//            osw = new OutputStreamWriter(fos,"GBK");//编码解码不一致会导致乱码
            osw = new OutputStreamWriter(fos,"UTF-8");//编码解码不一致会导致乱码

            char[] cbuf = new char[20];
            int len;
            while ((len = isr.read(cbuf)) != -1) {
                osw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(isr != null){
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(osw != null){
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}

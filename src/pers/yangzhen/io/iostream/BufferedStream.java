package pers.yangzhen.io.iostream;

import org.junit.Test;

import java.io.*;
/**
 * 缓冲流
 * @author yangzhen
 * @create 2021-04-08 20:48
 */
public class BufferedStream {

    //缓冲流实现非文本（所以这里是字节流，缓冲字符流后面再提）的复制粘贴
    @Test
    public void BufferedStreamTest(){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            File srcFile = new File("E:/IDEAProject/JavaBasics/src/pers/yangzhen/io/iostreamdocuments/头像.jpg");
            File destFile = new File("E:/IDEAProject/JavaBasics/src/pers/yangzhen/io/iostreamdocuments/头像1.jpg");

            //造节点流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            //造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //复制的细节
            byte[] buffer = new byte[5];
            int len;
            while((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //资源关闭：先关闭外层的流，再关闭内层的流，同一层的流随意（类似关门）
            //在关闭外层流的同时，内层流也自动地进行关闭，内层流的关闭可以省略。
            if(bis != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(bos != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    //使用缓冲字符流实现文本文件的复制
    @Test
    public void testBufferedReaderWriter(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            //为了偷懒，常用匿名的方式来实例化
            br = new BufferedReader(new FileReader(new File("E:/IDEAProject/JavaBasics/src/pers/yangzhen/io/iostreamdocuments/srcFile1.txt")));
            bw = new BufferedWriter(new FileWriter(new File("E:/IDEAProject/JavaBasics/src/pers/yangzhen/io/iostreamdocuments/destFile1.txt")));

            //读写操作
            //方式一：使用char[]数组
//            char[] cbuf = new char[5];//5不是固定的长度，可任意修改的
//            int len;
//            while((len = br.read(cbuf)) != -1){
//                bw.write(cbuf,0,len);
//            }

            //方式二：使用String
            String data;
            while ((data = br.readLine()) != null){//未到文件尾部
                bw.write(data);//写一行数据
                bw.newLine();//每读完一行，换行
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }




}
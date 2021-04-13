package pers.yangzhen.io.iostream.exercise;

import org.junit.Test;

import java.io.*;

/**
 * 实现图片的加密与解密
 * @author yangzhen
 * @create 2021-04-09 10:17
 */
public class EncryptDecrypt {

    //加密
    @Test
    public void Encrypt(){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(new File("E:/IDEAProject/JavaBasics/src/pers/yangzhen/io/iostreamdocuments/头像.jpg")));
            bos = new BufferedOutputStream(new FileOutputStream(new File("E:/IDEAProject/JavaBasics/src/pers/yangzhen/io/iostreamdocuments/头像（加密）.jpg")));


            byte[] buffer = new byte[20];
            int len;
            while ((len = bis.read(buffer)) != -1){

                //加密方式：与5进行异或操作
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte)(buffer[i] ^ 5);
                }
                bos.write(buffer,0,len);
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

            if(bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    @Test
    public void Decrypt(){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(new File("E:/IDEAProject/JavaBasics/src/pers/yangzhen/io/iostreamdocuments/头像（加密）.jpg")));
            bos = new BufferedOutputStream(new FileOutputStream(new File("E:/IDEAProject/JavaBasics/src/pers/yangzhen/io/iostreamdocuments/头像（解密）.jpg")));


            byte[] buffer = new byte[20];
            int len;
            while ((len = bis.read(buffer)) != -1){

                //解密方式：加密文件与5异或一次。本质上：2次异或之后，值不变。
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte)(buffer[i] ^ 5);
                }
                bos.write(buffer,0,len);
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

            if(bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}

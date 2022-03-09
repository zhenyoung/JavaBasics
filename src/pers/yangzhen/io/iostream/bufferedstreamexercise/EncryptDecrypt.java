package pers.yangzhen.io.iostream.bufferedstreamexercise;

import org.junit.Test;

import java.io.*;

/**
 * 实现图片的加密与解密
 *
 * @author yangzhen
 * @create 2021-04-09 10:17
 */
public class EncryptDecrypt {
    
    @Test
    public void Encrypt() {
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            bufferedInputStream = new BufferedInputStream(
                    new FileInputStream("./src/pers/yangzhen/io/iostreamfiles/头像src.jpg"));
            bufferedOutputStream = new BufferedOutputStream(
                    new FileOutputStream("./src/pers/yangzhen/io/iostreamfiles/头像(加密).jpg"));
            byte[] buffer = new byte[20];
            int len;
            while ((len = bufferedInputStream.read(buffer)) != -1) {
                // 加密方式：与 5 进行异或操作
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte) (buffer[i] ^ 5);
                }
                // 加密后输出文件
                bufferedOutputStream.write(buffer, 0, len);
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
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    @Test
    public void Decrypt() {
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            bufferedInputStream = new BufferedInputStream(
                    new FileInputStream("./src/pers/yangzhen/io/iostreamfiles/头像(加密).jpg"));
            bufferedOutputStream = new BufferedOutputStream(
                    new FileOutputStream("./src/pers/yangzhen/io/iostreamfiles/头像(解密).jpg"));
            byte[] buffer = new byte[20];
            int len;
            while ((len = bufferedInputStream.read(buffer)) != -1) {
                // 解密方式：加密文件与 5 异或一次。本质上：2 次异或之后，值不变。
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte) (buffer[i] ^ 5);
                }
                bufferedOutputStream.write(buffer, 0, len);
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
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
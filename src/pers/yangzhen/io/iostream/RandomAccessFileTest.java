package pers.yangzhen.io.iostream;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * 随机存取文件流（了解即可）
 * @author yangzhen
 * @create 2021-04-10 9:33
 */
public class RandomAccessFileTest {

    @Test
    public void test1(){
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile(new File("E:/IDEAProject/JavaBasics/src/pers/yangzhen/io/iostreamdocuments/头像.jpg"),"r");//r，输入
            raf2 = new RandomAccessFile(new File("E:/IDEAProject/JavaBasics/src/pers/yangzhen/io/iostreamdocuments/头像2.jpg"),"rw");//rw，输入输出

            byte[] buffer = new byte[1024];
            int len;
            while ((len = raf1.read(buffer)) != -1){
                raf2.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(raf1 != null){
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(raf2 != null){
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

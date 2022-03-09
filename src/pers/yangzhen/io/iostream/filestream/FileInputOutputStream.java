package pers.yangzhen.io.iostream.filestream;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author yangzhen
 * @create 2021-04-08 19:54
 */
public class FileInputOutputStream {
    
    @Test
    public void test() {
        FileInputStream fileInputStream = null;
        FileOutputStream fileoutputStream = null;
        try {
            File srcFile = new File("./src/pers/yangzhen/io/iostreamfiles/头像src.jpg");
            File destFile = new File("./src/pers/yangzhen/io/iostreamfiles/头像dest.jpg");
            fileInputStream = new FileInputStream(srcFile);
            fileoutputStream = new FileOutputStream(destFile);
            byte[] buffer = new byte[5];
            int len;
            while ((len = fileInputStream.read(buffer)) != -1) {
                fileoutputStream.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileoutputStream != null) {
                try {
                    fileoutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
package pers.yangzhen.io.iostream.filestream;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 流的体系结构如下：
 * 四个抽象基类：InputStream OutputStream Reader Writer
 * 节点流：FileInputStream FileOutputStream FileReader FileWriter（也叫文件流）
 * 缓冲流（处理流的一种）：BufferInputStream BufferOutputStream BufferReader BufferWriter
 *
 * @author yangzhen
 * @create 2021-04-07 15:49
 */
public class FileReaderWriter {
    @Test
    public void test1() {
        FileReader fileReader = null;
        try {
            // 1. 提供文件读取的流，Hello1.txt 是文本文件，所以是 FileReader
            fileReader = new FileReader("./src/pers/yangzhen/io/iostreamfiles/Hello1.txt");
            // 2. 读入数据
            // read() 返回读入的一个字符(字符集的码点)。如果达到文件末尾，返回 -1
            int data = fileReader.read();
            // 没有到文件末尾
            while (data != -1) {
                System.out.print((char) data);
                // 不断读取下一个字符
                data = fileReader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                // 3. 关键字 finally 主要就是用来关闭流资源的，一定别忘了关闭流
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    // read() 的重载方法
    @Test
    public void test2() {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("./src/pers/yangzhen/io/iostreamfiles/Hello1.txt");
            char[] cbuf = new char[5];
            // int read(char[] cbuf) 每次读入 5 (5 取决于数组长度)个字符到 cbuf 数组中，
            int len;
            // 并且返回读入的字符个数
            while ((len = fileReader.read(cbuf)) != -1) {
                System.out.print(new String(cbuf,0,len));
                // 切忌 System.out.println(cbuf)，这样每次只会打印 cbuf 数组的全部字符，而非读取到的字符
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    // 写出数据到磁盘文件中
    @Test
    public void test3() {
        FileWriter fileWriter1 = null;
        FileWriter fileWriter2 = null;
        FileWriter fileWriter3 = null;
        try {
            File file = new File("./src/pers/yangzhen/io/iostreamfiles/Hello2.txt");
            // 若 File 文件不存在，则将自动创建该文件。若存在该文件，则默认覆盖文件内容
            fileWriter1 = new FileWriter(file);
            // 不添加--->覆盖
            fileWriter2 = new FileWriter(file, false);
            //　添加
            fileWriter3 = new FileWriter(file, true);
            fileWriter1.write("1.I have a dream!\n");
            fileWriter1.write("1.You need have a dream!\n");
            fileWriter2.write("2.I have a dream!\n");
            fileWriter2.write("2.You need have a dream!\n");
            fileWriter3.write("3.I have a dream!\n");
            fileWriter3.write("3.You need have a dream!\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter1 != null && fileWriter2 != null && fileWriter3 != null) {
                try {
                    fileWriter1.close();
                    fileWriter2.close();
                    fileWriter3.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    // 文本复制
    @Test
    public void test4() {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader("./src/pers/yangzhen/io/iostreamfiles/srcFile.txt");
            // 写时添加，而非覆盖
            fileWriter = new FileWriter("./src/pers/yangzhen/io/iostreamfiles/destFile.txt", true);
            char[] cbuf = new char[5];
            int len;
            while ((len = fileReader.read(cbuf)) != -1) {
                // 每次写出 5 个字符
                fileWriter.write(cbuf,0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

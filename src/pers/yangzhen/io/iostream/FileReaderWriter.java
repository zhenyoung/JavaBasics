package pers.yangzhen.io.iostream;

import org.junit.Test;

import java.io.*;

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
    public void testFileReader1() {
        FileReader fr = null;

        try {
            //实例化File类的对象，指明要操作的对象
            File file = new File("E:/IDEAProject/JavaBasics/src/pers/yangzhen/io/iostreamdocuments/Hello1.txt");//相对路径默认在当前Module下，如果实在main方法创建的对象，则相对路径是在当前工程下

            //2.提供具体的流
            fr = new FileReader(file);

            //3.数据的读入
            int data = fr.read();//返回读入的一个字符。如果达到文件末尾，返回-1
            while (data != -1) {//没有到文件末尾
                System.out.print((char) data);
                data = fr.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                //4.流的关闭操作!!!
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    //read()的重载方法
    @Test
    public void testFileReader2() {
        FileReader fr = null;
        try {
            //1.File类的实例化
            File file = new File("E:/IDEAProject/JavaBasics/src/pers/yangzhen/io/iostreamdocuments/Hello1.txt");

            //2.FileReader流的实例化
            fr = new FileReader(file);

            //3.读入的操作
            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1) {//int read(char[] cbuf) 每次读入5个字符到cbuf数组中，并且返回读入的字符个数
                //错误的写法1
//                for(int i = 0;i < cbuf.length;i++ ){
//                    System.out.print(cbuf[i]);
//                }
                //错误的写法2，结果与写法1相同
//                String str = new String(cbuf);
//                System.out.println(str);

                //正确的写法1
//                for(int i = 0; i < len; i++ ){
//                    System.out.print(cbuf[i]);
//                }
                //正确的写法2
                String str = new String(cbuf, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                //4.资源的关闭
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //从内存中写出数据到磁盘文件中
    @Test
    public void testFileWriter() {
        FileWriter fileWriter1 = null;
        FileWriter fileWriter2 = null;
        FileWriter fileWriter3 = null;//若文件不存在，则创建文件，若存在，则添加内容，而不是覆盖

        try {
            File file = new File("E:/IDEAProject/JavaBasics/src/pers/yangzhen/io/iostreamdocuments/Hello2.txt");

            fileWriter1 = new FileWriter(file);//若File文件不存在，则将自动创建该文件。若存在该文件，则覆盖
            fileWriter2 = new FileWriter(file, false);//同上
            fileWriter3 = new FileWriter(file, true);


            fileWriter1.write("1.I have a dream!\n");
            fileWriter1.write("1.You need have a dream!\n");
            fileWriter1.close();

            fileWriter2.write("2.I have a dream!\n");
            fileWriter2.write("2.You need have a dream!\n");
            fileWriter2.close();

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


    //复制操作
    @Test
    public void testFileReaderFileWriter() {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            //1.创建File类的对象，指明读入和写出的文件
            File srcFile = new File("E:/IDEAProject/JavaBasics/src/pers/yangzhen/io/iostreamdocuments/srcFile.txt");
            File destFile = new File("E:/IDEAProject/JavaBasics/src/pers/yangzhen/io/iostreamdocuments/destFile.txt");

            //2.创建输入流和输出流的对象
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile,true);//写的时候是添加内容，而不覆盖

            //3.数据的读入和写出操作
            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1) {//每次读入len个字符
                //每次写出len个字符
                fw.write(cbuf,0,len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fr != null){
                    //4.关闭fr流
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(fw!=null){
                    //4.关闭fw流
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}

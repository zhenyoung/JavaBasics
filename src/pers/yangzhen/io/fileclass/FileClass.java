package pers.yangzhen.io.fileclass;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * File实例化
 *
 * @author yangzhen
 * @create 2021-04-06 15:15
 */
public class FileClass {
    @Test
    public void test1() {
        //实例化的时候写加上后缀就是文件，不加上后缀就默认是目录
        //下面的文件路径只是在内存层面上存在的，不一定必须在硬盘中存在
        //构造器1
        File file1 = new File("Hello1.txt");//相对路径，位于当前module（我这里没有新建module，所以是在当前工程JavaBasics下），新建文件Hello1.txt
        File file2 = new File("E:/IDEAProject/JavaBasics/src/pers/yangzhen/io/fileclassdocuments/Hello2.txt");//新建文件Hello2.txt
        System.out.println(file1);
        System.out.println(file2);

        //构造器2
        File file3 = new File("E:/IDEAProject/JavaBasics/src/pers/yangzhen/io/", "Hello3");//新建目录Hello3
        System.out.println(file3);

        //构造器3
        File file4 = new File(file3, "Hello4.txt");//新建文件Hello4.txt
        System.out.println(file4);
    }

    //测试File类的常用方法
    //下面的文件路径只是在内存层面上存在的，不一定必须在硬盘中存在
    @Test
    public void test2() {
        //在E:/IDEAProject/JavaBasics/src/pers/yangzhen/io/fileclassdocuments创建以下两个File
        File file1 = new File("fileclassdocuments/Hello1.txt");
        File file2 = new File("E:/IDEAProject/JavaBasics/src/pers/yangzhen/io/fileclassdocuments/Hello2.txt");

        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(file1.lastModified());
        System.out.println("***********************");

        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(new Date(file2.lastModified()));//返回最后一次修改时的时间戳
        System.out.println("***********************");
    }

    @Test
    public void test3() {
        File file1 = new File("E:/IDEAProject/JavaBasics/src/pers/yangzhen/io");
        String[] list = file1.list();//获取指定目录下（该目录必须在磁盘上存在，不像前面2次测试可以不用在磁盘中新建）的所有文件或者目录的“名称”组成的数组
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println();
        File[] files = file1.listFiles();//获取指定目录下的所有文件或者目录的File数组
        for (File f : files) {
            System.out.println(f);
        }
    }

    //public boolean renameTo(File dest)把文件重命名为指定的文件路径下的文件
    //要想保证重命名成功，当前对象必须在硬盘中存在，而dest对象作为新的路径，必须不能存在，命名成功后才存在
    //理解：只有命名完成才能有该文件，类似”将文件或者目录剪切到另一个目录下，然后重命名“
    @Test
    public void test4() {
        File file1 = new File("E:/IDEAProject/JavaBasics/src/pers/yangzhen/io/fileclassdocuments/Hello1.txt");
        //为了测试这个方法，我这里手动在该路径下新建了一个Hello1.txt，但是并没有写入任何内容
        File file2 = new File("E:/IDEAProject/JavaBasics/src/pers/yangzhen/io/fileclassdocuments/Hello2.txt");

        System.out.println(file1.renameTo(file2));//file1路径--->file2路径
    }

    //File的判断方法
    @Test
    public void test5() {
        File file = new File("E:/IDEAProject/JavaBasics/src/pers/yangzhen/io/fileclassdocuments/Hello2.txt");

        System.out.println(file.exists());//是否在硬盘中存在
        //下面的方法都是基于文件或者目录在怕硬盘中已经存在的前提下判断的，若不存在则都会返回false，此时下面的判断就没有意义了
        //都不存在该文件，还有啥好判断的呢？
        System.out.println(file.isDirectory());//是否是一个目录
        System.out.println(file.isFile());
        System.out.println(file.canRead());//是否可读
        System.out.println(file.canWrite());//是否可写
        System.out.println(file.isHidden());//是否隐藏
    }


    //硬盘中创建文件
    @Test
    public void test6() throws IOException {
        File file1 = new File("hello.txt");//由于我这里没有创建Module，所以默认是在工程目录JavaBasic下创建hello.txt文件
        if (file1.createNewFile()) {
            System.out.println("创建文件createNewFile成功");
        }
    }

    //硬盘中创建目录
    @Test
    public void test7() {
        //文件目录的创建
        File file1 = new File("E:/IDEAProject/JavaBasics/src/pers/yangzhen/io/fileclassdocuments/mkdir");
        //由于mkdir的父目录fileclassdocuments是存在的，所以调用mkdir和mkdirs是一致的，没有区别
        if (file1.mkdir()) {
            System.out.println("有父目录下创建目录mkdir成功");
        }

        //如果目录的父目录不存在，mkdir就不会创建目录（创建失败）
        //而mkdirs就会创建其不不存在的所有父目录（创建成功）
        File file2 = new File("E:/IDEAProject/JavaBasics/src/pers/yangzhen/io/fileclassdocuments/mkdirs/dir");
        if (!file2.mkdir() && file2.mkdirs()) {
            System.out.println("无父目录下mkdir创建目录失败");
            System.out.println("无父目录下mkdirs创建目录成功");
        }

    }

}

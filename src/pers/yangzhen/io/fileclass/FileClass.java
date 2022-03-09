package pers.yangzhen.io.fileclass;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;

/**
 * File 实例化
 *
 * @author yangzhen
 * @create 2021-04-06 15:15
 */
public class FileClass {
    @Test
    public void test1() {
        // 实例化的时候写加上后缀就是文件，不加上后缀就默认是目录，
        // File 实例仅仅只是一个文件的映射，并不是一个实体，仅仅存在于内存层面
        // 在相对路径下新建文件 Hello1.txt
        // 相对路径默认位于当前 module ，我这里没有新建 Module ，所以是相对路径是在当前工程目录 JavaBasics 下
        File file1 = new File("Hello1.txt");
        // 在绝对路径下新建文件 Hello2.txt
        File file2 = new File("E:/IDEAProject/JavaBasics/src/pers/yangzhen/io/fileclassdocuments/Hello2.txt");
        System.out.println(file1);
        System.out.println(file2);
        // 在父目录下新建目录 Hello3
        File file3 = new File("E:/IDEAProject/JavaBasics/src/pers/yangzhen/io/fileclassdocuments", "Hello3");
        System.out.println(file3);
        // 在父目录下新建文件 Hello4.txt
        File file4 = new File(file3, "Hello4.txt");
        System.out.println(file4);
    }

    // File 类的常用方法
    @Test
    public void test2() {
        // 在 E:/IDEAProject/JavaBasics/src/pers/yangzhen/io/fileclassdocuments
        // 创建以下两个 File 实例
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
        // 返回最后一次修改时的时间戳
        System.out.println(new Date(file2.lastModified()));
        System.out.println("***********************");
    }

    @Test
    public void test3() {
        File file1 = new File("E:/IDEAProject/JavaBasics/src/pers/yangzhen");
        // 获取指定路径下(该目录必须在磁盘上存在，不像前面可以不用在磁盘中新建)
        // 的所有文件或者目录的"名称"组成的数组
        String[] list = file1.list();
        for (String s : Objects.requireNonNull(list)) {
            System.out.println(s);
        }
        System.out.println();
        // 获取指定路径下的所有文件的 File 数组
        File[] files = file1.listFiles();
        for (File f : Objects.requireNonNull(files)) {
            System.out.println(f);
        }
    }

    // public boolean renameTo(File dest) 把文件重命名为指定的文件路径下的文件
    // 要想保证重命名成功，当前 File 对象对应的文件必须在硬盘中存在，
    // 而 dest 对象作为新的路径，必须不能存在，只有在命名成功后才存在。
    // 我的理解是：只有命名完成才能有该文件，类似”将文件或者目录剪切到另一个目录下，然后重命名“
    @Test
    public void test4() {
        File file1 = new File("E:/IDEAProject/JavaBasics/src/pers/yangzhen/io/fileclassfiles/Hello1.txt");
        // 为了测试这个方法，我这里手动在该路径下新建了一个 Hello1.txt ，但是并没有写入任何内容
        File file2 = new File("E:/IDEAProject/JavaBasics/src/pers/yangzhen/io/fileclassfiles/Hello2.txt");
        // file1 路径 ---> file2 路径
        System.out.println(file1.renameTo(file2));
    }

    // 判断
    @Test
    public void test5() {
        File file = new File("E:/IDEAProject/JavaBasics/src/pers/yangzhen/io/fileclassfiles/Hello2.txt");
        // 是否在硬盘中存在
        System.out.println(file.exists());
        // 下面的方法都是基于文件已经在硬盘中存在的前提下判断的，
        // 若文件不在硬盘中，则都会返回 false，此时判断也就没有意义了，都不存在该文件，还有啥好判断的呢？对吧！
        // 是否是一个目录
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        // 是否可读
        System.out.println(file.canRead());
        // 是否可写
        System.out.println(file.canWrite());
        // 是否隐藏
        System.out.println(file.isHidden());
    }
    
    // 在硬盘中创建文件
    @Test
    public void test6() throws IOException {
        // 相对路径下创建文件
        File file1 = new File("./src/pers/yangzhen/io/fileclassfiles/createNewFile.txt");
        if (file1.createNewFile()) {
            System.out.println("创建文件 createNewFile.txt 成功");
        }
        File file2 = new File("./src/pers/yangzhen/io/fileclassfiles/mkdir");
        // 由于 mkdir 的父目录 fileclassfiles 是存在的，所以调用 mkdir 和 mkdirs 是一致的，没有区别
        if (file2.mkdir()) {
            System.out.println("有父目录下创建目录 mkdir 成功");
        }
        // 如果目录的父目录不存在，mkdir 方法创建文件失败
        // mkdirs 方法则会创建其不存在的所有父目录
        File file3 = new File("./src/pers/yangzhen/io/fileclassfiles/mkdirs/dir");
        if (!file3.mkdir()) {
            System.out.println("无父目录 mkdirs 下创建文件 dir 失败");
        }
        if(file3.mkdirs()){
            System.out.println("无父目录 mkdirs 下创建文件 dir 成功");
        }
    }
}
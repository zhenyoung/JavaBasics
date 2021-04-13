package pers.yangzhen.io.iostream;

import org.junit.Test;

import java.io.*;

/**
 * 了解即可，用得较少
 * 1.标准输入输出流
 * 2.打印流
 * 3.数据流
 *
 * @author yangzhen
 * @create 2021-04-09 15:19
 */
public class OtherStream {

    /*
     * 1.标准输入流、输出流
     * System.in：标准输入流，默认键盘输入，InputStream
     * System.out：标准输出流，默认控制台输出，PrintStream
     *
     * 重定向：通过System类的setIn、setOut方法对默认设备进行改变
     * public static void setIn(InputStream in)
     * public static void setOut(PrintStream out)
     * */
    public static void main(String[] args) {
        //        下面一以一个例子说明
        /*
         * 从键盘输入字符串，要求将读取到的整行字符串转换成大写输出。然后继续进行输入操作
         * 直到输入“e”或者”exit“时，退出程序
         * 尽管可以使用Scanner，但是这里为了说明问题，用System.in流来解决问题
         * */

        BufferedReader br = null;
        try {
            //转换流，先打开控制台，允许用户输入，然后将PrintStream字节流转换成字符流
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);//转换字符流传入缓冲字符流
            while (true) {
                System.out.println("输入信息（退出输入e或exit）：");
                String data = br.readLine();
                if ("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)) {
                    System.out.println("程序结束");
                    break;
                }
                String upperCase = data.toUpperCase();
                System.out.println(upperCase);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    //将内存中的字符串、基本数据类型写入到文件中
    @Test
    public void test1(){
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream("E:/IDEAProject/JavaBasics/src/pers/yangzhen/io/iostreamdocuments/srcFile3.txt"));
            dos.writeUTF("张三");//写入字符串
            dos.flush();
            dos.writeInt(20);//写入整型
            dos.flush();
            dos.writeBoolean(true);//写入布尔型
            dos.flush();

//            dos.writeByte(12);//写入字节型
//            dos.writeChar('李');//写入字符型
//            dos.writeFloat(22.0F);//写入浮点型
//            dos.writeDouble(22.0);//写入浮点型
//            dos.writeLong(32L);//写入长整型
//            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(dos != null){
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    //将文件中数据读出来
    @Test
    public void test2(){
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(new FileInputStream("E:/IDEAProject/JavaBasics/src/pers/yangzhen/io/iostreamdocuments/srcFile3.txt"));

            //有着严格的顺序，必须按照写入的顺序读
            //那么问题来了，数据一多，这谁记得住写入的顺序呀！！！
            //要是打开文件去看，那写代码去读就毫无意义了，直接看就行了
            //就是因为这类妖孽的特点，所以了解一下就行了
            String name = dis.readUTF();
            int age = dis.readInt();
            boolean isMale = dis.readBoolean();

            System.out.println("name = " + name);
            System.out.println("age = " + age);
            System.out.println("isMale = " + isMale);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(dis != null){
                try {
                    dis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}


class MyInput {
    //从键盘输入数据类类型值，通过流来将其输出为相应的数据类型

    // 首先从键盘读入一个String
    public static String readString() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 初始化字符串
        String string = "";

        // 从键盘获取字符串
        try {
            string = br.readLine();

        } catch (IOException ex) {
            System.out.println(ex);
        }

        // Return the string obtained from the keyboard
        return string;
    }
    // 然后通过Xxx类的parseXxx(String str)方法将其转换为指定的数据类型，如果值与其类型不匹配，则报异常

    // 从键盘读入一个int
    public static int readInt() {
        return Integer.parseInt(readString());
    }

    // 从键盘读入一个double
    public static double readDouble() {
        return Double.parseDouble(readString());
    }

    // 从键盘读入一个byte
    public static double readByte() {
        return Byte.parseByte(readString());
    }

    // 从键盘读入一个short
    public static double readShort() {
        return Short.parseShort(readString());
    }

    // 从键盘读入一个long
    public static double readLong() {
        return Long.parseLong(readString());
    }

    // 从键盘读入一个float
    public static double readFloat() {
        return Float.parseFloat(readString());
    }
}

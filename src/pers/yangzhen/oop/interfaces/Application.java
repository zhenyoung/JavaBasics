package pers.yangzhen.oop.interfaces;

/**
 * 接口的多态性
 */
public class Application {
    public static void main(String[] args) {
        Computer com = new Computer();
        Udisk udisk = new Udisk();
        com.transferData(udisk);
        System.out.println();
        Printer printer = new Printer();
        com.transferData(printer);
    }
}

class Computer{
    public void transferData(USB usb){
        usb.start();
        System.out.println("具体传输数据的细节");
        usb.stop();
    }
}

interface USB{
    //常量：定义尺寸、船速速度等
    //方法：定义工作方式等
    void start();
    void stop();
}
class Udisk implements USB{

    @Override
    public void start() {
        System.out.println("U盘开启工作");
    }

    @Override
    public void stop() {
        System.out.println("U盘结束工作");
    }
}
class Printer implements USB{

    @Override
    public void start() {
        System.out.println("打印机开启工作");
    }

    @Override
    public void stop() {
        System.out.println("打印机结束工作");
    }
}

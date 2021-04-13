package pers.yangzhen.oop.interfaces;

//JDK7及以下
public class Interface1 {
    public static void main(String[] args){
        System.out.println(Flyable.MAX_SPEED);
        System.out.println(Flyable.MIN_SPEED);
        //Flyable.MIN_SPEED = 2;//报错，常量不可赋值
        Plane plane = new Plane();
        plane.fly();
    }

}
interface Flyable{
    //JDK7及以前，只能定义全局常量和抽象方法
    //全局常量：public static final的方法，但是书写时可以省略不写
    //抽象方法：public abstract的方法，书写时也可省略不写

    //JDK8：除了定义全局常量和抽象方法之外，还可以定义静态方法、默认方法

    public static final int MAX_SPEED = 7000;//没有省略
    int MIN_SPEED = 1;//省略了public static final
    public abstract void fly();
    void stop();//省略了public abstract
}

interface Attackable{
    void attack();
}

class Plane implements Flyable{
    public void fly(){
        System.out.println("通过引擎起飞");
    }
    public void stop(){
        System.out.println("驾驶员减速停止");
    }
}
abstract class Kite implements Flyable{
    //如果没有全部覆盖接口中的方法，那么类必须声明成abstract
    public void fly(){
    }
}

class Bullet extends Object implements Flyable,Attackable,CC{

    @Override
    public void fly() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void attack() {

    }
    //Bullet类实现CC接口，而CC接口继承于AA接口和BB接口，因此Bullet类必须重写AA和BB中的抽象方法
    @Override
    public void A() {

    }

    @Override
    public void B() {

    }
}
//********************************************************
interface AA{
    void A();
}
interface BB{
    void B();
}
interface CC extends AA,BB{

}
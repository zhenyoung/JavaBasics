package pers.yangzhen.reflection.Proxy;

/**
 * 静态代理的特点：代理类和背袋类在编译期间都被写死了
 * @author yangzhen
 * @create 2021-04-14 12:23
 */
interface ClothFactory{
    void produceCloth();

}
//代理类
class proxyClothFactory implements ClothFactory{
    private  ClothFactory factory;//用被代理的对象进行实例化

    public proxyClothFactory(ClothFactory factory){
        this.factory = factory;
    }

    @Override
    public void produceCloth(){
        System.out.println("代理工厂做一些准备工作");
        factory.produceCloth();

        System.out.println("代理工厂做一些后续的收尾工作");
    }
}

//被代理类
class AntaClothFactory implements ClothFactory{
    @Override
    public void produceCloth() {
        System.out.println("Anta工厂生产一批运动服");
    }
}

public class StaticProxy {
    public static void main(String[] args) {
        //创建被代理类的对象
        AntaClothFactory anta = new AntaClothFactory();
        //创建代理类的对象
        proxyClothFactory proxyClothFactory = new proxyClothFactory(anta);
        proxyClothFactory.produceCloth();

    }
}

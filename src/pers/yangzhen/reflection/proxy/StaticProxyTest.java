package pers.yangzhen.reflection.proxy;

/**
 * 静态代理的特点：代理类和被代理类在编译期间都被写死，但是这种模式写下的代码十分难以维护，因此几乎都是用动态代理
 * @author yangzhen
 * @create 2021-04-14 12:23
 */

@FunctionalInterface
interface ClothFactory{
    void produceCloth();
}
// 代理类
class ProxyClothFactory implements ClothFactory{
    // factory 接收传入的被代理类对象
    private final ClothFactory factory;
    // 通过代理类的构造器传入被代理类对象
    public ProxyClothFactory(ClothFactory factory){
        this.factory = factory;
    }
    @Override
    public void produceCloth(){
        System.out.println("代理工厂做一些准备工作");
        factory.produceCloth();
        System.out.println("代理工厂做一些后续的收尾工作");
    }
}

// 被代理类
class AntaClothFactory implements ClothFactory{
    @Override
    public void produceCloth() {
        System.out.println("Anta 工厂生产一批运动服");
    }
}

public class StaticProxyTest {
    public static void main(String[] args) {
        // 创建代理类的对象
        ClothFactory proxyClothFactory = new ProxyClothFactory(new AntaClothFactory());
        proxyClothFactory.produceCloth();

    }
}

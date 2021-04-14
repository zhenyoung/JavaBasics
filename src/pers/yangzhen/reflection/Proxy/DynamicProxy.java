package pers.yangzhen.reflection.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理举例
 * @author yangzhen
 * @create 2021-04-14 12:38
 */

interface Human{
    String getBelief();
    void eat(String food);

}

//被代理类
class SuperMan implements Human{
    @Override
    public String getBelief() {
        return "I believe I can fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("吃饭(" + food + ")不积极，思想有问题");
    }
}

//要想实现动态代理，需要解决的问题？
//问题一：如何根据加载到内存中的被代理类，动态地创建一个代理类及其对象
//问题二：当通过代理类地对象调用方法时，如何动态的去调用代理类中同名方法


class ProxyFactory{
    
    //调用此方法，返回一个代理类的对象。解决问题一
    public static Object getProxyInstance(Object obj){//obj：被代理类的对象
        MyInvocationHandler handler = new MyInvocationHandler();

        handler.bind(obj);

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);
    }
}

class MyInvocationHandler implements InvocationHandler{

    private Object obj;//赋值时需要使用被代理类的对象进行赋值

    public void bind(Object obj){
        this.obj = obj;
    }
    //当通过代理类的对象调用方法a时，就会自动调用如下方法：invoke
    //将被代理类要执行的方法a的功能就声明在invoke()中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //method即为代理类对象调用的方法，此方法也就作为了被代理类对象要调用的方法
        //obj：被代理类的对象
        Object returnValue = method.invoke(obj, args);
        //上述方法的返回值就作为当前类中invoke()的返回值
        return returnValue;
    }
}

public class DynamicProxy {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);

        //当通过代理类对象调用方法时，会自动调用被代理类中的同名方法
        String belief = proxyInstance.getBelief();
        System.out.println(belief);
        proxyInstance.eat("四川麻辣烫");
        System.out.println("******************************");

        AntaClothFactory antaClothFactory = new AntaClothFactory();
        ClothFactory proxyClothFactory = (ClothFactory) ProxyFactory.getProxyInstance(antaClothFactory);
        proxyClothFactory.produceCloth();

    }
}

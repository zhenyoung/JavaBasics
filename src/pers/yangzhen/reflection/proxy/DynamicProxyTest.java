package pers.yangzhen.reflection.proxy;

import java.lang.reflect.Proxy;

/**
 * 动态代理举例
 *
 * @author yangzhen
 * @create 2021-04-14 12:38
 */
interface Human {
    String getBelief();
    
    String eat(String food);
}

// 被代理类
class SuperHero implements Human {
    @Override
    public String getBelief() {
        return "I believe I can fly";
    }
    
    @Override
    public String eat(String food) {
        return "吃饭(" + food + ")不积极，思想有问题";
    }
}

public class DynamicProxyTest {
    public static void main(String[] args) {
        // 被代理类对象
        SuperHero superHero = new SuperHero();
        // newProxyInstance 方法返回类型为 Object , 因此这里需要强转
        Human batMan = (Human) Proxy.newProxyInstance(
                superHero.getClass().getClassLoader(),
                superHero.getClass().getInterfaces(),
                (proxy, method, arguments) -> {
                    // 需修改的方法
                    if ("eat".equals(method.getName())) {
                        // 修改的逻辑操作
                        System.out.print("准备吃饭， 已经上菜。");
                        // method 通过反射调用被代理类对象 superHero 中 method 实例对应的方法
                        // 这里有一点需要注意：这里的 Method 实例的 invoke 方法是通过调用 eat 方法执行的(反射的知识)，
                        // 而 eat 方法返回的是 String ，但 invoke 的返回是 Object ，因此这里体现了多态，
                        // 该 Object 对象同时也是 String 的一个实例
                        // 所以这里才能与 String 类型的字符串相加
                        return method.invoke(superHero, arguments) + "。";
                    } else {// 无需修改的方法
                        // 反射调用被代理类的方法
                        return method.invoke(superHero, arguments);
                    }
                });
        System.out.println(batMan.eat("四川麻辣烫"));
        System.out.println(batMan.getBelief());
        
    }
}


// 执行 batMan.eat("四川麻辣烫") 时生成了以下代理类：
//class ProxySuperHero implements Human{
//    private final InvocationHandler h;
//    public ProxySuperHero(InvocationHandler h){
//        this.h = h;
//    }
//    // food = "四川麻辣烫"
//    @Override
//    public String eat(String food) {
//        // 获取调用的方法
//        Method method = Human.class.getMethod("eat",String.class);
//        // 调用 invoke 方法
//        // this(代理对象)、 method(被调方法的 Method 实例)、 Object[](形参列表)
//        // 将这三参数传入 invoke 方法，然后接收 invoke 方法返回的返回值，并作为 eat 方法的返回值返回给调用者
//        return h.invoke(this,method,new Object[]{food});
//    }
//}

// batMan.getBelief() 同理
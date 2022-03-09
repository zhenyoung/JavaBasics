package pers.yangzhen.oop.polymorphism;

import org.junit.Test;

interface MobilePhone {
    int size = 100;
    
    void power();
    
    void chargeSpeed();
}

/**
 * review polymorphism in interface
 *
 * @author yangzhen
 * @create 2021-06-07 14:48
 */
public class PolymorphismTest {
    public static void main(String[] args) {
        MobilePhone xiaoMi = new XiaoMi();
        MobilePhone huaWei = new HuaWei();
        xiaoMi.chargeSpeed();
        xiaoMi.power();
        huaWei.chargeSpeed();
        huaWei.power();
        
        //Anonymous implementation class is assigned to interface inference
        //And it can only be assigned to interface inference, otherwise it can't build successfully
        MobilePhone obj1 = new MobilePhone() {
            @Override
            public void power() {
                System.out.println("Anonymous implementation 5000mAh");
            }
            
            @Override
            public void chargeSpeed() {
                System.out.println("Anonymous implementation 50W");
            }
        };
        obj1.chargeSpeed();
        obj1.power();
        
        MobilePhone obj2 = new AbstractClass() {
            @Override
            public void power() {
                System.out.println("override the rest abstract method power defined in interface");
            }
        };
        System.out.println("this is a anonymous subclass which extends abstract class");
        obj2.power();
        obj2.chargeSpeed();
        
        //get class of above objects obj1&obj2
        System.out.println(obj1.getClass());//result: class ReviewInJava$1
        System.out.println(obj2.getClass());//result: class ReviewInJava$2
        
        //get class of anonymous implementation class which instantiated in the way of anonymous object
        System.out.println(new MobilePhone() {
            @Override
            public void power() {
            
            }
            
            @Override
            public void chargeSpeed() {
            
            }
        }.getClass());//result: class ReviewInJava$3
        
        //we can conclude from above situations:
        //it's meaningless to discuss type of anonymous class or its instance since it's anonymous
        //so, although it's meaningless, it would print current class where it's located by default
        
    }
    
    // test plus in polymorphism
    @Test
    public void test() {
        System.out.println(test.testPlusInPolymorphism() + "test");
        // the result is "123test", reason:
        // the object "123" is the instance of class String,
        // so it can plus another String instance
    }
    
}

class test {
    public static Object testPlusInPolymorphism() {
        return "123";
    }
}

class XiaoMi implements MobilePhone {
    @Override
    public void chargeSpeed() {
        System.out.println("XiaoMi:" + 100);
    }
    
    @Override
    public void power() {
        System.out.println("XiaoMi:" + 3500);
    }
}

class HuaWei implements MobilePhone {
    @Override
    public void chargeSpeed() {
        System.out.println("HuaWei:" + 200);
    }
    
    @Override
    public void power() {
        System.out.println("Huawei" + 4500);
    }
}

abstract class AbstractClass implements MobilePhone {
    @Override
    public void chargeSpeed() {
        System.out.println("test abstract class which implements interface and just override method chargeSpeed");
    }
}
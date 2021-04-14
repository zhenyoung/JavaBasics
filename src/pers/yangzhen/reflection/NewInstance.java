package pers.yangzhen.reflection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.util.Random;

/**
 * 通过反射创建对应的运行时类的对象
 * @author yangzhen
 * @create 2021-04-12 21:55
 */
public class NewInstance {

    @Test
    public void test1() throws InstantiationException, IllegalAccessException {
        Class<Person> personClass = Person.class;

        //newInstance()创建对应的运行时类的对象（方法内部还是使用了运行时类的空参的构造器创建对象）
        //要想此方法正常地创建运行时类的对象，要求：
        //运行时类必须提供空参的构造器，且权限一般设置为public

        //这里也顺带着提一下JavaBean中为什么会要求提供一个public的空参构造器：
        //1.便于通过反射，创建运行时类的对象
        //2.便于子类继承此运行时类时，默认调用super()时，保证父类有此构造器

        Person person = personClass.newInstance();
        System.out.println(person);

    }

    @Test
    public void test2() throws Exception{
        //1.获取Class实例
        Class<Person> personClass = Person.class;
        //2.通过Class对象的getDeclaredConstructor(Class ...parameterTypes)调用指定参数结构的构造器
        //生成Constructor的实例
        Constructor<Person> con = personClass.getConstructor(String.class,int.class);
        //3.通过Constructor的实例con去创建对象，并初始化对象属性
        Person p = con.newInstance("Tom",12);
        System.out.println(p);

    }


    //体会反射的动态性
    @Test
    public void test3(){
        for (int i = 0; i < 6; i++) {
            int num = new Random().nextInt(3);//产生0，1，2之中的随机数
            String classPath = "";
            //编译时，还不知道classPath的值，所以创建的对象也只有在运行时才能确定，恰恰体现了反射的动态特性
            switch (num){
                case 0:
                    classPath = "java.util.Date";
                    break;
                case 1:
                    classPath = "java.lang.Object";
                    break;
                case 2:
                    classPath = "pers.yangzhen.reflection.NewInstance";//这是我自定义的主类
                    break;
                default:
                    break;
            }

            try {
                Object obj = getInstance(classPath);
                System.out.println(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    //创建一个指定类的对象
    //classPath：指定类的全类名
    public Object getInstance (String classPath) throws Exception{
        Class<?> aClass = Class.forName(classPath);
        return aClass.newInstance();//内部调用classPath的空参构造器去创建对象
    }

    @Test
    public void test4(){

    }

}

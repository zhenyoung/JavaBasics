package pers.yangzhen.reflection.getallmembersfromclass;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 获取其他结构
 * @author yangzhen
 * @create 2021-04-13 16:10
 */
public class GetOthers {

    //获取构造器
    @Test
    public void test1(){
        Class<Person> personClass = Person.class;

        //getConstructor()获取当前运行时类中声明为public的构造器
        Constructor[] constructors = personClass.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        System.out.println();
        //getConstructors()获取当前运行时类的所有构造器
        Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
    }


    @Test
    public void test2(){
        //获取运行时类的父类
        Class<Person> personClass = Person.class;
        Class<? super Person> superclass = personClass.getSuperclass();
        System.out.println(superclass.getName());

        //获取运行时类中带泛型的父类
        Type genericSuperclass = personClass.getGenericSuperclass();
        System.out.println(genericSuperclass);

        //获取运行时类的父类（带泛型）的泛型
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();//获取泛型类型
        System.out.println(actualTypeArguments[0].getTypeName());
    }

    //获取运行时类的接口
    @Test
    public void test3(){
        Class<Person> personClass = Person.class;
        Class<?>[] interfaces = personClass.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface);
        }
        System.out.println();

        //获取运行时类父类实现的接口
        Class<?>[] interfaces1 = personClass.getSuperclass().getInterfaces();
        for (Class<?> anInterface1 : interfaces1) {
            System.out.println(anInterface1);
        }
    }

    //获取运行时类所在的包
    @Test
    public void test4(){
        Class<Person> personClass = Person.class;
        Package aPackage = personClass.getPackage();
        System.out.println(aPackage);
    }

    //获取运行时类声明的注解
    @Test
    public void test5(){
        Class<Person> personClass = Person.class;

        Annotation[] annotations = personClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }

}
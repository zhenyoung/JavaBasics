package pers.yangzhen.reflection.getallmembersfromclass;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 获取运行时类的属性
 * @author yangzhen
 * @create 2021-04-13 14:43
 */
public class GetFiled {

    //获取属性
    @Test
    public void test1(){
        Class<Person> personClass = Person.class;

        //getFields()只能获取当前运行时类及其父类中所有声明为public的属性
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("*****************");
        //getDeclaredFields()可以获取当前运行时类所有的属性（但是不包含父类中的属性）
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
    }

    //获取权限修饰符 数据类型 变量名
    @Test
    public void test2(){
        Class<Person> personClass = Person.class;
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field f : declaredFields) {
            //1.权限修饰符
            int modifier = f.getModifiers();
            System.out.print(Modifier.toString(modifier) + "\t");

            //2.数据类型
            Class<?> type = f.getType();
            System.out.print(type.getName() + "\t");

            //3.变量名
            String fName = f.getName();
            System.out.println(fName);

        }

    }

}

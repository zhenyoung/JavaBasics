package pers.yangzhen.reflection.getdesignatedmembersfromclass;

import org.junit.Test;
import pers.yangzhen.reflection.getallmembersfromclass.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 调用运行时类的指定结构
 * @author yangzhen
 * @create 2021-04-13 21:24
 */
public class ReflectionTest {

    //调用指定属性
    @Test
    public void testField() throws Exception {
        Class<Person> personClass = Person.class;
        //创建运行时类的对象
        Person person = personClass.newInstance();

        //获取指定的属性（声明为public的）
        Field id = personClass.getField("id");
        //由于一般很少将属性设置为public的，所以很少用这种方式，更常用getDeclaredField
        Field name = personClass.getDeclaredField("name");
        //但是这种获取方式必须先将其设置成可访问的，即：
        name.setAccessible(true);

        //设置当前属性的值
        //set(Object obj, Object value)为obj对象设置属性值value
        id.set(person,1001);
        name.set(person,"Tom");

        //获取当前对象的属性值
        int pId = (int)id.get(person);
        System.out.println(pId);
        System.out.println(name.get(person));

    }

    //如何操作运行时类中指定的方法：
    @Test
    public void test2() throws Exception {
        Class<Person> personClass = Person.class;
        Person p = personClass.newInstance();

        //获取指定的某个方法
        //getDeclaredMethod(String name, Class<?>... parameterTypes)获取指定形参列表的名称为name的方法
        Method show = personClass.getDeclaredMethod("show", String.class);
        show.setAccessible(true);//保证当前方法是可访问的

        //invoke()参数1：方法的调用者，参数2：给方法形参赋值的实参
        String nation = (String) show.invoke(p,"CHN");//p.show("CHN");
        //注意：invoke()的返回值即为调用的方法show的返回值，所以上面进行了强转（因为返回为Object）
        System.out.println(nation);
        //关于静态方法的调用
        Method showDescription = personClass.getDeclaredMethod("showDescription");
        showDescription.setAccessible(true);
        Object returnValue = showDescription.invoke(personClass);
//        Object returnValue = showDescription.invoke(null);//写null也是一样的
        System.out.println(returnValue);
        //如果调用的运行时类方法没有返回值（void），则invoke()返回null
    }


    //获取指定的构造器，通过构造器来实例化
    @Test
    public void test3() throws Exception{
        Class<Person> personClass = Person.class;

        //1.获取指定的构造器
        //getConstructor
        Constructor<Person> constructor = personClass.getDeclaredConstructor(String.class);

        //2.保证此构造器可访问
        constructor.setAccessible(true);

        //3.调用此构造器实例化
        Person person = constructor.newInstance("Tom");
        System.out.println(person);

    }

}

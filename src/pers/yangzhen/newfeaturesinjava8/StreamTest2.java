package pers.yangzhen.newfeaturesinjava8;

import org.junit.Test;
import pers.yangzhen.newfeaturesinjava8.data.Employee;
import pers.yangzhen.newfeaturesinjava8.data.EmployeeData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Stream的中间操作
 *
 * @author yangzhen
 * @create 2021-04-17 10:46
 */
public class StreamTest2 {

    //1.筛选与切片
    @Test
    public void test1() {
        List<Employee> list = EmployeeData.getEmployees();
        //filter(Predicate p)接收Lambda，从流中排除某些元素
        Stream<Employee> stream = list.stream();

        //查询员工表中薪资大于7000的员工信息
        stream.filter(e -> e.getSalary() > 7000).forEach(System.out::println);

        System.out.println();
        //limit(n)截断流，使其元素不超过给定数量
        list.stream().limit(3).forEach(System.out::println);//只有前三条数据

        //skip(n)跳过元素，返回一个扔掉了前n个元素的流，若流中元素不足n个n，则返回一个空流
        System.out.println();
        list.stream().skip(3).forEach(System.out::println);//跳过前三条数据

        System.out.println();
        //distinct()筛选，通过流所生成元素的hashCode()和equals()去除重复元素
        list.add(new Employee(1010, "刘强东", 40, 8000));
        list.add(new Employee(1010, "刘强东", 40, 8000));
        list.add(new Employee(1010, "刘强东", 40, 8000));
        list.add(new Employee(1010, "刘强东", 40, 8000));
        list.stream().distinct().forEach(System.out::println);

    }

    //2.映射
    @Test
    public void test2() {
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);

        //练习：获取姓名长度大于3的员工姓名
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<String> namesStream = employees.stream().map(Employee::getName);
        namesStream.filter(name -> name.length() > 3).forEach(System.out::println);
        System.out.println();

    }

    //flatMap的说明
    @Test
    public void test3() {
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");

        //flatMap(Function f)前
        Stream<Stream<Character>> streamStream = list.stream().map(StreamTest2::fromStringToStream);
        streamStream.forEach(s -> {
            s.forEach(System.out::println);
        });
        System.out.println();
        //flatMap(Function f)后
        Stream<Character> characterStream = list.stream().flatMap(StreamTest2::fromStringToStream);
        characterStream.forEach(System.out::println);
    }

    //将字符串中的多个字符构成的集合转换为对应的Stream实力
    public static Stream<Character> fromStringToStream(String str) {
        ArrayList<Character> list = new ArrayList<>();
        for (Character c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    @Test
    public void test4() {
        //自然排序
        List<Integer> list = Arrays.asList(12, 43, 52, 123, 5, 1, -91, 0);
        list.stream().sorted().forEach(System.out::println);
        System.out.println();
        //抛出异常，因为自定义的类没有实现Comparable接口
//        List<Employee> employees = EmployeeData.getEmployees();
//        employees.stream().sorted().forEach(System.out::println);

        //sorted(Comparator com)定制排序
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()))
                .forEach(System.out::println);
    }

}

package pers.yangzhen.newfeaturesinjava8;

import org.junit.Test;
import pers.yangzhen.newfeaturesinjava8.data.Employee;
import pers.yangzhen.newfeaturesinjava8.data.EmployeeData;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream的实例化
 *
 * @author yangzhen
 * @create 2021-04-17 10:23
 */
public class StreamTest1 {
    //创建Stream方式一：通过集合
    @Test
    public void test1() {
        List<Employee> employees = EmployeeData.getEmployees();

        //default Stream<E> stream()：返回一个顺序流
        Stream<Employee> stream = employees.stream();

        //default Stream<E> parallelStream()：返回一个并行流
        Stream<Employee> parallelStream = employees.parallelStream();
    }

    //创建Stream方式二：通过数组
    @Test
    public void test2() {
        IntStream stream = Arrays.stream(new int[]{1, 2, 3, 4, 5, 6});
        Employee e1 = new Employee(1001, "Tom");
        Employee e2 = new Employee(1002, "Jerry");
        Employee[] arr1 = new Employee[]{e1, e2};
        Stream<Employee> stream1 = Arrays.stream(arr1);

    }

    //创建Stream方式三：通过Stream的of()
    @Test
    public void test3() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);
    }

}

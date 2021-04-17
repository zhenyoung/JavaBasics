package pers.yangzhen.newfeaturesinjava8;

import org.junit.Test;
import pers.yangzhen.newfeaturesinjava8.data.Employee;
import pers.yangzhen.newfeaturesinjava8.data.EmployeeData;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 测试Stream的终止操作
 *
 * @author yangzhen
 * @create 2021-04-17 14:34
 */
public class StreamTest3 {

    //1.匹配与查找
    @Test
    public void test1() {
        List<Employee> employees = EmployeeData.getEmployees();

        boolean allMatch = employees.stream().allMatch(e -> e.getAge() > 18);//allMatch()是否都大于18岁
        System.out.println(allMatch);

        boolean anyMatch = employees.stream().anyMatch(e -> e.getSalary() > 10000);//anyMatch()是否有大于10000工资的
        System.out.println(anyMatch);

        boolean nonMatch = employees.stream().noneMatch(e -> e.getName().startsWith("雷"));//noneMatch()是否没有姓雷的员工
        System.out.println(nonMatch);

        Optional<Employee> employee = employees.stream().findFirst();//findFirst()返回第一个元素
        System.out.println(employee);

        Optional<Employee> employee1 = employees.parallelStream().findAny();
        //findAny()返回任当前六中的任意一个元素，注意：不是随机的元素，是任意的元素
        System.out.println(employee1);

    }

    @Test
    public void test2() {
        List<Employee> employees = EmployeeData.getEmployees();

        //count()返回流中元素的总个数
        long count = employees.stream().filter(e -> e.getSalary() > 5000).count();
        System.out.println(count);

        //max()返回流中的最小值
        //先将员工映射到工资，得到的是关于Salary的Stream流
        Stream<Double> salaryStream = employees.stream().map(e -> e.getSalary());
        Optional<Double> maxSalary = salaryStream.max(Double::compare);
        System.out.println(maxSalary);

        //min()返回最小值
        Optional<Employee> employee = employees.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(employee);

        System.out.println("***********************");
        //forEach()内部迭代，集合的iterator属于外部迭代
        employees.stream().forEach(System.out::println);
        System.out.println("***********************");
        employees.forEach(System.out::println);//集合的遍历操作，与内部迭代是不一样的

    }

    //2.归约
    @Test
    public void test3() {
        //reduce(T identity,BinaryOperator)可以将流中的元素反复结合起来，得到一个值，返回 T
        //练习1：计算1~10的自然数的和
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = list.stream().reduce(0, Integer::sum);
        System.out.println(sum);

        //reduce(BinaryOperator)可以将流中的元素反复结合起来，得到一个值，返回Optional<T>
        //练习2：计算公司所有员工工资的总和
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Double> salaryStream = employees.stream().map(Employee::getSalary);

//        Optional<Double> sumMoney = salaryStream.reduce(Double::sum);
        Optional<Double> sumMoney = salaryStream.reduce((d1, d2) -> d1 + d2);//与上面相同

        System.out.println(sumMoney);

    }

    //3.收集
    @Test
    public void test4() {
        List<Employee> employees = EmployeeData.getEmployees();
        //collect(Collector c)将流转换为其他形式，接受一个Collector接口的实现，
        //练习：查找工资大于6000的员工，结果返回为一个List或者Set
        List<Employee> employeeList = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());
        employeeList.forEach(System.out::println);
        System.out.println("************************************");
        Set<Employee> employeeSet = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toSet());
        employeeSet.forEach(System.out::println);
        System.out.println("************************************");

    }


}

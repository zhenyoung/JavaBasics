package pers.yangzhen.oop.abstraction;

/*
 * 编写工资系统，实现不同类型员工（多态）的按月发放工资，
 * 如果当月出现某个Employee对象的生日，则将该雇员的工资增加100元
 *
 * 说明：
 * 1.定义一个Employee类，该类包含：
 * ① private属性name、number、birthday，其中birthday为MyDate类的对象
 * ② abstract方法earnings()；toString()方法输出对象的name、number、birthday
 *
 * 2.MyDate类包含：
 * ① private属性year、month、day
 * ② toDateString()方法返回日期对应的字符串：xxx年xx月xx日
 *
 * 3.定义SalariedEmployee类继承Employee类，实现按月计算工资的员工处理，该类包括：
 * ① private属性monthlySalary
 * ② 实现父类的抽象方法earnings()，该方法返回monthlySalary值；toString()方法返回员工类型信息及员工的name、number、birthday
 *
 * 4.参照SalariedEmployee类定义HourEmployee类，实现按小时计算工资的员工处理，该类包括：
 * ① private属性wage和hour
 * ② 实现父类的抽象方法earnings()，该方法返回wage*hour值；toString()方法返回员工类型信息及员工的name、number、birthday
 *
 * 5.定义Exercise类，创建Employee变量数组并初始化，该数组存放各类雇员对象的引用
 * ① 循环遍历数组，输出各个对象的类型，name，number，birthday
 * ② 当键盘输入本月月份时，如果本月是某个Employee对象的生日，还要输出增加工资信息
 *
 * */

import java.util.Scanner;

public class Exercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入月份：");
        int month = scanner.nextInt();
        System.out.println();

        Employee[] employees = new Employee[2];
        employees[0] = new SalariedEmployee("张三", 1002, new MyDate(2000, 1, 1), 20000);
        employees[1] = new HourEmployee("李四", 2032, new MyDate(1998, 1, 1), 300, 100);
        for(int i =0; i< employees.length;i++){
            System.out.println(employees[i]);//输出某个对象的引用时，实际上就是调用当前对象的toString()，所以这里不加上”.toString()“也没关系
            System.out.println("月工资为：" + employees[i].earnings());
            if(month == employees[i].getBirthday().getMonth()){
                System.out.println("生日快乐！奖励100元");
            }
            System.out.println();
        }


    }

}

//抽象父类
abstract class Employee {
    private String name;
    private int number;
    private MyDate birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    public Employee(String name, int number, MyDate birthday) {
        this.name = name;
        this.number = number;
        this.birthday = birthday;
    }

    //抽象方法，供子类继承，用来返回员工的工资
    public abstract int earnings();

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", birthday=" + birthday.toDateString() +
                '}';
    }
}

class MyDate {
    private int year;
    private int month;
    private int day;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String toDateString() {
        String str = String.valueOf(year);
        return str + "年" + month + "月" + day + "日";
    }
}

//按月结算工资
class SalariedEmployee extends Employee {
    private int monthlySalary;//月工资

    public SalariedEmployee(String name, int number, MyDate birthday, int monthlySalary) {
        super(name, number, birthday);
        this.monthlySalary = monthlySalary;
    }

    public int getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(int monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    @Override
    public int earnings() {
        return monthlySalary;
    }

    @Override
    public String toString() {
        return "SalariedEmployee" + super.toString();
    }
}

//按小时结算工资
class HourEmployee extends Employee {
    private int wage;
    private int hour;

    public int getWage() {
        return wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public HourEmployee(String name, int number, MyDate birthday, int wage, int hour) {
        super(name, number, birthday);
        this.wage = wage;
        this.hour = hour;
    }

    @Override
    public int earnings() {
        return wage * hour;
    }

    @Override
    public String toString() {
        return "HourEmployee" + super.toString();
    }
}
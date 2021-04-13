package pers.yangzhen.oop.interfaces;

/*
 * 1.定义一个接口用来实现两个对象的比较：
 * interface CompareObject{
 *       public int compareTo(Object o);//若返回值是0，代表相等；若为正数，代表当前对象大；负数代表当前对象小
 * }
 * 2.定义一个Circle类，声明radius属性，提供getter和setter方法
 * 3.定义一个ComparableCircle类，继承Circle类并且实现CompareObject接口。在ComparableCircle类中给出接口中方法compareTo的实现体，用来比较两个圆的半径大小。
 * 4.定义一个测试类Exercise，创建两个ComparableCircle对象，调用compareTo方法比较两个类的半径大小。
 * 思考:参照上述做法定义矩形类Rectangle和ComparableRectangle类，在ComparableRectangle类中给出compareTo方法的实现，比较两个矩形的面积大小
 * */
public class Exercise {
    public static void main(String[] args) {
        ComparableCircle circle1 = new ComparableCircle(2.2);
        ComparableCircle circle2 = new ComparableCircle(1.4);
        int isGreater = circle1.compareTo(circle2);
        if(isGreater > 0){
            System.out.println("circle1的半径大于circle2");
        }else if(isGreater == 0){
            System.out.println("circle1的半径等于circle2");
        }else{
            System.out.println("circle1的半径小于circle2");
        }
    }
}

interface CompareObject {
    int compareTo(Object o);//若返回值是0，代表相等；若为正数，代表当前对象大；负数代表当前对象小
}

class Circle {
    private Double radius;

    public Circle() {

    }

    public Circle(Double radius) {
        this.radius = radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public Double getRadius() {
        return this.radius;
    }
}

class ComparableCircle extends Circle implements CompareObject {

    public ComparableCircle(Double radius){
        super(radius);
    }

    @Override
    public int compareTo(Object o) {
        if (this == o) {
            return 0;
        }
        if (o instanceof ComparableCircle) {
            ComparableCircle c = (ComparableCircle) o;
            //方式一：
            if (this.getRadius() > c.getRadius()) {
                return 1;
            } else if (this.getRadius() < c.getRadius()) {
                return -1;
            } else {
                return 0;
            }
            //方式二：
            //return this.getRadius().compareTo(c.getRadius());
        } else {
            throw new RuntimeException("传入的数据类型不匹配");
        }
    }
}

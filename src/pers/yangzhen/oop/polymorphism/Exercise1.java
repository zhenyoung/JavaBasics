package pers.yangzhen.oop.polymorphism;

import com.sun.xml.internal.ws.encoding.MtomCodec;

/*多态性练习
 * 需求：
 * 1.定义三个类，父类GeometricObject代表几何图形，子类Circle代表圆形，MyRectangle代表矩形；
 * 2.定义一个测试类，编写equalsArea方法测试两个对象的面积是否相等（注意方法的参数类型，利用动态绑定技术）
 * 3.编写displayAreaOfGeometricObject方法显示对象的面积（注意方法的参数类型，利用动态绑定技术）
 * */
public class Exercise1 {//测试类

    public static void main(String[] args) {
        Exercise1 test = new Exercise1();
        Circle c1 = new Circle(2.0, "white", 1.0);
        Circle c2 = new Circle(3.0, "white", 1.0);
        MyRectangle rect = new MyRectangle("red", 1.0, 2.0, 3.0);
        test.displayAreaOfGeometricObject(c1);//多态性的体现：子类对象作为原本定义为父类型的形参
        test.displayAreaOfGeometricObject(rect);//多态性的体现：子类对象作为原本定义为父类型的形参
        boolean isEquals = test.equalsArea(c1, c2);//多态性的体现：子类对象作为原本定义为父类型的形参
        System.out.println("c1和c2面积是否相等：" + isEquals);


    }

    public boolean equalsArea(GeometricObject object1, GeometricObject object2) {
        return object1.findArea() == object2.findArea();
    }

    public void displayAreaOfGeometricObject(GeometricObject object) {
        System.out.println("面积为：" + object.findArea());
    }
}

class GeometricObject {
    protected String color;
    protected double weight;//占比权重

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public GeometricObject(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    public double findArea() {
        return 0.0;//这里只是随意赋的一个值，具体计算方法见子类
    }

}


class Circle extends GeometricObject {
    private double radius;

    public Circle(double radius, String color, double weight) {
        super(color, weight);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double findArea() {
        return Math.PI * radius * radius;
    }
}


class MyRectangle extends GeometricObject {
    private double width;
    private double height;

    public MyRectangle(String color, double weight, double width, double height) {
        super(color, weight);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double findArea() {
        return width * height;
    }
}
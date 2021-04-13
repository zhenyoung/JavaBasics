package pers.yangzhen.oop.inheritance;

/*
* 需求：求圆柱体体积
* 1. Circle类设置圆柱底面半径，并求出底面积；
* 2. Cylinder类设置圆柱高度，并继承Circle类，求出体积；
* 3. CylinderTest类创建Cylinder类型的对象，求出一个具体圆柱的体积
* */
public class CylinderTest {
    public static void main(String[] args) {//radius和length默认为1.0
        Cylinder someCylinder = new Cylinder();
        someCylinder.setRadius(1.5);
        someCylinder.setLength(2);
        double volume = someCylinder.findVolume();
        System.out.println("圆柱半径为：" + someCylinder.getRadius());
        System.out.println("圆柱高度为：" + someCylinder.getLength());
        System.out.println("圆柱体积为：" + volume);

    }
}

class Cylinder extends Circle{
    double length;//圆柱高度
    public Cylinder(){
        length = 1.0;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double findVolume(){
        return findArea() * length;
    }

}

class Circle {
    double radius;

    public Circle(){
        radius = 1.0;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double findArea(){
        return Math.PI * radius * radius;
    }

}
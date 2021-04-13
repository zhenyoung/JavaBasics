package pers.yangzhen.oop.constructor;

public class TriAngle {
    private double base;
    private double height;

    //    通过声明公共的方法访问私有变量
    public void setBase(double b) {
        base = b;
    }

    public double getBase() {
        return base;
    }

    public void setHeight(double h) {
        height = h;
    }

    public double getHeight() {
        return height;
    }

    //    构造器声明
    public TriAngle() {

    }

    public TriAngle(double b, double h) {
        base = b;
        height = h;
    }

    //    声明计算面积的公共的方法
    public double area() {
        double area = base * height / 2.0;
        return area;
    }

}

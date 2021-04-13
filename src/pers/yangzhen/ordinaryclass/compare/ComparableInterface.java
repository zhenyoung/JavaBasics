package pers.yangzhen.ordinaryclass.compare;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author yangzhen
 * @create 2021-03-23 18:35
 */
public class ComparableInterface {

    @Test
    public void test1(){
        Goods[] arr = new Goods[5];
        arr[0] = new Goods("microsoftMouse",34);
        arr[1] = new Goods("dellMouse",43);
        arr[2] = new Goods("xiaoMi",20);
        arr[3] = new Goods("huaweiMouse",50);
        arr[4] = new Goods("lenovoMouse",34);

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));


    }
}

//商品类
class Goods implements java.lang.Comparable {
    private String name;
    private double price;

    public Goods() {
    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    //指明商品比较大小的方式
    @Override
    public int compareTo(Object obj){
        if(obj instanceof Goods){
            Goods goods = (Goods)obj;
            if(this.price > goods.price){
                return 1;
            }else if(this.price == goods.price){
                return this.name.compareTo(goods.name);//价格一致时，按照名字首字母排序(从低到高)
            }
            return -1;
        }
        throw new RuntimeException("传入的数据类型不一致！");
    }

}

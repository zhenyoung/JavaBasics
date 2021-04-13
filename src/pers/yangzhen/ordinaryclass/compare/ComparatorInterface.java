package pers.yangzhen.ordinaryclass.compare;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 实现Comparator接口：定制排序
 * @author yangzhen
 * @create 2021-03-23 18:36
 */
public class ComparatorInterface {

    @Test
    public void test1(){
        String[] arr = new String[]{"TT","KK","GG","AA","BB","CC","DD","EE"};
        Arrays.sort(arr,new Comparator(){//匿名实现类的匿名对象

            //按照字符串从大到小的顺序排列
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof String && o2 instanceof String){
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return -s1.compareTo(s2);//加上负号表示从大到小

                }
                throw new RuntimeException("输入的数据类型不一致");
            }
        });
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test2(){
        Goods[] arr = new Goods[5];
        arr[0] = new Goods("microsoftMouse",34);
        arr[1] = new Goods("dellMouse",43);
        arr[2] = new Goods("xiaoMi",20);
        arr[3] = new Goods("huaweiMouse",50);
        arr[4] = new Goods("microsoftMouse",35);

        Arrays.sort(arr, new Comparator() {
            //产品先按名称从低到高排序，名称一致时则按价格排序从高到低
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Goods && o2 instanceof Goods){
                    Goods goods1 = (Goods)o1;
                    Goods goods2 = (Goods)o2;
                    if(goods1.getName().equals(goods2.getName())){
                        //调用包装类的compare方法
                        return -Double.compare(goods1.getPrice(),goods2.getPrice());
                    }else{
                        //String类中重写了compareTo()，默认会给字符串从小到大排序
                        return goods1.getName().compareTo(goods2.getName());
                    }
                }
                throw new RuntimeException("输入类型不匹配");
            }

        });
        System.out.println(Arrays.toString(arr));
    }
}

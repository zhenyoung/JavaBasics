package pers.yangzhen.reflection.getallmembersfromclass;

import java.io.Serializable;

/**
 * @author yangzhen
 * @create 2021-04-13 14:15
 */
public class Creature<T> implements Serializable {
    private  char gender;
    public double weight;

    private void breathe(){
        System.out.println("生物呼吸");
    }

    public void eat(){
        System.out.println("生物吃东西");
    }


}

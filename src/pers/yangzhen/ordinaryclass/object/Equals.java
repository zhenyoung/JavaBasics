package pers.yangzhen.ordinaryclass.object;

public class Equals {

    public static void main(String[] args) {
        Person person1 = new Person("Tom", 21);
        Person person2 = new Person("Tom", 21);
        String str1 = "Tom";
        String str2 = "Tom";
        System.out.println(person1 == person2);//false，尽管属性值一致，但是person1和person2是两个对象，拥有不同的地址值
//        System.out.println(person1.equals(person2));//重写equals方法前是false
        System.out.println(str1.equals(str2));//true
        System.out.println(person1.equals(person2));//重写equals方法后是true

    }

}


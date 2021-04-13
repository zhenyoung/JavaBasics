package pers.yangzhen.ordinaryclass.object;

public class toString {
    public static void main(String[] args) {
        Person person = new Person();
        String str1 = new String("HandsomeBoy");//String类中重写了toString方法
        System.out.println(str1.toString());
        System.out.println(str1);//因为在输出时是会默认自动调toString()的，这里不写也没关系
        System.out.println(person.toString());
        System.out.println(person);

    }

}

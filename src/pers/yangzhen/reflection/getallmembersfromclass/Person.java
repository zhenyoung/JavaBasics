package pers.yangzhen.reflection.getallmembersfromclass;

/**
 * @author yangzhen
 * @create 2021-04-13 14:19
 */
@MyAnnotation(value = "hi")
public class Person extends Creature<String> implements Comparable<String>,MyInterface{
    private String name;
    int age;
    public int id;

    public Person(){
    }

    @MyAnnotation(value = "abc")
    private Person(String name){
        this.name = name;
    }

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    @MyAnnotation
    public void show(String nation){
        System.out.println("我是" + nation + "人");
    }
    public String display(String interests, int age) throws NullPointerException,ClassCastException{
        return interests;
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public void info() {
        System.out.println("我是一个好人");
    }


}

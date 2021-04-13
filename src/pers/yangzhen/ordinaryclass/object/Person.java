package pers.yangzhen.ordinaryclass.object;

import java.util.Objects;//java.lang包是默认导入了的，但是util包要手动导入

public class Person {
    int age;
    String name;

    public Person() {

    }

    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    //equals方法重写的原则：比较两个对象的实体内容
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj instanceof Person) {
//            Person person = (Person) obj;
//            //比较两个对象的每个属性是否否相同
//            return this.age == person.age && this.name.equals(person.name);
//        }
//        return false;
//    }

    //利用IDE重写的equals方法
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;//类型不一致
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

//    @Override
//    public String toString() {
//        return "Person[ age=" + age + ", name=" + name + " ]";
//    }


    //利用IDE重写的toString()方法
    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +          /* \'为转义字符' */
                '}';
    }


}

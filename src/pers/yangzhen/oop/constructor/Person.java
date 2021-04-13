package pers.yangzhen.oop.constructor;

public class Person {
    public Person() {
        System.out.println("调用空参构造器");
    }

    public Person(double x) {
        this();
        System.out.println("调用有1个形参的构造器" + x);
    }

    public Person(double x, double y) {
        this(x);
        System.out.println("调用2个形参的构造器" + x + " " + y);
    }
}

class Person1{
    int age;
    int id;
    public Person1(){
        age = 20;
    }

    public Person1(int age){
        this.age = age;
    }

}

class Person2 extends Person1{
    public Person2(){

    }
    /*public Person2(){
        super();//写上也行，不写就默认加上了super();
        //再多写一行super(age)或者this(age)就会报错，因为this(形参列表)和super(形参列表)只能位于首行的特点使得只能写一个
        //注意：上面的构造器与本构造器本质上是同一个构造器，所以不能同时写出，否则会报错
    }*/

    /*public Person2(){
        super(age);
        //这样写也是错的，因为构造器的初始化是早于局部变量的，换句话说，构造器初始化时局部变量age还没有创建（构造器是空参的，没有形参，也就没有创建局部变量了），所以就无法调用了
    }*/

    /*public Person2(int age){
        super(age,id);
        //同理，这样试图去调父类中的public Person(double x, double y)构造器时，由于初始化构造器时id局部变量还没有创建，所以不能调用父类中的构造器
    }*/

    public Person2(int age){
        super(age);//调用带参的构造器
        this.age = age;
    }
    //若是将上面父类中的空参构造器删了，只保留带参的那个，那么上面没写super(形参列表)和this(形参列表)的子类构造器便无法默认找到父类中的空参构造器，便会报错。
    // 因为一旦只写了带参的构造器，便不再默认提供空参的构造器了，必须手动地写一个空参的构造器。
}

package pers.yangzhen.exceptionandlog;

public class ThrowTest {
    public static void main(String[] args) {
        try {
            Student s = new Student();
            s.register(-1001);
            System.out.println(s);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class Student {
    private int id;

    public void register(int id) throws Exception {
        if (id > 0) {
            this.id = id;
        } else {
//            throw new RuntimeException("您输入的数据非法！");//运行时报异常，抛出一个RuntimeException异常类的对象
            throw new Exception("您输入的数据非法！");//抛出一个Exception异常类的对象
        }
    }
}
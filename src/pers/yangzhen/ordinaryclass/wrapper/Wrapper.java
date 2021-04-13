package pers.yangzhen.ordinaryclass.wrapper;

public class Wrapper {
    public static void main(String[] args) {
        Difference test = new Difference();
        System.out.println(test.isBoy);//false，基本数据类型默认值为0
        System.out.println(test.isGirl);//null，类类型默认值为null

        //基本数据类型->包装类：调用包装类的构造器
        int num1 = 10;
        Integer int1 = new Integer(num1);
        System.out.println(int1.toString());//10

        Integer int2 = new Integer("123");
        System.out.println(int2.toString());//123

        //报异常，Integer的形参不管是String型还是int型，值必须是数字
//        Integer in3 = new Integer("123abc");
//        System.out.println(in3.toString());

        Float f1 = new Float(13.0f);
        Float f2 = new Float("13.0f");
        System.out.println(f1);
        System.out.println(f2);

        //特别地，Boolean包装类的String型的形参可以忽略大小写，而boolean型形参不能
        Boolean b1 = new Boolean(true);
        Boolean b2 = new Boolean("TrUe");
        Boolean b3 = new Boolean("true123");
        System.out.println(b3);//false


        //包装类->基本数据类型：调用包装类Xxx的xxxValue()
        Integer int3 = new Integer(12);
        int i1 = int3.intValue();
        System.out.println(i1);

        Float f3 = new Float(12.3);
        float f4 = f3.floatValue();
        System.out.println(f4);


        //基本数据类型、包装类->String类型
        //方式1：连接运算
        int num2 = 12;
        String str1 = num2 + "";
        //方法2：调用String重载的valueOf(Xxx xxx)方法（更常用）
        float f5 = 12.3f;
        String str2 = String.valueOf(f5);//基本数据类型转String
        Double d1 = new Double(12.4);
        String str3 = String.valueOf(d1);//包装类转String
        System.out.println(str1 + "\t" + str2 + "\t" + str3);

        //String类型->基本数据类型、包装类：调用包装类的parseXxx(String s)方法
        //注意：因为没有parsCharacter()方法，所以不能String->char及其包装类
        String str4 = "123";
        int num3 = Integer.parseInt(str4);
        System.out.println(num3 + 1);
//        String str4 = "123abc";
//        int num3 = Integer.parseInt(str4);
//        System.out.println(num3 + 1);//NumberFormatException异常，值必须是数字，不能有字母

        String str5 = "trUe";
        boolean b4 = Boolean.parseBoolean(str5);
        System.out.println(b4);
        String str6 = "true123";
        boolean b5 = Boolean.parseBoolean(str6);
        System.out.println(b5);


        //Integer内部定义了IntegerCache类，IntegerCache中定义了1个Integer类型的数组cache[]
        //保存了-128~127范围的整数。如果使用自动装箱的方式，给Integer赋值的范围在-128~127范围内时，
        //可以直接使用数组中的元素，不用再去new对象调用方法赋值。目的：为了提高效率，只要在范围内就不用每次都去new
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j);

        Integer m = 1;
        Integer n = 1;
        System.out.println(m == n);//true

        Integer x = 128;
        Integer y = 128;
        System.out.println(x == y);//false
    }

}

class Difference {
    boolean isBoy;
    Boolean isGirl;
}

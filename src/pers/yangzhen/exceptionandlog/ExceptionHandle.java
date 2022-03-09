package pers.yangzhen.exceptionandlog;

import org.junit.Test;

public class ExceptionHandle {

    @Test
    public void test1(){
        String str = "abc";
        try{
            int num = Integer.parseInt(str);
            System.out.println("hello----1");//出现异常后，后面的语句就不会再执行了
        }catch(NullPointerException e){
            System.out.println("出现空指针异常，不要着急");
        }catch (NumberFormatException e){
            System.out.println(e.getMessage());
            // System.out.println("出现数值转换异常，不要着急");
        }
        System.out.println("hello----2");
    }

    @Test
    public static int test2(){

        try {
            int a = 10;
            int b = 0;
            System.out.println(a / b);
        }catch (ArithmeticException e){
            e.printStackTrace();
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 2;
        }finally {
            System.out.println("无敌最寂寞");
        }
        return 0;
    }
    public static int test3(){

        try {
            int a = 10;
            int b = 0;
            System.out.println(a / b);
        }catch (ArithmeticException e){
            e.printStackTrace();
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 2;
        }finally {
            System.out.println("无敌最寂寞");
            // 一般不在 finally 里面使用流程控制(如 return 、 throw 、 break 、 continue )，
            // finally 主要就是用来关闭资源的，这里仅仅是为了演示才写上 return
            return 3;
            // 如果在finally内部加上return语句，那么catch后面的return语句就不会执行了，方法到此结束
        }
    }
    public static void main(String[] args) {
        int num2 = test2();
        int num3 = test3();
        System.out.println(num2);
        System.out.println(num3);
    }
}

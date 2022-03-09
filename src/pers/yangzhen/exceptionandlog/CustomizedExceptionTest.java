package pers.yangzhen.exceptionandlog;

/*
 * 编写应用程序 CustomizedException.java ，接收命令行的两个参数，要求不能输入负数，计算两数相除。
 * 对数据类型不一致(NumberFormatException)、缺少命令行参数(ArrayIndexOutOFBoundsException)、
 * 除0(ArithmeticException)、输入负数(CustomizedException 自定义的异常)进行异常处理
 */

public class CustomizedExceptionTest {
    public static void main(String[] args) {
        try {
            int i = Integer.parseInt(args[0]);
            int j = Integer.parseInt(args[1]);
            System.out.println(exceptionManager(i, j));
        } catch (NumberFormatException e) {
            System.out.println("数据类型不一致");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("缺少命令行参数");
        } catch (ArithmeticException e) {
            System.out.println("除0");
        } catch (CustomizedException e) {
            System.out.println(e.getMessage());
        }
    }

    // 分子分母不能为负数，否则抛出自定义异常EcDef
    // throws CustomizedException 声明 exceptionManager 方法可能要抛出的异常类为 CustomizedException
    public static int exceptionManager(int i, int j) throws CustomizedException{
        if (i < 0 || j < 0) {
            // 手动抛出异常对象
            throw new CustomizedException("分子或分母为负数");
        }
        return i / j;
    }
}

package pers.yangzhen.ordinaryclass.dateandtime;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * JDK 8之前日期和时间的API测试
 *
 * @author yangzhen
 * @create 2021-03-20 22:27
 */
public class BeforeJava8 {

    //1.System类中的currentTimeMillis()
    @Test
    public void test1() {
        //返回当前时间与1970年1月1日0:00:00之间以毫秒为单位的时间差，叫做时间戳
        System.out.println(System.currentTimeMillis());
    }

    /*2.java.util.Date类（）：
          两个方法：toString()、getTime()
          两个构造器：Date()、Date(long time)
          */
    //java.sql.Date类（继承于java.util.Date类，数据库中使用），这里稍微了解即可
    @Test
    public void test2() {
        //构造器一：Date()创建一个对应当前时间的Date对象
        Date date1 = new Date();
        System.out.println(date1.toString());//java.util.Date类的toString()显示当前的年、月、日、时、分、秒
        System.out.println(date1.getTime());//同System类的currentTimeMillis()，返回时间戳

        //构造器二：创建指定毫秒数的Date对象
        Date date2 = new Date(1616251620714L);
        System.out.println(date2.toString());
        System.out.println(date2.getTime());

        //创建java.sql.Date对象
        java.sql.Date date3 = new java.sql.Date(1616251830081L);
        System.out.println(date3);//2021-03-20

        //如何将java.util.Date对象转换为java.sql.Date对象，即父类对象转换为子类对象
        //方式一：利用多态和强转进行相互转换
        Date date4 = new java.sql.Date(1616251830081L);
        java.sql.Date date5 = (java.sql.Date) date4;
        System.out.println(date5);
        //方式二：
        Date date6 = new Date();
        java.sql.Date date7 = new java.sql.Date(date6.getTime());
        System.out.println(date7);

    }

    /*
     * 3.SimpleDateFormat的使用：SimpleDateFormat对日期的格式化和解析
     * 从类的字面意思也好理解：简单日期格式化，起到将日期时间格式化的作用
     * */
    @Test
    public void test3() throws ParseException {//解析时声明的异常
        //实例化SimpleDateFormat：使用空参构造器
        SimpleDateFormat sDF = new SimpleDateFormat();

        //格式化：日期---->字符串
        Date date = new Date();
        System.out.println(date);//Sun Mar 21 23:27:01 CST 2021
        String format = sDF.format(date);//format 返回格式化（默认译成中国格式）后的日期
        System.out.println(format);//21-3-21 下午11:27
        //解析：字符串---->日期
        String str = "2021-3-21 下午5:31";//首先应声明一个异常，格式必须为“年-月-日 上午/下午xx:xx”，否则会报异常
        Date date1 = sDF.parse(str);//译成标准时间
        System.out.println(date1);//Sun Mar 21 17:31:00 CST 2021

        System.out.println("*************************");
        /*一般习惯使用带参的构造器格式化时间*/
        Date date2 = new Date();
        SimpleDateFormat sDF1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//指定格式，其中HH代表24小时制，hh代表12小时制
        System.out.println(sDF1.format(date2));//2021-03-21 23:27:01
        System.out.println(sDF1.parse(sDF1.format(date2)));//Sun Mar 21 23:27:01 CST 2021，时间格式应与构造其形参格式一致，否则报异常
        System.out.println(sDF1.parse("2021-03-21 23:26:56"));//Sun Mar 21 23:26:56 CST 2021
    }

    /*
     * Calendar抽象类的使用
     */
    @Test
    public void testCalendar() {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getClass());//GregorianCalendar，所以getInstance也是通过GregorianCalendar子类实例化

        //public int get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);//23

        //public void set()
        calendar.set(Calendar.DAY_OF_MONTH, 21);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));//21

        //abstract public void add()
        calendar.add(Calendar.DAY_OF_MONTH, 2);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));//23
        calendar.add(Calendar.DAY_OF_MONTH, -3);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));//20

        //public final Date getTime()：Calendar类--->Date类
        Date date1 = calendar.getTime();
        System.out.println(date1);//Sat Mar 20 13:12:53 CST 2021

        //public final void setTime():Date类--->Calendar类
        Date date2 = new Date();
        calendar.setTime(date2);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));//23
    }

}

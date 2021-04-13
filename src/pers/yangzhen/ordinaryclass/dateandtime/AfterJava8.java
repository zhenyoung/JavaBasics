package pers.yangzhen.ordinaryclass.dateandtime;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * JDK 8之后的日期时间API
 *
 * @author yangzhen
 * @create 2021-03-23 14:20
 */
public class AfterJava8 {

    /*
    * LocalDate、LocalTime、LocalDateTime(较常用)类的使用
    * */
    @Test
    public void test1(){
        //now()获取当前日期、时间、日期 + 时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);//2021-03-23
        System.out.println(localTime);//14:36:58.610
        System.out.println(localDateTime);//2021-03-23T14:36:58.610

        System.out.println("***********************************");
        //of()设置指定的年、月、日、时、分、秒
        LocalDate localDate1 = LocalDate.of(2020, 3, 23);
        LocalTime localTime1 = LocalTime.of(14, 33, 35);
        LocalDateTime localDateTime1 = LocalDateTime.of(2021, 3, 23,15,12,13);
        System.out.println(localDate1);//2020-03-23
        System.out.println(localTime);//14:36:58.610
        System.out.println(localDateTime1);//2021-03-23T15:12:13

        System.out.println("**********************************");
        //getXxx()
        System.out.println(localDateTime.getDayOfMonth());//23
        System.out.println(localDateTime.getDayOfWeek());//TUESDAY
        System.out.println(localDateTime.getMonth());//MARCH
        System.out.println(localDateTime.getMonthValue());//3
        System.out.println(localDateTime.getMinute());//36

        System.out.println("**********************************");
        //类似String字符串的不可变性：重新产生一个指定的时间，而不是在当前时间上修改
        LocalDate localDate2 = localDate.withDayOfMonth(11);
        System.out.println(localDate);//2021-03-23，当前日期并没有变
        System.out.println(localDate2);//2021-03-11，重新产生的日期
        //同上：不可变性
        LocalDateTime localDateTime2 = localDateTime.withHour(4);//改变小时数
        System.out.println(localDateTime);//2021-03-23T14:45:06.270
        System.out.println(localDateTime2);//2021-03-23T04:45:06.270
        //同上：不可变性
        LocalDate localDate3 = localDate.plusDays(12);//当前3.23加10天
        System.out.println(localDate3);//2021-04-04
        LocalDate localDate4 = localDate.minusMonths(8);//当前2021.3.23减8个月
        System.out.println(localDate4);//2020-07-23

    }

    @Test
    public void test2(){
        //now()：获取本初子午线对应的标准时间
        Instant instant = Instant.now();
        System.out.println(instant);//2021-03-23T07:06:18.337Z
        //添加时间的偏移量以符合时区
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);//2021-03-23T15:07:34.445+08:00

        //toEpochMilli()：获取子1970年1月1日0时0分0秒（UTC）开始的毫秒数 ---> Date类的getTime()
        long milliSeconds = instant.toEpochMilli();
        System.out.println(milliSeconds);//1616483297713，返回标准时间的时间戳

        //ofEpochMilli()：通过给定的毫秒数，获取instant实例 ---> Date(long millis)
        Instant instant1 = Instant.ofEpochMilli(1616483297713L);
        System.out.println(instant1);//2021-03-23T07:08:17.713Z
    }

    @Test
    public void test3(){
        //方式一：预定义的标准格式。如：ISO_LOCAL_DATE_TIME、ISO_LOCAL_DATE、ISO_LOCAL_TIME
        //格式化：日期--->字符串
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime localDateTime = LocalDateTime.now();
        String str1 = formatter.format(localDateTime);
        System.out.println(localDateTime);//2021-03-23T16:36:20.766
        System.out.println(str1);//2021-03-23T16:36:20.766
        //解析：字符串--->日期
        TemporalAccessor parse = formatter.parse("2021-03-23T16:30:39.826");
        System.out.println(parse);//{},ISO resolved to 2021-03-23T16:30:39.826


        //方式二：本地化相关的格式。如：ofLocalizedDateTime(formatStyle.LONG)
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        //格式化
        String str2 = formatter1.format(localDateTime);
        System.out.println(str2);//2021年3月23日

        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        String str3 = formatter2.format(LocalDate.now());
        System.out.println(str3);//2021年3月23日 星期二

        //方式三(最常用)：自定义格式
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //格式化
        String str4 = formatter3.format(localDateTime.now());
        System.out.println(str4);//2021-03-23 16:49:16
        //解析
        TemporalAccessor accessor = formatter3.parse("2021-03-23 16:49:16");
        System.out.println(accessor);//{},ISO resolved to 2021-03-23T16:49:16

    }
}

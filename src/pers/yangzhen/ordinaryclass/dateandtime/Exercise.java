package pers.yangzhen.ordinaryclass.dateandtime;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 三天打渔，两天晒网
 * 假定 1990-01-01 00:00:00渔民开始打渔
 * 问：任意一个日期时，渔民是打渔还是晒网
 *
 * @author yangzhen
 * @create 2021-03-21 20:35
 */
public class Exercise {
    @Test
    public void test() throws ParseException {

        String begin = "1990-01-01";
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
        Date date1 = sdf.parse(begin);
        long beginTime = date1.getTime();

        Date date2 = new Date();
        long currentTime = date2.getTime();

        long days = (currentTime - beginTime)/(1000*3600*24) + 1;
        long years = (currentTime - beginTime)/(1000*3600*24)/365;
//        long years = (currentTime - beginTime)/(1000*3600*24)/365;//存在溢出问题

        System.out.println(days);
        int target = (int)days % 5;
        switch (target){
            case 1:
            case 2:
            case 3:
                System.out.println("打渔");
                break;
            case 4:
            case 0:
                System.out.println("晒网");
                break;
        }
    }

}


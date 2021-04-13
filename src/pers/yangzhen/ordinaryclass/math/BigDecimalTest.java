package pers.yangzhen.ordinaryclass.math;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author yangzhen
 * @create 2021-03-24 11:19
 */
public class BigDecimalTest {

    @Test
    public void test(){
        BigInteger bi = new BigInteger("12433241123");
        BigDecimal bd = new BigDecimal("12312.1213");
        BigDecimal bd2 = new BigDecimal("11");
        System.out.println(bi);

        System.out.println(bd.divide(bd2,BigDecimal.ROUND_HALF_UP));// bd/bd2，结果四舍五入
        System.out.println(bd.divide(bd2,15,BigDecimal.ROUND_HALF_UP));// bd/bd2，结果四舍五入，精度为15位
    }
}

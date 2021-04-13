package pers.yangzhen.datatype;

public class TypeConvert {
    public static void main(String[] args) {
//************************************************************************
        byte byte1 = 1;
        byte byte2 = 2;
        short short1 = 3;
        short short2 = 4;
        int int1 = 5;
        long long1 = 6;
        long long2 = 7;
        float float1 = 8.0f;
        float float2 = 9.0f;
        double double1 = 10.0;
        char char1 = 'a';
        char char2 = 'A';
        String string1 = "IMMORTALS";
//************************************************************************
        //byte + byte
        int bytePlusByte = byte1 + byte2;//结果为int型，需要int型变量去接收结果值
        System.out.println("bytePlusByte:" + bytePlusByte);
        //byte + short
        int bytePlusShort = byte1 + short1;//结果为int型，需要int型变量去接收结果值
        System.out.println("bytePlusShort:" + bytePlusShort);
        //byte + char
        int bytePlusChar = byte1 + short1;//结果为int型，需要int型变量去接收结果值
        System.out.println("bytePlusShort:" + bytePlusChar);
        //short + short
        int shortPlusShort = short1 + short2;//结果为int型，需要int型变量去接收结果值
        System.out.println("shortPlusShort:" + shortPlusShort);
        //short + char
        int shortPlusInt = short1 + char1;//结果为int型，需要int型变量去接收结果值
        System.out.println("shortPlusInt:" + shortPlusInt);
        //char + char
        int charPlusChar = char1 + char2;//结果为int型，需要int型变量去接收结果值
        System.out.println("charPlusChar:" + charPlusChar);
        /*综上可知：当byte、char、short三种类型做运算（同一类型之间和不同类型之间）时，结果都默认为int型，因此接收时都需要
        定义一个int类型的变量接收值*/


        //int + long
        long intPlusLong = int1 + long1;//结果为long型，需要long类型变量去接受结果值
        System.out.println(intPlusLong);
        //long + float
        float longPlusFloat = long2 + float1;//结果为float型，需要float类型变量去接受结果值
        System.out.println(longPlusFloat);
        //float + double
        double floatPlusDouble = float2 + double1;//结果为double型，需要double类型变量去接受结果值
        System.out.println(floatPlusDouble);
        /*综上可知，当容量小的数据类型的变量与容量大的数据类型的变量做运算时，结果自动提升为容量大的数据类型。
        即 byte、char、short → int → long → float → double
        特别地，当byte、char、short三种类型的变量做运算时，结果为int型*/


        System.out.println(char1 + 2 + string1);//99IMMORTALS
        System.out.println(char1 + string1 + 2);//aIMMORTALS2
        System.out.println(string1 + char1 + 2);//IMMORTALSa2
        /*综上可知，当 + 左右两边有字符串String，则 + 会作为连接符将另一边的变量自动转换成为字符串，然后连接起来
        若没有，则 + 会作为加运算符*/
//*************************************************************************
        float a = 1.0f;
        float b = 2.0f;
        float c = a / b;
        System.out.println(c);
//************************************************************************
    }
}
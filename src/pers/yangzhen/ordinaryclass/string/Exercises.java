package pers.yangzhen.ordinaryclass.string;

import org.junit.Test;

/**
 * 一些练习题
 *
 * @author yangzhen
 * @create 2021-03-20 16:51
 */
public class Exercises {
    /*
     * 将一个字符串进行反转。将字符串中指定部分进行反转，比如"abcdefg"反转为"abfedcg"
     * */
    //方式一：转换成char[]
    public String reverse(String str, int startIndex, int endIndex) {
        if (str != null) {
            char[] arr = str.toCharArray();
            for (int x = startIndex, y = endIndex; x < y - 1; x++, y--) {
                char temp = arr[x];
                arr[x] = arr[y];
                arr[y] = temp;
            }
            return new String(arr);
        }
        return null;
    }

    //方式二：通过StringBuffer/StringBuilder的拼接
    public String reverse1(String str, int startIndex, int endIndex) {
        if (str != null) {
            StringBuilder reverseStr = new StringBuilder(str.length());//创建一个与str等长度的StringBuilder对象
            reverseStr.append(str.substring(0, startIndex));//添加首
            for (int i = endIndex; i >= startIndex; i--) {
                reverseStr.append(str.charAt(i));
            }
            reverseStr.append(str.substring(endIndex + 1));//添加尾
            return reverseStr.toString();//将StringBuilder的内容通过toString输出成字符串返回
        }
        return null;
    }

    @Test
    public void testReverse() {
        String str = "abcdefg";
        String str1 = reverse1(str, 2, 5);
        System.out.println(str1);
    }


    /*获取一个字符串在另一个字符串中出现的次数
     * 比如：获取"ab"在"abkkcadkabkebfasdfabd3brkad"中出现的次数
     * */
    public int getCount(String mainStr, String subStr) {
        int count = 0;
        int index = 0;
        int mainLength = mainStr.length();
        int subLength = subStr.length();
        if (subStr.length() <= mainStr.length()) {
            //方式一：
            //indexOf(String str)返回str在当前字符串中第一次出现时的首字符索引
            //substring(int beginIndex)返回一个新的字符串，从beginIndex到当前字符串结束的子字符串
            while ((index = mainStr.indexOf(subStr)) != -1) {
                count++;
                mainStr = mainStr.substring(index + subStr.length());//每次循环将起始索引往后挪，形成为一个新的mainStr
            }

            //方式二：方式一的优化
            //indexOf(String str, int fromIndex)返回从fromIndex开始，str在当前字符串中第一此出现时的首字符索引
            while ((index = mainStr.indexOf(subStr, index)) != -1) {//index随着字符串向后遍历而不断改变
                count++;//每次进入循环都说明找到了子串
                index += subLength;//index跳过子串，进入下一次查询
                //当找不到子串时返回-1，退出循环
            }
            return count;
        }
        return 0;
    }

    @Test
    public void testGetCount() {
        String mainString = "abkkcadkabkebfasdfabd3brkad";
        String subString = "ab";
        int count = getCount(mainString, subString);
        System.out.println(count);
    }


    /*获取两个字符串中最大相同子串（待理解，且有多个相同子串的问题没有考虑）
     * 比如：str1 = "abcwerthelloyuiodef";str2 = "cvhellobnm"
     * 核心思想：在str1中找str2的子串（从str2本身到最后一个字符）
     * */
    public String getMaxSameString(String str1, String str2) {
        if (str1 != null && str2 != null) {
            String maxStr = (str1.length() >= str2.length()) ? str1 : str2;
            String minStr = (str1.length() < str2.length()) ? str1 : str2;
            int length = minStr.length();

            for (int i = 0; i < length; i++) {
                for (int x = 0, y = length - i; y <= length; x++, y++) {
                    String subStr = minStr.substring(x, y);//[x,y)索引间的子串
                    if (maxStr.contains(subStr)) {//此时找到相同子串
                        return subStr;
                    }
                }
            }
        }
        return null;
    }

    @Test
    public void testGetMaxSameString() {
        String str1 = "abcwerthelloyuiodef";
        String str2 = "cvhellobnm";
        String str = getMaxSameString(str1, str2);
        System.out.println(str);
    }

}
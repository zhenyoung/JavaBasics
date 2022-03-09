package pers.yangzhen.exercises.problems;

import java.util.Scanner;

public class DateConvert {
//    需求：
//    1.日期转换成天数
//    2.天数转换成日期
//    举例：2001-09-06是2001年的第249天，2001年的第249天是2001-09-06
    public static void main(String[] args) {

        /*界面*/
        System.out.println("********************************************");
        System.out.println("Please select your choice:");
        System.out.println("     1.Date to days");
        System.out.println("     2.Days to date");
        System.out.println("********************************************");

        /*选择界面*/
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        if (choice == 1) {
            DateToDays dateToDays = new DateToDays();
            dateToDays.dateMethod();
            System.out.println(dateToDays.year + "-" + dateToDays.month + "-" + dateToDays.day +
                    "是" + dateToDays.year + "的第" + dateToDays.sumDays + "天");
        } else if (choice == 2) {
            DaysToDate daysToDate = new DaysToDate();
            daysToDate.daysMethod();
            System.out.println(daysToDate.year + "年第" + daysToDate.sumDays + "天是" + daysToDate.year + "-" + daysToDate.month + "-" + daysToDate.day);
        } else {
            System.out.println("Choice error!!");
        }
    }
}

class Judgement {
    /*Judgement类中创建判断是否是闰年的isLeapYear方法*/
    public boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

}

class DateToDays {
    int[][] daysOfMonth = new int[][]{{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}, /*平年，月份数字对应数组索引*/
            {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}};/*闰年*/
    int year = 0;
    int month = 0;
    int day = 0;
    int sumDays = 0;
    public void dateMethod() {
        System.out.println("Date to days");
        Scanner scan = new Scanner(System.in);
        System.out.print("year:");
        year = scan.nextInt();
        System.out.print("month:");
        month = scan.nextInt();
        System.out.print("day:");
        day = scan.nextInt();

        Judgement judgement = new Judgement();
        if (judgement.isLeapYear(year)) {/*闰年29*/
            for (int i = 0; i < month; i++) {
                sumDays += daysOfMonth[1][i];
            }
        } else {
            for (int i = 0; i < month; i++) {/*平年28*/
                sumDays += daysOfMonth[0][i];
            }
        }
        sumDays += day;
    }

}

class DaysToDate {
    int[][] daysOfMonth = new int[][]{{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
            {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}};
    int year = 0;
    int month = 0;
    int day = 0;
    int sumDays = 0;
    public void daysMethod() {
        System.out.println("Days to date");
        Scanner scan = new Scanner(System.in);
        System.out.print("year:");
        year = scan.nextInt();
        System.out.print("days:");
        sumDays = scan.nextInt();
        day = sumDays;
        Judgement judgement = new Judgement();
        if (judgement.isLeapYear(year)) {
            for (int i = 1; day > daysOfMonth[1][i];) {
                day -= daysOfMonth[1][i];
                i++;
                month = i;
            }
        } else {
            for (int i = 1; day > daysOfMonth[1][i];) {
                day -= daysOfMonth[0][i];
                i++;
                month = i;
            }
        }
    }

}
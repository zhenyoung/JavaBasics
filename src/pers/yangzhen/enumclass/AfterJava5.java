package pers.yangzhen.enumclass;

/**
 * @author yangzhen
 * @create 2021-03-24 14:43
 */
public class AfterJava5 {
    public static void main(String[] args) {
        System.out.println(Season.SPRING);
        System.out.println(Season.SUMMER);
        System.out.println(Season.AUTUMN);
        System.out.println(Season.WINTER);

        System.out.println("************************");
        //values()：返回枚举类型的对象数组。该方法可以很方便地遍历所有的枚举值
        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
            values[i].show();
        }
        System.out.println("************************");
        //增强for循环
//        for(Season1 s:Season1.values()){
//            System.out.println(s);
//        }

        System.out.println("************************");
        //valueOf(String objName)：返回枚举类中对象名是objName的对象
        Season1 winter = Season1.valueOf("WINTER");
        System.out.println(winter);
        //如果没有objName的枚举类对下个，则抛出异常，如：
//        Season1 winter1 = Season1.valueOf("WINTER1");
//        System.out.println(winter1);//IllegalArgumentException


    }
}

interface Info{
    public void show();
}

enum Season1 implements Info{
    //提供当前枚举类的对象，多个对象之间使用逗号隔开，末尾对象用分号结束
    SPRING("春天","春暖花开"),
    SUMMER("夏天","夏日炎炎"),
    AUTUMN("秋天","秋高气爽"),
    WINTER("冬天","白雪皑皑");

    private final String Season1Name;
    private final String Season1Desc;

    private Season1(String Season1Name, String Season1Desc) {
        this.Season1Name = Season1Name;
        this.Season1Desc = Season1Desc;
    }

    public String getSeason1Name() {
        return Season1Name;
    }
    public String getSeason1Desc() {
        return Season1Desc;
    }

    public void show(){
        System.out.println("这是一个季节");
    }
}

//在上一个代码块中进行一些修改：
//public iostream AfterJava5 {
//    public static void main(String[] args) {
//        Season1[] values = Season1.values();
//        for (int i = 0; i < values.length; i++) {
//            System.out.println(values[i]);
//            values[i].show();
//        }
//
//    }
//}
//
//interface Info{
//    public void show();
//}
//
//enum Season1 implements Info{
//
//    SPRING("春天","春暖花开"){
//        @Override
//        public void show(){
//            System.out.println("春天在哪里");
//        }
//    },
//    SUMMER("夏天","夏日炎炎"){
//        @Override
//        public void show(){
//            System.out.println("宁夏");
//        }
//    },
//    AUTUMN("秋天","秋高气爽"){
//        @Override
//        public void show(){
//            System.out.println("秋天不回来");
//        }
//    },
//    WINTER("冬天","白雪皑皑"){
//        @Override
//        public void show(){
//            System.out.println("大约在冬季");
//        }
//    };
//
//    private final String Season1Name;
//    private final String Season1Desc;
//
//    private Season1(String Season1Name, String Season1Desc) {
//        this.Season1Name = Season1Name;
//        this.Season1Desc = Season1Desc;
//    }
//
//    public String getSeason1Name() {
//        return Season1Name;
//    }
//    public String getSeason1Desc() {
//        return Season1Desc;
//    }
//
//}
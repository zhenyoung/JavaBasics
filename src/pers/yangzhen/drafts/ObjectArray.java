package pers.yangzhen.drafts;

//        需求：
//        定义类Student，包含三个属性:学号number(int)，年级state(int)，成绩score(int)
//        创建20个学生对象，学号为1到20，年级和成绩都由随机数确定
//        ①打印出3年级(state值为3）的学生信息
//        ②使用冒泡排序按学生成绩排序，并遍历所有学生信息
public class ObjectArray {/*对象数组*/

    public static void main(String[] args) {
        Student[] students = new Student[20];

        //数组初始化
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student();//创建20个对象
            //赋值学号
            students[i].number = i + 1;
            //随机生成年级[1,6]
            students[i].state = (int) (Math.random() * (6 - 1 + 1) + 1);
            //随机生成分数[1,100]
            students[i].score = (int) (Math.random() * (100 - 1 + 1) + 1);
        }

        //ObjectArray类中的main方法中调用ObjectArray类中声明的其他方法需要创建对象，不能直接调用
        //ObjectArray类中的其他方法调用时则不用创建对象，可以直接对象。如findState方法中可以直接调用showArray方法
        ObjectArray test = new ObjectArray();
        System.out.println("********************************************" + "\n随机生成的学生如下：");
        test.showArray(students);
        System.out.println("********************************************" + "\n3年级的学生如下");
        test.findState(students);
        System.out.println("********************************************" + "\n分数排序后的学生如下");
        test.bubbleSort(students);
        test.showArray(students);

    }


    //遍历students数组
    public void showArray(Student[] students) {
        for (Student student : students) {
            System.out.println("学号：" + student.number + "\t"
                    + "年级：" + student.state + "\t" + "成绩：" + student.score);
        }
    }

    //找到3年级学生的成绩
    public void findState(Student[] students) {
        for (Student student : students) {
            if (student.state == 3) {
                System.out.println("学号：" + student.number + "\t"
                        + "年级：" + student.state + "\t" + "成绩：" + student.score);
            }
        }
    }

    //冒泡排序
    public void bubbleSort(Student[] students) {
        Student temp;
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = 0; j < students.length - 1 - i; j++) {
                if (students[j].score < students[j + 1].score) {
                    temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
    }
}

class Student {
    int number;//学号
    int state;//年级
    int score;//成绩
}

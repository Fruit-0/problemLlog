import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author 冲动火龙果
 * @version 1.0.0
 * @ClassName Test3.java
 * @Description TODO
 * @createTime 2021年04月03日 23:59:00
 */
public class Test3 {
    public static void main(String[] args) {
        String infoString = "101,lisi,98;202,wangwu,76;303,chenqi,84;404,zhangsan,49;505,xiaoming,67";
        int flag = 0;
        String[] split = infoString.split(";");
        Student  students [] = new Student[split.length];
        for (String s : split) {
            String[] studentInfo = s.split(",");
            Student student = new Student(studentInfo[0], studentInfo[1], studentInfo[2]);
            students[flag]=student;
            flag++;
        }
        System.out.println(Arrays.toString(students));
        for (Student student : students) {
            String name = student.getName();
            if ("zhangsan".equals(name)){
                System.out.println("找到张三了");
            }
        }


    }

}

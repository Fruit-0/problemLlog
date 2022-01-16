/**
 * @author 冲动火龙果
 * @version 1.0.0
 * @ClassName Test2.java
 * @Description
 * @createTime 2021年04月03日 23:29:00
 */
public class Test2 {
    public static void main(String[] args) {
        String id="342622199511050790";
        String substring1 = id.substring(6, 14);
        System.out.println(
                substring1
        );

        String substring = id.substring(id.length()-1);
        System.out.println(substring);
    }

}

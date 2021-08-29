/**
 * @author 冲动火龙果
 * @version 1.0.0
 * @ClassName Test4.java
 * @Description TODO
 * @createTime 2021年04月04日 00:12:00
 */
public class Test4 {
    public static void main(String[] args) {
        String id="342622199511050790";
        String di = "";
        for (int i = 1; i < id.length()+1; i++) {

            di += id.substring(id.length()-i,id.length()-i+1);
        }
        System.out.println(di);

    }
}

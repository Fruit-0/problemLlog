/**
 * @author 冲动火龙果
 * @version 1.0.0
 * @ClassName Test1.java
 * @Description stringTest-1
 * @createTime 2021年04月03日 22:13:00
 */
public class Test1 {
    public static void main(String[] args) {
        //首先要明确的一点就是，这三个类，都是用来对字符串进行操作的类，真要进行区分的话，string分为一类，buffer和build分为一类
        //之所以这么分，是因为string是不可变类（任何对其指定的字符串进行的操作都会产生新的对象），二buffer和builder是可变类（不会产生新的对象）
        String a="111";

        StringBuilder builder = new StringBuilder("111");

        StringBuffer buffer = new StringBuffer("111");
        String concat = a.concat("2");
        System.out.println(concat);
        System.out.println(a+2);
        int b = builder.length();

    }


}

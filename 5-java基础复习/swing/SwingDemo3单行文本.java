package swing;

import javax.swing.*;
import java.awt.*;

/**
 * @version 1.0.0
 * @项目名称：
 * @类名称：
 * @类描述：
 * @功能描述：
 * @创建人：FRUIT
 * @创建时间：2022/1/12 0:12
 * @修改备注
 * @修改记录： 修改时间 修改人员 修改原因
 * --------------------------------------------------
 */
public class SwingDemo3单行文本 {
    //Swing 中使用 JTextField 类实现一个单行文本框，它允许用户输入单行的文本信息。该类的常用构造方法如下。
    //
    //JTextField()：创建一个默认的文本框。
    //JTextField(String text)：创建一个指定初始化文本信息的文本框。
    //JTextField(int columns)：创建一个指定列数的文本框。
    //JTextField(String text,int columns)：创建一个既指定初始化文本信息，又指定列数的文本框。

    public static void main(String[] agrs)
    {

        //表1 JTextField类的常用方法 方法名称 	说明
        //Dimension getPreferredSize() 	获得文本框的首选大小
        //void scrollRectToVisible(Rectangle r) 	向左或向右滚动文本框中的内容
        //void setColumns(int columns) 	设置文本框最多可显示内容的列数
        //void setFont(Font f) 	设置文本框的字体
        //void setScrollOffset(int scrollOffset) 	设置文本框的滚动偏移量（以像素为单位）
        //void setHorizontalAlignment(int alignment) 	设置文本框内容的水平对齐方式


        JFrame frame=new JFrame("Java文本框组件示例");    //创建Frame窗口
        JPanel jp=new JPanel();    //创建面板
        JTextField txtfield1=new JTextField();    //创建文本框
        txtfield1.setText("普通文本框");    //设置文本框的内容
        JTextField txtfield2=new JTextField(28);
        txtfield2.setFont(new Font("楷体",Font.BOLD,16));    //修改字体样式
        txtfield2.setText("指定长度和字体的文本框");
        JTextField txtfield3=new JTextField(30);
        txtfield3.setText("居中对齐");
        txtfield3.setHorizontalAlignment(JTextField.CENTER);    //居中对齐
        jp.add(txtfield1);
        jp.add(txtfield2);
        jp.add(txtfield3);
        frame.add(jp);
        frame.setBounds(300,200,400,100);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

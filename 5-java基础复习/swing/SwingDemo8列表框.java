package swing;

import javax.swing.*;
import java.util.Vector;

/**
 * @version 1.0.0
 * @项目名称：
 * @类名称：
 * @类描述：
 * @功能描述：
 * @创建人：FRUIT
 * @创建时间：2022/1/12 0:32
 * @修改备注
 * @修改记录： 修改时间 修改人员 修改原因
 * --------------------------------------------------
 */
public class SwingDemo8列表框 {
    //列表框与下拉列表的区别不仅仅表现在外观上，当激活下拉列表时，会出现下拉列表框中的内容。但列表框只是在窗体系上占据固定的大小，如果需要列表框具有滚动效果，可以将列表框放到滚动面板中。当用户选择列表框中的某一项时，按住 Shift 键并选择列表框中的其他项目，可以连续选择两个选项之间的所有项目，也可以按住 Ctrl 键选择多个项目。
    //
    //Swing 中使用 JList 类来表示列表框，该类的常用构造方法如下。
    //
    //JList()：构造一个空的只读模型的列表框。
    //JList(ListModel dataModel)：根据指定的非 null 模型对象构造一个显示元素的列表框。
    //JList(Object[] listData)：使用 listData 指定的元素构造—个列表框。
    //JList(Vector<?> listData)：使用 listData 指定的元素构造一个列表框。
    //
    //
    //上述的第一个构造方法没有参数，使用此方法创建列表框后可以使用 setListData() 方法对列表框的元素进行填充，也可以调用其他形式的构造方法在初始化时对列表框的元素进行填充。常用的元素类型有 3 种，分别是数组、Vector 对象和 ListModel 模型。

    public static void main(String[] args)
    {
        JFrame frame=new JFrame("Java列表框组件示例");
        JPanel jp=new JPanel();    //创建面板
        JLabel label1=new JLabel("证件类型：");    //创建标签
        String[] items=new String[]{"身份证","驾驶证","军官证"};
        JList list=new JList(items);    //创建JList

        jp.add(label1);
        jp.add(list);
        frame.add(jp);
        frame.setBounds(300,200,400,100);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

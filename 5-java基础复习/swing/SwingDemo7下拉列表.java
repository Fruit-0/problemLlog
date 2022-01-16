package swing;

import javax.swing.*;

/**
 * @version 1.0.0
 * @项目名称：
 * @类名称：
 * @类描述：
 * @功能描述：
 * @创建人：FRUIT
 * @创建时间：2022/1/12 0:30
 * @修改备注
 * @修改记录： 修改时间 修改人员 修改原因
 * --------------------------------------------------
 */
public class SwingDemo7下拉列表 {

    //下拉列表的特点是将多个选项折叠在一起，只显示最前面的或被选中的一个。选择时需要单击下拉列表右边的下三角按钮，这时候会弹出包含所有选项的列表。用户可以在列表中进行选择，也可以根据需要直接输入所要的选项，还可以输入选项中没有的内容。
    //
    //下拉列表由 JComboBox 类实现，常用构造方法如下。
    //
    //JComboBox()：创建一个空的 JComboBox 对象。
    //JComboBox(ComboBoxModel aModel)：创建一个 JComboBox，其选项取自现有的 ComboBoxModel。
    //JComboBox(Object[] items)：创建包含指定数组中元素的 JComboBox。


    public static void main(String[] args)
    {


        //表1 JComboBox类的常用方法 方法名称 	说明
        //void addItem(Object anObject) 	将指定的对象作为选项添加到下拉列表框中
        //void insertItemAt(Object anObject,int index) 	在下拉列表框中的指定索引处插入项
        //void removeltem(0bject anObject) 	在下拉列表框中删除指定的对象项
        //void removeItemAt(int anlndex) 	在下拉列表框中删除指定位置的对象项
        //void removeAllItems() 	从下拉列表框中删除所有项
        //int getItemCount() 	返回下拉列表框中的项数
        //Object getItemAt(int index) 	获取指定索引的列表项，索引从 0 开始
        //int getSelectedIndex() 	获取当前选择的索引
        //Object getSelectedltem() 	获取当前选择的项


        JFrame frame=new JFrame("Java下拉列表组件示例");
        JPanel jp=new JPanel();    //创建面板
        JLabel label1=new JLabel("证件类型：");    //创建标签
        JComboBox cmb=new JComboBox();    //创建JComboBox
        cmb.addItem("--请选择--");    //向下拉列表中添加一项
        cmb.addItem("身份证");
        cmb.addItem("驾驶证");
        cmb.addItem("军官证");
        jp.add(label1);
        jp.add(cmb);
        frame.add(jp);
        frame.setBounds(300,200,400,100);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

package swing;

import javax.swing.*;
import javax.swing.colorchooser.ColorSelectionModel;
import java.awt.*;

/**
 * @version 1.0.0
 * @项目名称：
 * @类名称：
 * @类描述：
 * @功能描述：
 * @创建人：FRUIT
 * @创建时间：2022/1/12 1:11
 * @修改备注
 * @修改记录： 修改时间 修改人员 修改原因
 * --------------------------------------------------
 */
public class SwingDemo15颜色选择器 {
   /* 颜色选择器
    JColorChooser 类提供一个用于允许用户操作和选择颜色的控制器窗格。该类提供三个级别的 API：

    显示有模式颜色选取器对话框并返回用户所选颜色的静态便捷方法。
    创建颜色选取器对话框的静态方法，可以指定当用户单击其中一个对话框按钮时要调用的 ActionListener。
    能直接创建 JColorChooser 窗格的实例（在任何容器中），可以添加 PropertyChange 作为监听器以检测当前“颜色”属性的更改。


    颜色选择器的常用构造方法如下。

    JColorChooser()：创建初始颜色为白色的颜色选取器窗格。
    JColorChooser(Color initialColor)：创建具有指定初始颜色的颜色选取器窗格。
    JColorChooser(javax.swing.colorchooser.ColorSelectionModel model)：创建具有指定 ColorSelectionModel 颜色选取器窗格。


    一般使用 JColorChooser 类的静态方法 showDialog(Component component,String title,Color initialColor) 创建一个颜色对话框，在隐藏对话框之前一直堵塞进程。其中 component 参数指定对话框所依赖的组件，title 参数指定对话框的标题，initialColor 参数指定对话框返回的初始颜色，即对话框消失后返回的默认值。

    JColorChooser 类的其他常用方法如表 1 所示。

    表1 JColorChooser类的常用方法 方法名称 	说明
    getColor() 	获取颜色选取器的当前颜色值
    getDragEnabled() 	获取dragEnabled 属性的值
    setColor(Color color) 	将颜色选取器的当前颜色设置为指定颜色
    setColor(int c) 	将颜色选取器的当前颜色设置为指定颜色
    setColor(int r,int g,int b) 	将颜色选取器的当前颜色设置为指定的 RGB 颜色
    setDragEnabled(boolean b) 	设置 dragEnabled 属性，该属性必须为 true 才能启用对
    此组件的自动拖动处理（拖放操作的第一部分）*/

    public static void main(String[] args)
    {
        JFrame frame=new JFrame("颜色选择器");
        JColorChooser cc=new JColorChooser();
        JColorChooser.showDialog(frame,"颜色选择器", Color.white);
        //JColorChooser.showDialog(frame,"颜色选择器",Color.white);
        //设置窗口的关闭动作、标题、大小位置以及可见性等
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,100,400,200);
        frame.setVisible(true);



        //也可以不创建 JColorChooser 类实例，直接调用其 showDialog() 方法显示颜色选择器。即将如下代码
        //
        //JFrame frame=new JFrame("颜色选择器");
        //JColorChooser cc=new JColorChooser();
        //JColorChooser.showDialog(frame,"颜色选择器",Color.white);

    }
}

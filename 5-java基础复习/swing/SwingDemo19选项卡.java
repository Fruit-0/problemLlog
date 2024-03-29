package swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * @version 1.0.0
 * @项目名称：
 * @类名称：
 * @类描述：
 * @功能描述：
 * @创建人：FRUIT
 * @创建时间：2022/1/12 1:20
 * @修改备注
 * @修改记录： 修改时间 修改人员 修改原因
 * --------------------------------------------------
 */
public class SwingDemo19选项卡 extends JPanel{

  // javax.swing.JTabbedPane 类创建的选项卡可以通过单击标题或者图标在选项卡之间进行切换。JTabbedPane 类的常用构造方法如下所示。
  //
  // JTabbedPane()：创建一个具有默认 JTabbedPane.TOP 布局的空 TabbedPane。
  // JTabbedPane(int tabPlacement)：创建一个空的
  // TabbedPane，使其具有以下指定选项卡布局中的一种：JTabbedPane.TOP、JTabbedPane.BOTTOM、JTabbedPane.LEFT 或
  // JTabbedPane.RIGHT。
  //
  //
  // 创建了 JTabbedPane 实例之后，可使用 addTab() 方法和 insertTab() 方法将选项卡/组件添加到 TabbedPane
  // 对象中。选项卡通过对应于添加位置的索引来表示，其中第一个选项卡的索引为 0，最后一个选项卡的索引为选项卡数量减 1。
  //
  // TabbedPane 使用 SingleSelectionModel 属性来表示选项卡索引集和当前所选择的索引。如果选项卡数量大于
  // 0，则总会有一个被选定的索引，此索引默认被初始化为第一个选项卡；如果选项卡数量为 0，则所选择的索引为 -1。

  // JTabbedPane类的常用方法 方法名称 	说明
  // add(Component component,int index) 	在指定的选项卡索引位置添加一个 component，默认的选项卡
  //        标题为组件名称
  // addTab(String title, Component component) 	添加一个使用 title 作为标题，且没有图标的组件
  // getComponentAt(int index) 	返回 index 位置的组件
  // getSelectedComponent() 	返回此选项卡窗格当前选择的组件
  // getSelectedIndex() 	返回当前选择的此选项卡窗格的索引
  // getTabCount() 	返回此 tabbedPane 的选项卡数
  // insertTab(String title,Icon icon,Component component,
  //          String tip,int index) 	在 index 位置插入一个组件，该组件通过 title 或 icon（任意一个
  // 都可以为 null）来表示
  // isEnabledAt(int index) 	返回当前是否启用了 index 位置的选项卡
  // remove(int index) 	移除对应于指定索引的选项卡和组件
  // setEnabledAt(int index,boolean enabled) 	设置是否启用 index 位置的选项卡
  // setMnemonicAt(int tablndex,int mnemonic) 	设置用于访问指定选项卡的键盘助记符
  // setTitleAt(int index,String title) 	将 index 位置的标题设置为 title，它可以为 null
  // setToolTipTextAt(int index,String toolTipText) 	将 index 位置的工具提示文本设置为 toolTipText，它可以为 null

    public static void main(String[] args) {
        JFrame frame=new JFrame("我的电脑 - 属性");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new SwingDemo19选项卡(),BorderLayout.CENTER);
        setCenter(frame);//设置窗体大小600*800并居中
        frame.setVisible(true);
    }
    public SwingDemo19选项卡() {
        super(new GridLayout(1,1));
        JTabbedPane tabbedPane=new JTabbedPane();
        ImageIcon icon=createImageIcon("NEW.png");
        JComponent panel1=makeTextPanel("计算机名");
        tabbedPane.addTab("计算机名",icon, panel1,"Does nothing");
        tabbedPane.setMnemonicAt(0,KeyEvent.VK_1);
        JComponent panel2=makeTextPanel("硬件");
        tabbedPane.addTab("硬件",icon,panel2,"Does twice as much nothing");
        tabbedPane.setMnemonicAt(1,KeyEvent.VK_2);
        JComponent panel3=makeTextPanel("高级");
        tabbedPane.addTab("高级",icon,panel3,"Still does nothing");
        tabbedPane.setMnemonicAt(2,KeyEvent.VK_3);
        JComponent panel4=makeTextPanel("系统保护");
        panel4.setPreferredSize(new Dimension(410,50));
        tabbedPane.addTab("系统保护",icon,panel4,"Does nothing at all");
        tabbedPane.setMnemonicAt(3,KeyEvent.VK_4);
        add(tabbedPane);
    }
    protected JComponent makeTextPanel(String text){
        JPanel panel=new JPanel(false);
        JLabel filler=new JLabel(text);
        filler.setFont(new Font("宋体", 1, 50));
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1,1));
        panel.add(filler);
        return panel;
    }
    protected static ImageIcon createImageIcon(String path){
        java.net.URL imgURL=SwingDemo19选项卡.class.getResource(path);
        if(imgURL!=null){
            return new ImageIcon(imgURL);
        }
        else{
            System.err.println("Couldn't find file: "+path);
            return null;
        }
    }

    public static void setCenter(JFrame jf) {
        int screenWidth=Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight=Toolkit.getDefaultToolkit().getScreenSize().height;
        int jframeWidth = 800;
        int jframeHeight = 600;
        jf.setBounds((screenWidth/2)-(jframeWidth/2), (screenHeight/2)-(jframeHeight/2),
                jframeWidth, jframeHeight);
    }


}

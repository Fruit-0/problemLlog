package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author FRUIT
 * @version 1.0.0
 * @项目名称：用于自用的基础Swing工具类
 * @类名称：
 * @类描述：
 * @功能描述：
 * @创建人：FRUIT
 * @创建时间：2022/1/16 16:35
 * @修改备注
 * @修改记录： 修改时间 修改人员 修改原因
 * --------------------------------------------------
 */
public class FruitSwingUtils {

    /**
     * @Description: 根据当前显示器的屏幕尺寸属性，设置窗口的位置属性并构建一个简单的窗口对象
     * @Author: YX-WJ
     * @Date: 2022/1/12 23:49
     * @param JFrameName: 定义的窗口对象的名称
     * @param width: 窗口的宽（像素）,当传入0时，系统默认赋值 800
     * @param heigth: 窗口的高（像素）,当传入0时，系统默认赋值 600
     * @return: void
     **/
    public static JFrame buildNormalJFrame(String JFrameName, JPanel jPanel, int width, int heigth) {
        JFrame jFrame = new JFrame(JFrameName);
        //Toolkit是抽象类，不能使用new Toolkit() 创建实例化对象，须通过静态方法getDefaultToolkit() 来获取Toolkit对象
        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        //获取屏幕的大小。 在具有多个显示器的系统上，使用主显示器
        Dimension screenSize = defaultToolkit.getScreenSize();
        // 获取屏幕的宽
        int screenWidth = screenSize.width;
        //获取屏幕的高
        int screenHeight = screenSize.height;

        int jframeWidth = width==0?800:width;
        int jframeHeight = heigth==0?600:heigth;

        //x–该组件的新x坐标；y–该组件的新y坐标；width–该组件的新width；height–该组件的新height
        jFrame.setBounds((screenWidth/2)-(jframeWidth/2), (screenHeight/2)-(jframeHeight/2),
                jframeWidth, jframeHeight);

        //设置点击关闭按钮后，自动结束进程
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //在窗口中装载面板
        jFrame.add(jPanel, BorderLayout.CENTER);

        //jFrame.setVisible(true); 让JFrame对象显示出来，如果窗口是第一次显示，将事先初始化窗口显示的相关资源再显示。
        //setVisible(false)，将窗口隐藏，但窗口的相关资源仍然存在，dispose()可以将资源销毁。
        jFrame.setVisible(true);
        return jFrame;
    }


    /**
     * @Description: 简单整合菜单栏对象和窗体
     * @Author: YX-WJ
     * @Date: 2022/1/16 16:51
     * @param jFrame:
     * @param jMenuBar:
     * @return: javax.swing.JFrame
     **/
    public static JFrame addJMenuBar(JFrame jFrame,JMenuBar jMenuBar){

        jFrame.setJMenuBar(jMenuBar);


        return jFrame;
    }


    public static JPanel addJTabbedPane(JPanel jPanel, String path, String tabbedPaneName){
        //用一个指定的图标创建一个table页
        JTabbedPane tabbedPane=new JTabbedPane();
        ImageIcon imageIcon = createImageIcon(path);
        tabbedPane.addTab(tabbedPaneName,imageIcon, null,"Does nothing");

        JPanel panel=new JPanel(false);
        JLabel filler=new JLabel("第一个table页");
        filler.setFont(new Font("宋体", 1, 50));
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1,1));
        panel.add(filler);

        tabbedPane.add(panel);



        jPanel.add(tabbedPane);
        return jPanel;
    }



    /**
     * @Description: 根据list指定的结构，创建一个基础的，不带事件的菜单栏(只针对菜单栏的每个子选择项，最上级的jMenu任然需要手动创建)
     *
     * @Author: YX-WJ
     * @Date: 2022/1/16 17:27
     * @param jMenu: 要拓展结构树的菜单栏标签对象
     * @param jMenuTree:
     * @return: void
     **/
    public static JMenu setJMenuTree(JMenu jMenu,List jMenuTree){
        if (jMenuTree != null){
            for (int i = 0; i < jMenuTree.size(); i++) {
                String name = jMenuTree.get(i).getClass().getName();
                if (jMenuTree.get(i).getClass().getName().contains("String")){
                    JMenuItem jMenuItemSbu = new JMenuItem((String) jMenuTree.get(i));
                    jMenu.add(jMenuItemSbu);
                }else if (jMenuTree.get(i).getClass().getName().contains("Map")){


                    Map<String,Object> map = (HashMap<String,Object>) jMenuTree.get(i);

                    for (Map.Entry<String, Object> MapString : map.entrySet()) {
                        String key=MapString.getKey();
                        JMenu jMenuSub = new JMenu(key);
                        JMenuItem jMenuItemsub = new JMenuItem(key);

                        jMenu.add(jMenuItemsub);


                        List value=(List) MapString.getValue();
                        ButtonGroup directionGroup = new ButtonGroup();
            for (int j = 0; j < value.size(); j++) {
                JRadioButtonMenuItem forwardMenuItem = new JRadioButtonMenuItem("Forward", true);
                forwardMenuItem.setMnemonic(KeyEvent.VK_F);
                jMenuSub.add(forwardMenuItem);
                directionGroup.add(forwardMenuItem);
             //
            }
                        setJMenuTree(jMenu,value);
                    }

                }else {
                    throw new RuntimeException("菜单的树形结构异常，只能为string或者list");
                }
            }
        }else {
            throw new RuntimeException("菜单的树形结构不得为空");
        }
        return jMenu;
    }

    /**
     * @Description: 从项目的资源路径获取图片并创建图片对象，如果找不到返回空
     * @Author: YX-WJ
     * @Date: 2022/1/16 17:54
     * @param path:
     * @return: javax.swing.ImageIcon
     **/
    public static ImageIcon createImageIcon(String path){
        java.net.URL imgURL=FruitSwingUtils.class.getResource(path);
        if(imgURL!=null){
            return new ImageIcon(imgURL);
        }
        else{
            System.err.println("Couldn't find file: "+path);
            return null;
        }
    }


    protected static JComponent makeTextPanel(String text){
        JPanel panel=new JPanel(false);
        JLabel filler=new JLabel(text);
        filler.setFont(new Font("宋体", 1, 50));
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1,1));
        panel.add(filler);
        return panel;
    }


    /**
     * @Description: 设置一个装载了table页（卡片）的面板对象
     * @Author: YX-WJ
     * @Date: 2022/1/12 23:21

     * @return: javax.swing.JPanel     JPanel 面板 是一种中间层容器，它能容纳组件并将组件组合在一起，但它本身必须添加到其他容器中使用。
     **/
    private static JPanel getJPanel(JComponent jComponent){
        //创建 JPanel 面板的基本属性
        JPanel jPanel = new JPanel(true);
        //创建网格布局。 布局中的所有组件都具有相同的大小  rows–行，零值表示任意数量的行;cols–列，零值表示任意数量的列
        GridLayout gridLayout = new GridLayout(1, 1);
        //设置面板的基本布局属性
        jPanel.setLayout(gridLayout);
        //设置面板容器的字体
        jPanel.setFont(new Font("宋体", 1, 50));
        //设置面板容器的背景色
        jPanel.setBackground(Color.white);

        //装载组件
        jPanel.add(jComponent);
        return jPanel;
    }

/**
 * @Description: 选择文件并输出文件目录
 * @Author: YX-WJ
 * @Date: 2022/1/16 19:55

 * @return: java.lang.String
 **/
    public static String getFilePath() {
        JFileChooser jf = new JFileChooser();
        jf.setVisible(true);
        jf.setDialogTitle("选择文件");
        int result = jf.showOpenDialog(null);
        if (result == JFileChooser.CANCEL_OPTION) {
            return "没有选择文件";
        } else {
            String path = jf.getSelectedFile().getAbsolutePath();
            return path;
        }
    }








}

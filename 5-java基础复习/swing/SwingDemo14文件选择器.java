package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @version 1.0.0
 * @项目名称：
 * @类名称：
 * @类描述：
 * @功能描述：
 * @创建人：FRUIT
 * @创建时间：2022/1/12 1:07
 * @修改备注
 * @修改记录： 修改时间 修改人员 修改原因
 * --------------------------------------------------
 */
public class SwingDemo14文件选择器 {


    private JLabel label=new JLabel("所选文件路径：");
    private JTextField jtf=new JTextField(25);
    private JButton button=new JButton("浏览");
    public SwingDemo14文件选择器()
    {
        JFrame jf=new JFrame("文件选择器");
        JPanel panel=new JPanel();
        panel.add(label);
        panel.add(jtf);
        panel.add(button);
        jf.add(panel);
        jf.pack();    //自动调整大小
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button.addActionListener(new MyActionListener());    //监听按钮事件
    }
    //Action事件处理
    class MyActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent arg0)
        {
            JFileChooser fc=new JFileChooser("F:\\");
            int val=fc.showOpenDialog(null);    //文件打开对话框
            //int val=fc.showSaveDialog(null); //文件保存对话框
            //JFileChooser.APPROVE_OPTION
            if(val== JFileChooser.APPROVE_OPTION)
            {
                //正常选择文件
                jtf.setText(fc.getSelectedFile().toString());
            }
            else
            {
                //未正常选择文件，如选择取消按钮
                jtf.setText("未选择文件");
            }
        }
    }
    public static void main(String[] args)
    {
        new SwingDemo14文件选择器();
    }
}

package swing;

import javax.swing.*;

/**
 * @version 1.0.0
 * @项目名称：
 * @类名称：
 * @类描述：
 * @功能描述：
 * @创建人：FRUIT
 * @创建时间：2022/1/12 0:47
 * @修改备注
 * @修改记录： 修改时间 修改人员 修改原因
 * --------------------------------------------------
 */
public class Progress extends Thread
{
    JProgressBar progressBar;
    JButton button;
    //进度条上的数字
    int[] progressValues={6,18,27,39,51,66,81,100};
    Progress(JProgressBar progressBar, JButton button)
    {
        this.progressBar=progressBar;
        this.button=button;
    }
    @Override
    public void run()
    {
        for(int i=0;i<progressValues.length;i++)
        {
            try
            {
                Thread.sleep(3000);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
            //设置进度条的值
            progressBar.setValue(progressValues[i]);
        }
        progressBar.setIndeterminate(false);
        progressBar.setString("升级完成！");
        button.setEnabled(true);
    }
}



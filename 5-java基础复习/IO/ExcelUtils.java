package IO;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @version 1.0.0
 * @项目名称：
 * @类名称：
 * @类描述： 给老姐做的一个小工具
 * @功能描述：用于处理excel文件
 * @创建人：FRUIT
 * @创建时间：2022/1/9 18:38
 * @修改备注
 * @修改记录：
 *     修改时间 修改人员 修改原因 --------------------------------------------------
 */
public class ExcelUtils {
    
    public static void main(String[] args) throws Exception {
        // 创建一个JFrame对象
        JFrame jf = new JFrame("王星是个好同志");
        // 设置窗口大小和位置
        jf.setBounds(800, 400, 400, 200);
        // 设置背景色
        jf.setBackground(Color.white);
        
        // 文本标签
        // JLabel label = new JLabel("所选文件路径：");
        //// 文件选择标签
        // JTextField jtf = new JTextField(25);
        // 按钮
        JButton button = new JButton("开工开工！");
        
        // 创建面板
        JPanel panel = new JPanel();
        // 将标签添加到面板
        // panel.add(label);
        // 将标签添加到面板
        // panel.add(jtf);
        // 将标签添加到面板
        panel.add(button);
        // 将面板添加到窗口
        jf.add(panel);
        // 设置窗口可见
        jf.setVisible(true);
        // 关闭窗口后结束程序
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // 监听按钮事件
        button.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            doInCmd();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
    }
    
    /**
     * @Description: 在cmd窗口中运行 @Author: YX-WJ @Date: 2022/1/10 0:07
     *
     * @return: void
     */
    private static void doInCmd() throws Exception {
        // 文件选择器
        JFileChooser jfc = new JFileChooser();
        
        // 选择目录
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
        // 一个文件（也是默认的值）
        // jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        // 设置可选多个文件
        // jfc.setMultiSelectionEnabled(true);
        
        // JfileChooser.Cancel_Option:取消
        // JfileChooser.Approve_Option:打开
        // JfileChooser.Error_Option:发生错误
        if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            // 可单选也可多选
            String excelFilesPath = jfc.getSelectedFile().getPath();
            String txtPath = "";
            // 太快了老姐反应不过来
            Thread.sleep(1000);
            if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                
                txtPath = jfc.getSelectedFile().getPath();
            }
            
            String txtFileName =
                    txtPath + "\\" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "-数据.txt";
            dealExcels(excelFilesPath, txtFileName);
            
            //            遍历多选的文件
              /*            File[] selectedFiles = jfc.getSelectedFiles();
              for (File selectedFile : selectedFiles) {
                  System.out.println(selectedFile.getName());
              }*/
        } else {
            System.out.println("No file is selected!");
        }
    }
    
    /**
     * @param excelFilesPath:
     * @param txtPath: @Description: 处理文件夹中的所有excel @Author: YX-WJ @Date: 2022/1/9 23:12
     * @return: void
     */
    private static void dealExcels(String excelFilesPath, String txtPath) throws Exception {
        File excelirectory = new File(excelFilesPath);
        if (excelirectory.isDirectory()) {
            File[] files = excelirectory.listFiles();
            // 每次执行都重新创建txt文件
            if (new File(txtPath).exists()) {
                new File(txtPath).delete();
            }
            // 遍历excel文件夹下的文件
            for (File file : files) {
                if (file.isFile()) {
                    // 写数据
                    writeExcelInfoTxt(file.getPath(), txtPath);
                }
            }
        } else {
            throw new Exception("请指定一个文件夹");
        }
    }
    
    /**
     * @param excelPath:
     * @param txtPath: @Description: 读取excel的信息并写入txt @Author: YX-WJ @Date: 2022/1/9 22:47
     * @return: void
     */
    public static void writeExcelInfoTxt(String excelPath, String txtPath) throws Exception {
        
        // 要写入txt的内容
        String valueString = "";
        // txt文件中的基本内容(只有文件为空的时候才会进行写入基本内容操作)
        if (new File(txtPath).length() == 0) {
            String dateFormat = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            valueString +=
                    "[属性描述]\n"
                            + "格式版本号=\n"
                            + "数据产生单位=国土资源部\n"
                            + "数据产生日期="
                            + dateFormat
                            + "\n"
                            + "坐标系=2000国家大地坐标系\n"
                            + "几度分带=3\n"
                            + "投影类型=高斯克吕格\n"
                            + "计量单位=米\n"
                            + "带号=39\n"
                            + "精度=0.01\n"
                            + "转换参数=0,0,0,0,0,0,0\n"
                            + "[地块坐标]\n";
        }
        
        // 【宗地面积】和【总点数】要替换一次
        valueString += "【总点数】,【宗地面积】,1,2021-78地块1,面,H50G002051,工矿仓储用地,,@\n";
        
        DataFormatter dataFormatter = new DataFormatter();
        // 创建工作簿
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new FileInputStream(excelPath));
        // 读取第一个工作表(这里的下标与list一样的，从0开始取，row从1开始取，cell从0开始取)
        XSSFSheet sheet = xssfWorkbook.getSheetAt(0);
        
        // 【总点数】
        int biggestRowNum = 0;
        // 【宗地面积】txt中单位是平方千米，excel中单位是平方米，需要转换
        String arec = "";

        // 默认只检测前五行
        for (int i = 0; i < 5; i++) {
            XSSFRow row = sheet.getRow(i);
            String cellValue = dataFormatter.formatCellValue(row.getCell(0));
            if (cellValue.contains("宗地面积")) {
                arec = arec.replaceAll("[^0-9&^.]", "");
                // 保留小数点后4位，四舍五入
                arec =new BigDecimal(arec)
                        .divide(new BigDecimal(1000), 4, BigDecimal.ROUND_HALF_UP)
                        .toString();
                break;
            }
        }

        // 【第一个点的信息】
        String firstStringInfo = "";
        // 普通点的信息
        String normalpointinfo = "";
        
        // 点号
        String pointNo = "";
        // X坐标
        String Xvalue = "";
        // Y坐标
        String Yvalue = "";
        
        // 遍历sheet页中的所有行
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            // 获取当前行对象
            XSSFRow row = sheet.getRow(i);
            // 获取当前行的第一个单元格，用于判断一共有多少的 点
            XSSFCell cell = row.getCell(0);
            // A1 获取单元格坐标
            // String s = new CellReference(row.getRowNum(), cell.getColumnIndex()).formatAsString();
            // 单元格类型为number时，code为0，非0的数据是文本，没有取值意义
            int code = cell.getCellType().getCode();
            if (code == 0) {
                // 获取到单元格的值
                String cellValue = dataFormatter.formatCellValue(cell);
                int cellValueInt = Integer.parseInt(cellValue);
                // 对于非空的单元格，比较一下是不是最大的点数
                if (!"".equals(cellValue)) {
                    if (biggestRowNum < cellValueInt) {
                        // 更新最大点数
                        biggestRowNum = cellValueInt;
                        
                        // 点号
                        pointNo = dataFormatter.formatCellValue(row.getCell(1));
                        // x坐标
                        Xvalue = dataFormatter.formatCellValue(row.getCell(2));
                        // y坐标
                        Yvalue = dataFormatter.formatCellValue(row.getCell(3));
                        normalpointinfo = "" + pointNo + ",1," + Xvalue + "," + Yvalue + "\n";
                        
                        valueString += normalpointinfo;
                        // 如果是第一行，还需要记录下来用来写到末尾
                        if (biggestRowNum == 1) {
                            // 记录第一行的内容，用于写入txt的最后一行
                            if (biggestRowNum == 1) {
                                firstStringInfo = normalpointinfo;
                            }
                        }
                    }
                }
            }
        }
        // 将第一行的数据写在末尾
        valueString += firstStringInfo;
        // 【总点数】,【宗地面积】
        valueString = valueString.replace("【总点数】", String.valueOf(biggestRowNum));
        valueString = valueString.replace("【宗地面积】", arec);
        writeInfo(txtPath, valueString);
    }
    
    /**
     * @param txtFile2Output:
     * @param txtString:
     * @Description: 输出文件内容
     * @Author: YX-WJ
     * @Date: 2022/1/9 22:37
     * @return: void
     */
    private static void writeInfo(String txtFile2Output, String txtString) throws IOException {
        File file = new File(txtFile2Output);
        // 创建输出流
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        
        bufferedWriter.write(txtString);
        bufferedWriter.close();
    }
}

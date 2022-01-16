package IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 冲动火龙果
 * @version 1.0.0
 * @ClassName Test3FileCopy.java
 * @Description 同时使用InputStream和Outputstream实现文件的复制
 * @createTime 2021年04月11日 23:37:00
 */
public class Test3FileCopy {

    public static void main(String[] args) {
        String srcpath = "C:\\Users\\Administrator\\Desktop\\新建文件夹 (2)\\04 冒泡排序.png";
        String destpath = "C:\\Users\\Administrator\\Desktop\\新建文件夹 (2)\\88.png";
        copyFile(srcpath, destpath);
    }

    private static void copyFile(String srcpath, String destpath) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(srcpath);
            fos = new FileOutputStream(destpath);

            byte[] bytes = new byte[1024 * 10];
            int len = fis.read(bytes);
            while (len != -1) {
                fos.write(bytes);
                len = fis.read(bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

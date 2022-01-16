package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author 冲动火龙果
 * @version 1.0.0
 * @ClassName Test1.java
 * @Description TODO
 * @createTime 2021年04月06日 23:57:00
 */
public class Test1InputStream {
    static String path = "L:\\domyself\\要做.txt";

    public static void main(String[] args) throws Exception {
        //IO流完成操作的三大步骤:(1)创建流通道;(2)读写文件内容；（3）关闭流通道


        File file = new File(path);
        //创建字节流
        FileInputStream fileInputStream = new FileInputStream(file);

        //返回文件中的剩余可读字节数量（每次使用read方法，都会减少可读取字节的数量）
        System.out.println(fileInputStream.available());

        //文件中读取一个字节，返回读到的字节的ascII编码（读取不到返回-1）
        int read = fileInputStream.read();
        System.out.println("这是读取到的字符编码" + read);
        System.out.println("这是读取到的字符编码转义成字符" + (char) read);

        //重复使用read方法，会依次向后读取
        int read1 = fileInputStream.read();
        System.out.println("这是读取到的字符编码" + read1);
        System.out.println("这是读取到的字符编码转义成字符" + (char) read1);

        //返回文件中的可读字节数量（每次使用read方法，都会减少可读取字节的数量）
        System.out.println(fileInputStream.available());

        //可以使用skip方法，跳过指定的字节数量，该方法返回实际跳过的数量
        long skip = fileInputStream.skip(5);
        System.out.println(skip);

        int read2 = fileInputStream.read();
        System.out.println(((char) read2));


        //在IO流使用的最后，记得关闭IO流
        fileInputStream.close();
    }

    /**
     * 读取所有的文件内容，一般可以采用循环来实现
     *
     * @Author: 冲动火龙果
     * @Date: 2021/4/11 23:04
     * @return: void
     **/
    private void getAllInfo() throws IOException {
        File file = new File(path);
        FileInputStream fileInputStream = new FileInputStream(file);

        int i = fileInputStream.read();
        while (i != -1) {
            System.out.println(((char) i));
            i = fileInputStream.read();
        }

        //别忘了关闭字节流
        fileInputStream.close();
    }

    /**
     * 一次读取一个数组里面的内容，
     *
     * @Author: 冲动火龙果
     * @Date: 2021/4/11 23:17
     * @return: void
     **/
    private void getAllInfoByBety() throws IOException {
        File file = new File(path);
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] a = new byte[4];
        int read;
        do {
            read = fileInputStream.read(a);
            System.out.println(Arrays.toString(a));
        } while (read == -1);
        fileInputStream.close();


    }
}

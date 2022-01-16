package IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author 冲动火龙果
 * @version 1.0.0
 * @ClassName Test2OutputStream.java
 * @Description TODO
 * @createTime 2021年04月11日 23:28:00
 */
public class Test2OutputStream {

    private static String path = "L:\\domyself\\输出流测试.txt";

    public static void main(String[] args) throws IOException {
        testOutputSteam();
    }

    public static void testOutputSteam() throws IOException {

        File file = new File(path);
        FileOutputStream outputStream = new FileOutputStream(file);

        outputStream.write(97);
        outputStream.write(98);
        outputStream.write(99);

        byte [] b1 = "helloWord".getBytes();
        outputStream.write(b1,1,4);
        System.out.println(Arrays.toString(b1));

        outputStream.close();





    }



}

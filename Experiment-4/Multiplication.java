import java.io.FileWriter;
import java.io.IOException;

/**
 * 乘法表类
 *
 * @throws IOException
 * @version 1.0
 */
public class Multiplication {
    /** 结果 */
    private int result;

    /**
     * 设置结果
     *
     * @param resultInteger
     * @since 1.0
     * @version 1.0
     */
    public void setResult(int resultInteger) {
        result = resultInteger;
    }

    /**
     * 写入文件
     *
     * @throws IOException
     * @since 1.0
     * @version 1.0
     */
    public void writer() throws IOException {
        // FileWriter fw = new FileWriter("D:/data.txt");
        FileWriter fileWriter = new FileWriter("D:/data.txt");// 定义FileWriter类
        fileWriter.write(result);// 将结果写入D:\data.txt
        fileWriter.close();// 关闭FileWriter类
    }
}

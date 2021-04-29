import java.io.FileWriter;
import java.io.IOException;

public class Multiplication {
    private int result;

    public void setResult(int resultInteger) {
        result = resultInteger;
    }

    public void writer() throws IOException {
        // FileWriter fw = new FileWriter("D:/data.txt");
        FileWriter fileWriter = new FileWriter("D:/data.txt");// 定义FileWriter类
        fileWriter.write(result);// 将结果写入D:\data.txt
        fileWriter.close();// 关闭FileWriter类
    }
}

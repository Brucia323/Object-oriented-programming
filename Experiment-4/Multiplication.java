import java.io.FileWriter;
import java.io.IOException;

public class Multiplication {
    private int result;

    public void setResult(int resultInteger) {
        result = resultInteger;
    }

    public void writer() throws IOException {
        FileWriter fw = new FileWriter("D:/data.txt");
        fw.write(result);
        fw.close();
    }
}

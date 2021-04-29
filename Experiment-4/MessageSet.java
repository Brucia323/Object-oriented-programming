import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 将留言存入文件
 *
 * @param authorString
 * @param titleString
 * @param contentString
 * @version 1.0
 */
public class MessageSet {
    /** 作者 */
    private String author;
    /** 标题 */
    private String title;
    /** 内容 */
    private String content;
    /** 留言 */
    private String message;

    /**
     * MessageSet类的构造方法
     *
     * @param authorString
     * @param titleString
     * @param contentString
     * @version 1.0
     */
    public MessageSet(String authorString, String titleString, String contentString) {
        author = authorString;
        title = titleString;
        content = contentString;
    }

    /**
     * 将留言存入文件
     *
     * @throws IOException
     * @since 1.0
     * @version 1.0
     */
    public void messageSet() throws IOException {
        message = author + "&" + title + "&" + content + "\n";
        // RandomAccessFile rAccessFile= new RandomAccessFile("D:/message.txt", "rw");
        RandomAccessFile randomAccessFile = new RandomAccessFile("D:/message.txt", "rw");// 定义RandomAccessFile类，使用读写模式打开D:\message.txt文件
        randomAccessFile.seek(randomAccessFile.length());// 设定读写指针的位置，与文件开头相隔[文件包含的字节数]个字节数
        randomAccessFile.write(message.getBytes());// 将留言写入文件
        randomAccessFile.close();// 关闭RandomAccessFile类
    }
}

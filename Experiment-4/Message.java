import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.StringTokenizer;

/**
 * 读取留言
 *
 * @throws IOException
 * @version 1.0
 */
public class Message {
    /** 作者 */
    private String author;
    /** 标题 */
    private String title;
    /** 内容 */
    private String content;
    /** 留言 */
    private String message;
    /** 当前读写指针所处的位置 */
    private long filePointer;
    /** 文件包含的字节数 */
    private long fileLength;

    /**
     * 构造方法
     *
     * @throws IOException
     * @version 1.0
     */
    public Message() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("D:/message.txt", "r");// 定义RandomAccessFile类，使用只读模式打开D:\message.txt文件
        fileLength = randomAccessFile.length();
        randomAccessFile.close();// 关闭RandomAccessFile类
        filePointer = 0;
    }

    /**
     * 读取一条留言
     *
     * @return 是否有留言能够读取
     * @throws IOException
     * @since 1.0
     * @version 1.0
     */
    public boolean message() throws IOException {
        if (filePointer == fileLength) {
            return false;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile("D:/message.txt", "r");// 定义RandomAccessFile类，使用只读模式打开D:\message.txt文件
        randomAccessFile.seek(filePointer);// 设定读写指针的位置，与文件开头相隔[当前读写指针所处的位置]个字节数
        message = randomAccessFile.readLine();
        filePointer = randomAccessFile.getFilePointer();
        randomAccessFile.close();// 关闭RandomAccessFile类
        // StringTokenizer st = new StringTokenizer(message);
        StringTokenizer stringTokenizer = new StringTokenizer(message, "&");// 定义StringTokenizer类，使用"&"分隔符解析message
        author = stringTokenizer.nextToken();
        title = stringTokenizer.nextToken();
        content = stringTokenizer.nextToken();
        return true;
    }

    /**
     * 获取作者
     *
     * @return 作者
     * @since 1.0
     * @version 1.0
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 获取标题
     *
     * @return 标题
     * @since 1.0
     * @version 1.0
     */
    public String getTitle() {
        return title;
    }

    /**
     * 获取内容
     *
     * @return 内容
     * @since 1.0
     * @version 1.0
     */
    public String getContent() {
        return content;
    }
}

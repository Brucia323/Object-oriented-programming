import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.StringTokenizer;

/**
 * 读取留言
 *
 * @throws IOException
 * @version 2.1
 */
public class Message {
    /** 作者 */
    private String author;
    /** 标题 */
    private String title;
    /** 内容 */
    private String content;
    /** 留言 */
    private String messageString;
    /** 当前读写指针所处的位置 */
    private long filePointer, oldFilePointer = 0;

    /**
     * 读取一条留言
     *
     * @return 是否有留言能够读取
     * @throws IOException
     * @since 1.0
     * @version 1.3
     */
    public void read() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("message.txt", "r");// 定义RandomAccessFile类，使用只读模式打开D:\message.txt文件
        randomAccessFile.seek(filePointer);// 设定读写指针的位置，与文件开头相隔[当前读写指针所处的位置]个字节数
        messageString = new String(randomAccessFile.readLine().getBytes("ISO-8859-1"), "gbk");
        oldFilePointer = filePointer;
        filePointer = randomAccessFile.getFilePointer();
        if (randomAccessFile.getFilePointer() == randomAccessFile.length()) {
            filePointer = 0;
        }
        randomAccessFile.close();// 关闭RandomAccessFile类
        StringTokenizer stringTokenizer = new StringTokenizer(messageString, "&");// 定义StringTokenizer类，使用"&"分隔符解析message
        author = stringTokenizer.nextToken();
        title = stringTokenizer.nextToken();
        content = stringTokenizer.nextToken();
    }

    /**
     * 当用户点击显示时，修改读写指针，仍显示离开时的留言
     *
     * @since 2.1
     * @version 1.0
     */
    public void clickDisplay() {
        filePointer = oldFilePointer;
    }

    /**
     * 将留言存入文件
     *
     * @throws IOException
     * @since 2.0
     * @version 1.2
     */
    public void messageSet() throws IOException {
        messageString = author + "&" + title + "&" + content + "\n";
        RandomAccessFile randomAccessFile = new RandomAccessFile("message.txt", "rw");// 定义RandomAccessFile类，使用读写模式打开D:\message.txt文件
        randomAccessFile.seek(randomAccessFile.length());// 设定读写指针的位置，与文件开头相隔[文件包含的字节数]个字节数
        randomAccessFile.write(messageString.getBytes());// 将留言写入文件
        randomAccessFile.close();// 关闭RandomAccessFile类
    }

    /**
     * 输出作者
     *
     * @return 作者
     * @since 1.0
     * @version 1.0
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 输出标题
     *
     * @return 标题
     * @since 1.0
     * @version 1.0
     */
    public String getTitle() {
        return title;
    }

    /**
     * 输出内容
     *
     * @return 内容
     * @since 1.0
     * @version 1.0
     */
    public String getContent() {
        return content;
    }

    /**
     * 获取作者
     *
     * @param author
     * @since 2.0
     * @version 1.0
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 获取标题
     *
     * @param title
     * @since 2.0
     * @version 1.0
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取内容
     *
     * @param content
     * @since 2.0
     * @version 1.0
     */
    public void setContent(String content) {
        this.content = content;
    }
}

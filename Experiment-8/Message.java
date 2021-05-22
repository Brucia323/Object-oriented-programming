import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.StringTokenizer;

/**
 * ��ȡ����
 *
 * @throws IOException
 * @version 2.1
 */
public class Message {
    /** ���� */
    private String author;
    /** ���� */
    private String title;
    /** ���� */
    private String content;
    /** ���� */
    private String messageString;
    /** ��ǰ��дָ��������λ�� */
    private long filePointer, oldFilePointer = 0;

    /**
     * ��ȡһ������
     *
     * @return �Ƿ��������ܹ���ȡ
     * @throws IOException
     * @since 1.0
     * @version 1.3
     */
    public void read() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("message.txt", "r");// ����RandomAccessFile�࣬ʹ��ֻ��ģʽ��D:\message.txt�ļ�
        randomAccessFile.seek(filePointer);// �趨��дָ���λ�ã����ļ���ͷ���[��ǰ��дָ��������λ��]���ֽ���
        messageString = new String(randomAccessFile.readLine().getBytes("ISO-8859-1"), "gbk");
        oldFilePointer = filePointer;
        filePointer = randomAccessFile.getFilePointer();
        if (randomAccessFile.getFilePointer() == randomAccessFile.length()) {
            filePointer = 0;
        }
        randomAccessFile.close();// �ر�RandomAccessFile��
        StringTokenizer stringTokenizer = new StringTokenizer(messageString, "&");// ����StringTokenizer�࣬ʹ��"&"�ָ�������message
        author = stringTokenizer.nextToken();
        title = stringTokenizer.nextToken();
        content = stringTokenizer.nextToken();
    }

    /**
     * ���û������ʾʱ���޸Ķ�дָ�룬����ʾ�뿪ʱ������
     *
     * @since 2.1
     * @version 1.0
     */
    public void clickDisplay() {
        filePointer = oldFilePointer;
    }

    /**
     * �����Դ����ļ�
     *
     * @throws IOException
     * @since 2.0
     * @version 1.2
     */
    public void messageSet() throws IOException {
        messageString = author + "&" + title + "&" + content + "\n";
        RandomAccessFile randomAccessFile = new RandomAccessFile("message.txt", "rw");// ����RandomAccessFile�࣬ʹ�ö�дģʽ��D:\message.txt�ļ�
        randomAccessFile.seek(randomAccessFile.length());// �趨��дָ���λ�ã����ļ���ͷ���[�ļ��������ֽ���]���ֽ���
        randomAccessFile.write(messageString.getBytes());// ������д���ļ�
        randomAccessFile.close();// �ر�RandomAccessFile��
    }

    /**
     * �������
     *
     * @return ����
     * @since 1.0
     * @version 1.0
     */
    public String getAuthor() {
        return author;
    }

    /**
     * �������
     *
     * @return ����
     * @since 1.0
     * @version 1.0
     */
    public String getTitle() {
        return title;
    }

    /**
     * �������
     *
     * @return ����
     * @since 1.0
     * @version 1.0
     */
    public String getContent() {
        return content;
    }

    /**
     * ��ȡ����
     *
     * @param author
     * @since 2.0
     * @version 1.0
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * ��ȡ����
     *
     * @param title
     * @since 2.0
     * @version 1.0
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * ��ȡ����
     *
     * @param content
     * @since 2.0
     * @version 1.0
     */
    public void setContent(String content) {
        this.content = content;
    }
}

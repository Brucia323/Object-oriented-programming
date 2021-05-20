import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.StringTokenizer;

/**
 * ��ȡ����
 *
 * @throws IOException
 * @version 1.2
 */
public class Message {
    /** ���� */
    private String author;
    /** ���� */
    private String title;
    /** ���� */
    private String content;
    /** ���� */
    private String message;
    /** ��ǰ��дָ��������λ�� */
    private long filePointer;
    /** �ļ��������ֽ��� */
    private long fileLength;

    /**
     * ���췽��
     *
     * @throws IOException
     * @version 1.1
     */
    public Message() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("message.txt", "r");// ����RandomAccessFile�࣬ʹ��ֻ��ģʽ��D:\message.txt�ļ�
        fileLength = randomAccessFile.length();
        randomAccessFile.close();// �ر�RandomAccessFile��
        filePointer = 0;
    }

    /**
     * ��ȡһ������
     *
     * @return �Ƿ��������ܹ���ȡ
     * @throws IOException
     * @since 1.0
     * @version 1.2
     */
    public void message() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("message.txt", "r");// ����RandomAccessFile�࣬ʹ��ֻ��ģʽ��D:\message.txt�ļ�
        randomAccessFile.seek(filePointer);// �趨��дָ���λ�ã����ļ���ͷ���[��ǰ��дָ��������λ��]���ֽ���
        message = new String(randomAccessFile.readLine().getBytes("ISO-8859-1"),"gbk");
        filePointer = randomAccessFile.getFilePointer();
        randomAccessFile.close();// �ر�RandomAccessFile��
        StringTokenizer stringTokenizer = new StringTokenizer(message, "&");// ����StringTokenizer�࣬ʹ��"&"�ָ�������message
        author = stringTokenizer.nextToken();
        title = stringTokenizer.nextToken();
        content = stringTokenizer.nextToken();
    }

    /**
     * ��ȡ����
     *
     * @return ����
     * @since 1.0
     * @version 1.0
     */
    public String getAuthor() {
        return author;
    }

    /**
     * ��ȡ����
     *
     * @return ����
     * @since 1.0
     * @version 1.0
     */
    public String getTitle() {
        return title;
    }

    /**
     * ��ȡ����
     *
     * @return ����
     * @since 1.0
     * @version 1.0
     */
    public String getContent() {
        return content;
    }
}

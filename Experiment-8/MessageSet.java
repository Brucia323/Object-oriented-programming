import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * �����Դ����ļ�
 *
 * @param authorString
 * @param titleString
 * @param contentString
 * @version 1.0
 */
public class MessageSet {
    /** ���� */
    private String author;
    /** ���� */
    private String title;
    /** ���� */
    private String content;
    /** ���� */
    private String message;

    /**
     * MessageSet��Ĺ��췽��
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
     * �����Դ����ļ�
     *
     * @throws IOException
     * @since 1.0
     * @version 1.1
     */
    public void messageSet() throws IOException {
        message = author + "&" + title + "&" + content + "\n";
        RandomAccessFile randomAccessFile = new RandomAccessFile("message.txt", "rw");// ����RandomAccessFile�࣬ʹ�ö�дģʽ��D:\message.txt�ļ�
        randomAccessFile.seek(randomAccessFile.length());// �趨��дָ���λ�ã����ļ���ͷ���[�ļ��������ֽ���]���ֽ���
        randomAccessFile.write(message.getBytes());// ������д���ļ�
        randomAccessFile.close();// �ر�RandomAccessFile��
    }
}

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;

/**
 * ��¼
 *
 * @version 1.0
 */
public class Login {
    /** �û��� */
    private String userString, userString2;
    /** ���� */
    private String passwordString, passwordString2;

    /**
     * ���췽��
     *
     * @param userString
     * @param passwordString
     * @version 1.0
     */
    public Login(String userString, String passwordString) {
        this.userString = userString;
        this.passwordString = passwordString;
    }

    /**
     * ��¼��֤
     *
     * @return ��֤���
     * @throws UnsupportedEncodingException
     * @throws IOException
     * @version 1.0
     */
    public boolean verify() throws UnsupportedEncodingException, IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("user.txt", "r");
        while (randomAccessFile.getFilePointer() != randomAccessFile.length()) {
            userString2 = new String(randomAccessFile.readLine().getBytes("ISO-8859-1"), "gbk");
            passwordString2 = new String(randomAccessFile.readLine().getBytes("ISO-8859-1"), "gbk");
            if (userString.equals(userString2) && passwordString.equals(passwordString2)) {
                randomAccessFile.close();
                return true;
            }
        }
        randomAccessFile.close();
        return false;
    }
}

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;

/**
 * 用户
 *
 * @version 1.0
 */
public class User {
    /** 用户名 */
    private String userString, userString2;
    /** 密码 */
    private String passwordString, passwordString2;

    /**
     * 构造方法
     *
     * @param userString
     * @param passwordString
     */
    public User(String userString, String passwordString) {
        this.userString = userString;
        this.passwordString = passwordString;
    }

    /**
     * 用户登录验证
     *
     * @return 验证结果
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

    /**
     * 用户注册
     *
     * @return 注册结果
     * @throws IOException
     * @version 1.1
     */
    public boolean enroll() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("user.txt", "rw");
        while (randomAccessFile.getFilePointer() != randomAccessFile.length()) {
            userString2 = new String(randomAccessFile.readLine().getBytes("ISO-8859-1"), "gbk");
            if (userString.equals(userString2)) {
                randomAccessFile.close();
                return false;
            }
            randomAccessFile.readLine();
        }
        userString += "\n";
        passwordString += "\n";
        randomAccessFile.seek(randomAccessFile.length());
        randomAccessFile.write(userString.getBytes());
        randomAccessFile.write(passwordString.getBytes());
        randomAccessFile.close();
        return true;
    }

}

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 注册
 *
 * @version 1.1
 */
public class Enroll {
    /** 用户名 */
    private String userString, userString2;
    /** 密码 */
    private String passwordString;

    /**
     * 构造方法
     *
     * @param userString
     * @param passwordString
     * @version 1.1
     */
    public Enroll(String userString, String passwordString) {
        this.userString = userString;
        this.passwordString = passwordString;
    }

    /**
     * 注册
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

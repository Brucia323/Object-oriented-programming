import java.io.IOException;
import java.io.RandomAccessFile;

public class MessageSet {
    private String author;
    private String title;
    private String content;
    private String message;

    public MessageSet(String authorString, String titleString, String contentString) {
        author = authorString;
        title = titleString;
        content = contentString;
    }

    public void messageSet() throws IOException {
        message = author + "&" + title + "&" + content + "\n";
        // RandomAccessFile rAccessFile= new RandomAccessFile("D:/message.txt", "rw");
        RandomAccessFile randomAccessFile = new RandomAccessFile("D:/message.txt", "rw");
        randomAccessFile.seek(randomAccessFile.length());
        randomAccessFile.write(message.getBytes());
        randomAccessFile.close();
    }
}

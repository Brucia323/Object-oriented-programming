import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 留言板
 *
 * @param args
 * @author 周晨阳
 * @version 1.0
 */
public class Liuyan {
    /**
     * 主方法
     *
     * @param args
     * @version 1.0
     */
    public static void main(String[] args) {
        System.out.println("*****Welcome to use Message Board*****");
        System.out.println("Please Enter Your Order:");
        // InputStreamReader reader = new InputStreamReader(System.in);
        // BufferedReader reader2 = new BufferedReader(reader);
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);// 使用System.in定义InputStreamReader类
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);// 使用inputStreamReader定义BufferedReader类
        String order;// 定义指令
        try {
            while ((order = bufferedReader.readLine()) != null) {
                if (order.equals("add")) {
                    System.out.println("Enter Message's author:");
                    String author = bufferedReader.readLine();// 定义作者
                    System.out.println("Enter Message's title:");
                    String title = bufferedReader.readLine();// 定义标题
                    System.out.println("Enter Message's content:");
                    String content = bufferedReader.readLine();// 定义内容
                    MessageSet messageSet = new MessageSet(author, title, content);// 使用author,title,content定义MessageSet类
                    messageSet.messageSet();
                    System.out.println("留言成功！");
                    System.out.println("*****************************");
                }
                if (order.equals("display")) {
                    System.out.println("*****************************");
                    int messageNumber = 1;// 定义留言编号，默认值为1
                    Message message = new Message();// 定义Message类
                    while (message.message()) {
                        System.out.println("Message" + messageNumber + ":");
                        System.out.println("author:" + message.getAuthor());
                        System.out.println("title:" + message.getTitle());
                        System.out.println("content:" + message.getContent());
                        messageNumber = messageNumber + 1;
                    }
                    System.out.println("*****************************");
                }
                if (order.equals("quit")) {
                    System.out.println("Thanks for using.");
                    break;
                }
                System.out.println("Please Enter Your Order:");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

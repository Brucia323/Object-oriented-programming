import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Liuyan {
    public static void main(String[] args) {
        System.out.println("*****Welcome to use Message Board*****");
        System.out.println("Please Enter Your Order:");
        // InputStreamReader reader = new InputStreamReader(System.in);
        // BufferedReader reader2 = new BufferedReader(reader);
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String order;
        try {
            while ((order = bufferedReader.readLine()) != null) {
                if (order.equals("add")) {
                    System.out.println("Enter Message's author:");
                    String author = bufferedReader.readLine();
                    System.out.println("Enter Message's title:");
                    String title = bufferedReader.readLine();
                    System.out.println("Enter Message's content:");
                    String content = bufferedReader.readLine();
                    MessageSet messageSet = new MessageSet(author, title, content);
                    messageSet.messageSet();
                    System.out.println("留言成功！");
                    System.out.println("*****************************");
                }
                if (order.equals("display")) {
                    System.out.println("*****************************");
                    int messageNumber = 1;
                    Message message = new Message();
                    while (message.message()) {
                        System.out.println("Message" + messageNumber + ":");
                        System.out.println("author:" + message.getAuthor());
                        System.out.println("title:" + message.getTitle());
                        System.out.println("content:" + message.getContent());
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

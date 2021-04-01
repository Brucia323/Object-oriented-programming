import java.util.Scanner;

public class BoxFactory {
    public static void main(String[] args) {
        int length = 0, width = 0, height = 0;
        System.out.print("请输入盒子的规格：");
        Scanner scanner = new Scanner(System.in);// 从键盘接收数据
        // 判断是否还有输入
        if (scanner.hasNext()) {
            length = scanner.nextInt();
            width = scanner.nextInt();
            height = scanner.nextInt();
        }
        scanner.close();
        Configuration configuration = new Configuration(length, width, height);
        Box box = Box.getBox();// 获取唯一可用的对象
        box.getVolume();// 显示体积
    }
}

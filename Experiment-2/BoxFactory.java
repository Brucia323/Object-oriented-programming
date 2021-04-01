import java.util.Scanner;

public class BoxFactory {
    public static void main(String[] args) {
        int length = 0, width = 0, height = 0;
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            length = scanner.nextInt();
            width = scanner.nextInt();
            height = scanner.nextInt();
        }
        scanner.close();
        Configuration configuration = new Configuration(length, width, height);
        Box box = Box.getBox();
        box.getVolume();
    }
}

public class Configuration {

    private static int length;// 长
    private static int width;// 宽
    private static int height;// 高

    public Configuration(int length, int width, int height) {
        Configuration.length = length;
        Configuration.width = width;
        Configuration.height = height;
    }

    public static int getVolume() {
        return length * width * height;
    }
}

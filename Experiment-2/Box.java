public class Box {
    private static Box box = new Box();

    private Box() {
    }

    public static Box getBox() {
        return box;
    }

    public void getVolume() {
        System.out.println(Configuration.getVolume());
    }
}

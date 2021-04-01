public class Box {
    private static Box box = new Box();// 创建Box的一个对象

    // 让构造方法为private，这样该类就不会被实例化
    private Box() {
    }

    // 获取唯一可用的对象
    public static Box getBox() {
        return box;
    }

    public void getVolume() {
        System.out.println(Configuration.getVolume());
    }
}

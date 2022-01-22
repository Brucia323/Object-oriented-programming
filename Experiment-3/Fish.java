public class Fish extends Aquatilia {
    private String color;// 颜色
    private String size;// 大小
    private String info;// 其它

    public void setColor(String colorString) {
        color = colorString;
    }

    public String getColor() {
        return color;
    }

    public void setSize(String sizeString) {
        size = sizeString;
    }

    public String getSize() {
        return size;
    }

    public void setInfo(String infoString) {
        info = infoString;
    }

    public String getInfo() {
        return info;
    }

    @Override
    public void swim() {
        System.out.println("游泳");
    }
}

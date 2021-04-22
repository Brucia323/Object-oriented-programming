public class Order extends Clothes,Trousers{
    private String sex;// 性别：男/女
    private String color;// 颜色
    private String size;// 尺码

    public String getColor() {
        return color;
    }

    public String getSex() {
        return sex;
    }

    public String getSize() {
        return size;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void getClothes(String sexString, String colorString, String sizeString) {
        super.getClothes(String sexString,String colorString,String sizeString);

    }

    public void getTrousers(String sexString,String colorString,String sizeString) {
        super.getTrousers(STring sexString,String colorString,String sizeString);
}}

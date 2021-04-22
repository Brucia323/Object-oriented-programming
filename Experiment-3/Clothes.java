public class Clothes implements Producible{
    public void getClothes(String sexString, String colorString, String sizeString) {
        System.out.println("这是一件" + colorString + "色的" + sizeString + "码" + sexString + "性衣服");
    }
}

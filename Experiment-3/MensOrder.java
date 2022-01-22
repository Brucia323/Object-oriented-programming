public class MensOrder extends Order {

    @Override
    public Clothes createClothes() {
        return new MensClothes();
    }

    @Override
    public Trousers createTrousers() {
        return new MensTrousers();
    }

}

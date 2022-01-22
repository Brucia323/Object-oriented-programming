public class WomensOrder extends Order {

    @Override
    public Clothes createClothes() {
        return new WomensClothes();
    }

    @Override
    public Trousers createTrousers() {
        return new WomensTrousers();
    }

}

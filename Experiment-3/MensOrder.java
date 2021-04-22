public class MensOrder extends Order {

    @Override
    public Clothes createClothes() {
        // TODO Auto-generated method stub
        return new MensClothes();
    }

    @Override
    public Trousers createTrousers() {
        // TODO Auto-generated method stub
        return new MensTrousers();
    }

}

public class WomensOrder extends Order {

    @Override
    public Clothes createClothes() {
        // TODO Auto-generated method stub
        return new WomensClothes();
    }

    @Override
    public Trousers createTrousers() {
        // TODO Auto-generated method stub
        return new WomensTrousers();
    }

}

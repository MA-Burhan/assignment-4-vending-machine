package se.lexicon.amin;

public class Drinks extends Product {

    private int volume;

    public Drinks(int productID, String name, int price, double calories, int volume) {
        super(productID, name, price, calories);
        this.volume = volume;
    }

    public String consume() {
        //System.out.println("Drinking");
        return "Drinking";
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "Type: Drink \n" + "Volume: " + volume + " cl \n";
    }

}

package se.lexicon.amin;

public class Drinks extends Product {

    private int volume;

    public Drinks(String name, int price, double calories, int volume) {
        super(name, price, calories);
        this.volume = volume;
    }

    public String consume() {
        //System.out.println("Drinking");
        return "Drinking " + getName();
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "Type: Drink \n" + "Volume: " + volume + " cl \n";
    }

    public int getVolume() {
        return volume;
    }
}

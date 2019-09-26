package se.lexicon.amin;

public class Sweets extends Product {

    private boolean isHardCandy;

    public Sweets(String name, int price, double calories, boolean isHardCandy) {
        super(name, price, calories);
        this.isHardCandy = isHardCandy;
    }

    public String consume() {
        //System.out.println("Eating");
        return "Enjoying " + getName();
    }
    @Override
    public String getDescription() {
        return super.getDescription() + "Type: Sweets \n" + "Type of candy: " + (isHardCandy ? "Hard candy" : "Soft candy") + "\n";
    }

    public boolean isHardCandy() {
        return isHardCandy;
    }
}

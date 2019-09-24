package se.lexicon.amin;

public class Sweets extends Product {

    private boolean isHardCandy;

    public Sweets(int productID, String name, int price, double calories, boolean isHardCandy) {
        super(productID, name, price, calories);
        this.isHardCandy = isHardCandy;
    }

    public String consume() {
        //System.out.println("Eating");
        return "Eating";
    }
    @Override
    public String getDescription() {
        return super.getDescription() + "Type: Sweets \n" + "Type of candy: " + (isHardCandy ? "Hard candy" : "Soft candy") + "\n";
    }


}

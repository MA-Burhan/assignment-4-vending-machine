package se.lexicon.amin;

public class fruits extends Product {

    private boolean isOrganic;

    public fruits(int productID, String name, int price, double calories, boolean isOrganic) {
        super(productID, name, price, calories);
        this.isOrganic = isOrganic;
    }

    public String consume() {
        //System.out.println("Eating");
        return "Eating";
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "Type: Fruit \n" + "Organic: " + (isOrganic ? "yes" : "no") + "\n";
    }


}

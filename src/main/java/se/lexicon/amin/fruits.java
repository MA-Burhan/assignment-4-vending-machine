package se.lexicon.amin;

public class fruits extends Product {

    private boolean isOrganic;

    public fruits(String name, int price, double calories, boolean isOrganic) {
        super(name, price, calories);
        this.isOrganic = isOrganic;
    }

    public String consume() {
        //System.out.println("Eating");
        return "Eating " + getName();
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "Type: Fruit \n" + "Organic: " + (isOrganic ? "Yes" : "No") + "\n";
    }

    public boolean isOrganic() {
        return isOrganic;
    }
}

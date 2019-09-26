package se.lexicon.amin;

public class Food extends Product {

    private boolean isVegetarian;

    public Food(String name, int price, double calories, boolean isVegetarian) {
        super(name, price, calories);
        this.isVegetarian = isVegetarian;
    }

    public String consume() {
        //System.out.println("Eating");
        return "Eating " + getName();
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "Type: Food \n" + "Vegetarian: " + (isVegetarian ? "Yes" : "No") + "\n";
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }
}

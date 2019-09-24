package se.lexicon.amin;

public class Food extends Product {

    private boolean isVegetarian;

    public Food(int productID, String name, int price, double calories, boolean isVegetarian) {
        super(productID, name, price, calories);
        this.isVegetarian = isVegetarian;
    }

    public String consume() {
        //System.out.println("Eating");
        return "Eating";
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "Type: Food \n" + "Vegetarian " + (isVegetarian ? "yes" : "no") + "\n";
    }

}

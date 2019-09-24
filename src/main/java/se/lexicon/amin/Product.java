package se.lexicon.amin;

import java.util.ArrayList;

public abstract class Product {

    protected int productNumber;
    protected String name;
    protected int price;
    protected double calories;
    protected ArrayList<String> allergens;

    public Product(int productNumber,String name, int price, double calories) {
        this.productNumber = productNumber;
        this.name = name;
        this.price = price;
        this.calories = calories;
        this.allergens = new ArrayList<>();
    }

    public boolean addAllergens(String allergen) {
        if (this.allergens.contains(allergen)) {
            //System.out.println("allergen already in the list");
            return false;
        }
        this.allergens.add(allergen);
        return true;
    }


    public String getDescription() {
        return ("ID: " + productNumber + "\n" +
                "Name: " + name + "\n" +
                "Price: " + price + " kr \n" +
                "Calories: " + calories + " kcal \n" +
                "Allergens: " + (allergens.isEmpty() ? "No allergens" : allergens) + "\n");
    }


    public int getProductNumber() { return productNumber; }

    public String getName() {
        return name;
    }

    public int getPrice() { return price; }

    protected abstract String consume();



    public ArrayList<String> getAllergens() {
        return allergens;
    }


}


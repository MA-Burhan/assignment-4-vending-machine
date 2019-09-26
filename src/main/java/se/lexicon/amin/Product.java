package se.lexicon.amin;

import java.util.ArrayList;

public abstract class Product {

    private static int idCounter = 1;

    private int productNumber;
    private String name;
    private int price;
    private double calories;
    private ArrayList<String> allergens;


    public Product(String name, int price, double calories) {
        this.productNumber = idCounter++;
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
                "Allergens: " + (allergens.isEmpty() ? "No allergens" : allergens.toString()) + "\n");
    }


    public int getProductNumber() { return productNumber; }

    public String getName() {
        return name;
    }

    public int getPrice() { return price; }

    public double getCalories() {
        return calories;
    }

    protected abstract String consume();



    public ArrayList<String> getAllergens() {
        return allergens;
    }


}


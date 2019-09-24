package se.lexicon.amin;

import java.util.ArrayList;
import java.util.Arrays;

public class VendingMachine implements IVendingMachine{

    private int id;
    private String location;
    private ArrayList<Product> products;
    private int[] acceptedAmounts = {1, 5, 10, 20, 50, 100, 500, 1000};
    private int depositPool = 0;

    public VendingMachine(int id, String location) {
        this.id = id;
        this.location = location;
        this.products = new ArrayList<Product>();
    }

    public void initVendingMachine() {
        //Initialize vending machine with some products
        products.add(new Drinks(21,"Coca-Cola", 15, 250.0, 50));
        products.add(new Sweets(42,"Gott & Blandat", 22, 450.32, false));
        products.add(new Food(5,"Kyckling macka", 45, 632.3, false));
        products.add(new fruits(2,"Äpple", 8, 45, true));
        //add allergen to one product
        products.get(2).addAllergens("Lactose");
    }

    public void addProduct (Product prod) {
        products.add(prod);
    }

    public void addCurrency (int amount) {

        if (isAcceptableCurrency(amount)) {
            depositPool += amount;
           // System.out.println(amount + "kr have been added.");
        }

        //System.out.println("Not a valid amount. Nothing have been added.");
    }

    private boolean isAcceptableCurrency(int amountToDeposit) {
        for (int element : acceptedAmounts) {
            if (element == amountToDeposit) {
                return true;
            }
        }
        return false;
    }

    public Product request(int productNumber) {
        if (products.isEmpty()) {
            //System.out.println("There is currently no products in this Vending Machine");
            return null;
        }
        for (Product prod : this.products) {
            if (prod.getProductNumber() == productNumber) {
                if (depositPool >= prod.getPrice()) {
                    //System.out.println("You bought product: " + prod.getName() + " for " + prod.getPrice() + " kr");
                    depositPool -= prod.getPrice();
                    return prod;
                } else {
                    //System.out.println("You don't have enough money.");
                    return null;
                }

            }
        }
        //System.out.println(("No product with that product ID exists in this Vending Machine"));
        return null;
    }

    public int endSession() {
        int change = depositPool;
        depositPool = 0;
        //System.out.println("You received " + change + " kr back.");
        return change;
    }

    public String getDescription (int productNumber) {

        if (products.isEmpty()) {
           // System.out.println("There is currently no products in this Vending Machine");
            return null;
        }

        for (Product prod : this.products) {
            if (prod.getProductNumber() == productNumber) {
                //System.out.println(prod.getDescription());
                return prod.getDescription();
            }
        }

        //System.out.println("Product with that Number does not exist");
        return null;
    }

    public int getBalance() {
        //System.out.println("You have " + depositPool + " kr left.");
        return depositPool;
    };

    public ArrayList<String> getProducts() {
        if (products.isEmpty()) {
            //System.out.println("There is currently no products in this Vending Machine");
            return null;
        }
        ArrayList<String> stringArray = new ArrayList<>();
        for (Product prod : this.products) {
            stringArray.add(prod.getProductNumber() + " - " + prod.getName());
        }
        //System.out.println(stringArray);
        return stringArray;
    };

}

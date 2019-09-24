package se.lexicon.amin;

import java.util.ArrayList;

public interface IVendingMachine {

    //add to the deposit pool (money pool)
    void addCurrency(int amount);

    //buy a product
    Product request (int productNumber);

    //returns change and resets the depositpool
    int endSession();

    //View a product description
    String getDescription (int productNumber);

    //returns the deposit pool amount
    int getBalance();

    //returns all Products names and product numbers;
    ArrayList<String> getProducts();


}

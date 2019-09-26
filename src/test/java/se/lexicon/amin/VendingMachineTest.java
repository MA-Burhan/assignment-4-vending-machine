package se.lexicon.amin;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class VendingMachineTest {

    private VendingMachine testVM;
    private Drinks testDrink;
    private Sweets testSweet;
    private Food testFood;
    private fruits testFruit;

    @Before
    public void setup() {
        testVM = new VendingMachine( "Uppsala Station");

        //Initialize vending machine with some products
        testDrink = new Drinks("Coca-Cola", 15, 250.0, 50);
        testSweet = new Sweets("Gott & Blandat", 22, 450.32, false);
        testFood = new Food("Kyckling macka", 45, 632.3, false);
        testFruit = new fruits("Äpple", 8, 45, true);


        testVM.addProduct(testDrink);
        testVM.addProduct(testSweet);
        testVM.addProduct(testFood);
        testVM.addProduct(testFruit);

        //add allergen to one product
        testVM.getProductsFull().get(2).addAllergens("Lactose");
        testVM.getProductsFull().get(2).addAllergens("Gluten");
    }

    @Test
    public void testAddInvalidAmount() {
        //Arrange
        //Act
        testVM.addCurrency(43);
        int actualResult = testVM.getBalance();
        int expectedResult = 0;
        //Assert
        assertEquals(expectedResult, actualResult, 0);
    }

    @Test
    public void testAddValidAmount() {
        //Arrange
        //Act
        testVM.addCurrency(100);
        int actualResult = testVM.getBalance();
        int expectedResult = 100;
        //Assert
        assertEquals(expectedResult, actualResult, 0);
    }

    @Test
    public void testReturnOfChange() {
        //Arrange
        //Act
        testVM.addCurrency(100);

        testVM.request(testSweet.getProductNumber());


        int actualResult = testVM.endSession();
        int expectedResult = 78;
        //Assert
        assertEquals(expectedResult, actualResult, 0);
    }

    @Test
    public void testBuyProductWithInsufficientFunds() {
        //Arrange
        testVM.addCurrency(10);
        //Act
        //Assert
        assertNull(testVM.request(testDrink.getProductNumber()));
    }

    @Test
    public void testBuyProductWithSufficientFunds() {
        //Arrange
        testVM.addCurrency(50);
        //Act
        int actualResult = testVM.request(testFood.getProductNumber()).getProductNumber();
        int expedtedResult = testFood.getProductNumber();

        //Assert
        assertEquals(expedtedResult, actualResult, 0);
    }


    @Test
    public void testBuyProductThatDoesNotExist() {
        //Arrange
        testVM.addCurrency(500);
        //Act

        //Assert
        assertNull(testVM.request(18756));
    }

    @Test
    public void testBuySeveralProductsAndGetChangeBack() {
        //Arrange
        testVM.addCurrency(500);
        //Act
        Product purchasedProduct1 = testVM.request(testFruit.getProductNumber());
        Product purchasedProduct2 = testVM.request(testSweet.getProductNumber());

        int changeBack = testVM.endSession();
        int expectedChangeBack = 470;

        //Assert
        assertEquals(purchasedProduct1.getProductNumber(), testFruit.getProductNumber(), 0);
        assertEquals(purchasedProduct2.getProductNumber(), testSweet.getProductNumber(), 0);
        assertEquals(changeBack, expectedChangeBack);

    }


    @Test
    public void testGetDescription() {
        //Arrange
        //Act
        String description = testVM.getDescription(testFood.getProductNumber());

        //Assert
        assertTrue(description.contains(testFood.getName()));
        assertTrue(description.contains(Integer.toString(testFood.getPrice())));
        assertTrue(description.contains(Double.toString(testFood.getCalories())));
        assertTrue(description.contains( (testFood.getAllergens().isEmpty() ? "No allergens" : testFood.getAllergens().toString()) ));
        assertTrue(description.contains((testFood.isVegetarian() ? "Yes" : "No")));

    }

    @Test
    public void testGetProducts() {
        //Arrange

        //Act
        String product1 = testVM.getProducts().get(0); //testDrink
        String product2 = testVM.getProducts().get(1); //testSweet
        String product3 = testVM.getProducts().get(2); //TestFood
        String product4 = testVM.getProducts().get(3); //TestFruit

        //Assert
        assertTrue(product1.contains(testDrink.getName()));
        assertTrue(product1.contains(Integer.toString(testDrink.getProductNumber())));

        assertTrue(product2.contains(testSweet.getName()));
        assertTrue(product2.contains(Integer.toString(testSweet.getProductNumber())));

        assertTrue(product3.contains(testFood.getName()));
        assertTrue(product3.contains(Integer.toString(testFood.getProductNumber())));

        assertTrue(product4.contains(testFruit.getName()));
        assertTrue(product4.contains(Integer.toString(testFruit.getProductNumber())));
    }

    @Test

    public void testConsume() {
        //Arrange

        //Act

        //Assert
        assertTrue(testDrink.consume().contains("Drinking"));
        assertTrue(testDrink.consume().contains(testDrink.getName()));

    }




}

package se.lexicon.amin;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class VendingMachineTest {

    private VendingMachine testVM;

    @Before
    public void setup() {
        testVM = new VendingMachine(18283, "Uppsala Station");
       // testVM.initVendingMachine();
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
        testVM.addCurrency(10);
        int actualResult = testVM.endSession();
        int expectedResult = 10;
        //Assert
        assertEquals(expectedResult, actualResult, 0);
    }

    @Test
    public void testBuyProductWithInsufficientFunds() {
        //Arrange
        testVM.addProduct(new Food(143, "Pizza", 55, 532, false));
        testVM.addCurrency(10);
        //Act
        //Assert
        assertNull(testVM.request(143));
    }

    @Test
    public void testBuyProductWithSufficientFunds() {
        //Arrange
        testVM.addProduct(new Drinks(143, "Fanta", 16, 215, 50));
        testVM.addCurrency(20);
        //Act
        int actualResult = testVM.request(143).getProductNumber();
        int expedtedResult = 143;

        //Assert
        assertEquals(expedtedResult, actualResult, 0);
    }


    @Test
    public void testBuyProductThatDoesNotExist() {
        //Arrange
        testVM.addProduct(new fruits(112, "Apelsin", 12, 54, true));
        testVM.addCurrency(500);
        //Act

        //Assert
        assertNull(testVM.request(156));
    }

    @Test
    public void testGetDescription() {
        //Arrange
        testVM.addProduct(new Sweets(342, "Tutti Frutti", 23, 432, false));
        testVM.addCurrency(100);

        //Act
        String description = testVM.getDescription(342);

        //Assert
        assertNotNull(description);
    }

    @Test
    public void testGetProducts() {
        //Arrange
        testVM.addProduct(new Sweets(342, "Tutti Frutti", 23, 432, false));
        testVM.addCurrency(100);

        //Act
        ArrayList<String> productInfo = testVM.getProducts();

        //Assert
        assertNotNull(productInfo);
    }




}

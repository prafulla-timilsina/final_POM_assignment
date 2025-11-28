package tests;

import base.Base;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class InventoryTests extends Base {

    @Test
    public void sortAndAddToCart() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventory = new InventoryPage(driver);
        inventory.sortByNameDescending();
        inventory.sortByPriceLowToHigh();
        inventory.addBackpackToCart();
        inventory.addBikeLightToCart();
        inventory.goToCart();
    }
}

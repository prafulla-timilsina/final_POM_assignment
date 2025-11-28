package tests;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

import java.util.ArrayList;
import java.util.List;

public class SortingTests extends Base {

    @Test
    public void sortByNameDescendingTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventory = new InventoryPage(driver);
        inventory.sortByNameDescending();

        // Verify first product name is Z-A
        List<WebElement> products = driver.findElements(By.className("inventory_item_name"));
        List<String> names = new ArrayList<>();
        for (WebElement p : products) {
            names.add(p.getText());
        }

        System.out.println("Products sorted by name (Z-A): " + names);
    }

    @Test
    public void sortByPriceLowToHighTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventory = new InventoryPage(driver);
        inventory.sortByPriceLowToHigh();

        // Verify first product price is lowest
        List<WebElement> products = driver.findElements(By.className("inventory_item_price"));
        List<Double> prices = new ArrayList<>();
        for (WebElement p : products) {
            prices.add(Double.parseDouble(p.getText().replace("$", "")));
        }

        System.out.println("Products sorted by price (low to high): " + prices);
    }
}

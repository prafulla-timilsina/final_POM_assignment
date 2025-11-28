package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage {
    private WebDriver driver;

    private By sortDropdown = By.className("product_sort_container");
    private By addBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private By addBikeLight = By.id("add-to-cart-sauce-labs-bike-light");
    private By cartIcon = By.className("shopping_cart_link");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void sortByNameDescending() {
        Select select = new Select(driver.findElement(sortDropdown));
        select.selectByVisibleText("Name (Z to A)");
    }

    public void sortByPriceLowToHigh() {
        Select select = new Select(driver.findElement(sortDropdown));
        select.selectByVisibleText("Price (low to high)");
    }

    public void addBackpackToCart() {
        driver.findElement(addBackpack).click();
    }

    public void addBikeLightToCart() {
        driver.findElement(addBikeLight).click();
    }

    public void goToCart() {
        driver.findElement(cartIcon).click();
    }
}

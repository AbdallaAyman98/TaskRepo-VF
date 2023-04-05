package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage {

    private WebDriver driver;
    private By addToBasketBtn = By.className("addToBasket-btn");
    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public ShoppingCartPage clickAddToBasket(){
        click(addToBasketBtn, driver);
        return new ShoppingCartPage(driver);
    }
}

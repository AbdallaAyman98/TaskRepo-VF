package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BasePage {

    private WebDriver driver;
    private By proceedToCheckOutBtn = By.xpath("//button[@class=\"btn btn-red\"]");
    public ShoppingCartPage(WebDriver driver) {
        this.driver =driver;
    }

    public CheckOutPage proceedToCheckOut(){
        click(proceedToCheckOutBtn, driver);
        return new CheckOutPage(driver);
    }


}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    private WebDriver driver;
    //locating elements in Homepage
    private By language = By.className("lang"); // xpath: //span[@class="lang"]
    private By appleIcon = By.xpath("(//*[@id=\"shopByBrandCard\"])[7]");
    private By closeCookiesAlert = By.xpath("/html/body/app-root/div/app-cookie/div/div/p/i");
    private By resultItem = By.xpath("(//a[@class=\"productList-cardLink\"])[1]");


    public HomePage(WebDriver driver){
            this.driver = driver;
        }

    public HomePage changeLanguage(){
        click(language,driver);
        return this;
    }
    public ProductDetailsPage selectProductItem(){
        click(closeCookiesAlert,driver)
                .click(appleIcon,driver).click(resultItem,driver);
        return new ProductDetailsPage(driver);
    }

}

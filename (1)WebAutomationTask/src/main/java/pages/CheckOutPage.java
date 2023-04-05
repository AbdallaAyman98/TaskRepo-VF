package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage extends BasePage {
    private WebDriver driver;
    private By cityList = By.xpath("//*[@id=\"headingOne\"]/div[1]/select");
    private By districtList = By.xpath("//*[@id=\"headingOne\"]/div[2]/select");
    private By deliverToMyAddressBtn = By.className("checkout-DelivaryOptionsRes");
    private By streetNameField = By.xpath("//*[@placeholder=\"Street Name\"]");
    private By buildingNoField = By.xpath("(//*[@placeholder=\"196\"])[1]");
    private By floorNoField = By.xpath("(//*[@placeholder=\"196\"])[2]");
    private By appartmentNoField = By.xpath("(//*[@placeholder=\"196\"])[3]");
    private By landMarkField = By.xpath("//*[@placeholder=\"Landmark\"]");
    private By addressNameField = By.xpath("//*[@placeholder=\"Address Name\"]");
    private By continueBtn = By.xpath("//*[@id=\"checkout-deliveryAdd\"]/div[3]/button");
    private By shippingAddressContinueBtn = By.id("shippingAddressContinue");
    private By fullNameAlertText = By.xpath("//*[@id=\"collapseTwo\"]/form/div/div/div[1]/div[1]/app-alert/div/div/div/div[2]/div/div/div");
    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }

    public CheckOutPage setDeliveryOptions(String city, String district){
        selectFromList(cityList, city,driver)
                .selectFromList(districtList,district,driver)
                .click(deliverToMyAddressBtn, driver);
        return this;
    }
    public CheckOutPage setAddressDetails(){
        sendKeys("StreetName", streetNameField,driver)
                .sendKeys("152", buildingNoField, driver)
                .sendKeys("2", floorNoField, driver)
                .sendKeys("5", appartmentNoField, driver)
                .sendKeys("Landmark", landMarkField, driver)
                .sendKeys("Address Name", addressNameField, driver)
                .click(continueBtn, driver);
        return this;
    }

    public CheckOutPage clickContinue(){
        click(shippingAddressContinueBtn, driver);
        return this;
    }

    public String getAlertText(){
        return getText(fullNameAlertText, driver);
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    private WebDriverWait driverWait;

    private void waitForElementToAppear(By by, WebDriver driver){
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    protected BasePage hoverOver(By by, WebDriver driver){
        waitForElementToAppear(by,driver);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(by)).perform();
        return this;
    }
    protected BasePage selectFromList(By by, String keyword, WebDriver driver){
        waitForElementToAppear(by,driver);
        Select city = new Select(driver.findElement(by));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        city.selectByVisibleText(keyword);
        return this;
    }
    private void waitForElementToBeClickable(By by,WebDriver driver){
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driverWait.until(ExpectedConditions.elementToBeClickable(by));
    }
    protected BasePage click(By by, WebDriver driver){
        waitForElementToBeClickable(by,driver);
        driver.findElement(by).click();
        return this;
    }
    protected BasePage sendKeys(String string, By by, WebDriver driver){
        waitForElementToAppear(by,driver);
        driver.findElement(by).sendKeys(string);
        return this;
    }

    protected String getText(By by, WebDriver driver){
        waitForElementToAppear(by,driver);
        return driver.findElement(by).getText();
    }

}

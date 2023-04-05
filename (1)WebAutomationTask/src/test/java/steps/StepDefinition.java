package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import pages.CheckOutPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import tests.BaseTest;

public class StepDefinition extends BaseTest {
    @Given("user is on Shop Homepage")
    public void user_is_on_shop_homepage()
    {
        Assert.assertEquals(driver.getCurrentUrl(),"https://eshop.vodafone.com.eg/shop/home");
    }
    @When("user selects language as English")
    public void user_selects_language_as_english() {
        HomePage homePage = new HomePage(driver);
        homePage.changeLanguage();

    }
    @And("user goes to Brand section and selects Apple")
    public void user_goes_to_brand_section_and_selects_Apple() {
        HomePage homePage = new HomePage(driver);
        homePage.selectProductItem();

    }
    @And("user adds an Apple item to basket and proceeds to checkout")
    public void user_adds_an_apple_item_to_basket_and_proceeds_to_checkout() {
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        productDetailsPage.clickAddToBasket().proceedToCheckOut();
    }
    @And("user selects the delivery options")
    public void user_selects_the_delivery_options() {
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.setDeliveryOptions("Cairo","Ain Shams");
    }
    @And("user adds the address details and presses continue")
    public void user_adds_the_address_details_and_presses_continue() {
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.setAddressDetails();
    }
    @And("user leaves personal info tab empty and presses continue")
    public void user_leaves_personal_info_tab_empty_and_presses_continue() {
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.clickContinue();
    }
    @Then("Error message is returned from Fullname Field")
    public void error_message_is_returned_from_fullname_field() {
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        String actual = checkOutPage.getAlertText();
        Assert.assertEquals(actual, "Please enter a valid name");
    }
}

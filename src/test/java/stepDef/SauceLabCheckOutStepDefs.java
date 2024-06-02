package stepDef;

import com.selenium.automation.saucelabDemo.pages.CartPage;
import com.selenium.automation.saucelabDemo.pages.CheckoutPage;
import com.selenium.automation.saucelabDemo.pages.LoginPage;
import com.selenium.automation.saucelabDemo.pages.ProductSelectPage;
import com.selenium.automation.saucelabDemo.utilities.LogUtil;
import com.selenium.automation.saucelabDemo.utilities.Page;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java8.En;
import org.junit.Assert;

import java.io.IOException;

public class SauceLabCheckOutStepDefs extends Page implements En {
    LoginPage loginPage = new LoginPage();
    ProductSelectPage productSelectPage = new ProductSelectPage();
    CartPage cartPage = new CartPage();
    CheckoutPage checkoutPage = new CheckoutPage();

    public SauceLabCheckOutStepDefs() throws IOException {
    }

    @After
    public void tearDown() {

        try {
            driver.quit();
        } catch (Exception e) {
            LogUtil.logger.info("Exception in tearDown {}", e.getMessage());
        }
    }

    @Given("^Login into \"([^\"]*)\"$")
    public void login_into(String url) throws Throwable {
        Assert.assertTrue("Unable to login successfully: ", loginPage.login(url));
    }

    @When("^User select following products$")
    public void productSelection(DataTable table) throws IOException {
        Assert.assertTrue("Unable to select the products : ", productSelectPage.selectingProducts(table));
    }

    @Then("User click on {string}")
    public void userClickOn(String button) {
        Assert.assertTrue("Clicked on " + button + "Successfully", productSelectPage.clickOnButtons(button));
    }

    @And("Verify the following products")
    public void verifyTheFollowingProducts(DataTable table) throws IOException {
        Assert.assertTrue("Expected Product list not matches with checkout page ", cartPage.verifyProducts(table));
    }


    @When("^User enters (.*) (.*) (.*)$")
    public void userEnters(String fn, String ln, String postalCode) throws IOException {
        Assert.assertTrue("Value is not entered in FirstName, LastName and Postal code", checkoutPage.InputDetails(fn, ln, postalCode));
    }
}

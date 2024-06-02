package com.selenium.automation.saucelabDemo.pages;
import com.selenium.automation.saucelabDemo.utilities.Page;
import com.selenium.automation.saucelabDemo.utilities.ReusableMethods;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
@Slf4j
public class CheckoutPage extends Page {
        public static Logger logger = LoggerFactory.getLogger(CheckoutPage.class);
    Elements elements = new Elements();
    ReusableMethods reusableMethods = new ReusableMethods();

    public CheckoutPage() throws IOException {
    }

    /**
     * @param fn
     * @param ln
     * @param postalCode
     * @return
     * @throws IOException
     */
    public boolean InputDetails(String fn, String ln, String postalCode) throws IOException {
        boolean status = true;
        try {
            reusableMethods.enterValue(elements.FName_Checkout, fn);
            reusableMethods.enterValue(elements.LName_Checkout, ln);
            reusableMethods.enterValue(elements.PostalCode_Checkout, postalCode);
        } catch (Exception e) {
            logger.info("Element Not Found : {}", e.getMessage());
            status = false;
        }

        return status;
    }

    class Elements {
        @FindBy(xpath = "//div[@class='inventory_item_name']")
        List<WebElement> productListInCart;
        @FindBy(xpath = "//input[@data-test='firstName']")
        WebElement FName_Checkout;
        @FindBy(xpath = "//input[@data-test='lastName']")
        WebElement LName_Checkout;
        @FindBy(xpath = "//input[@data-test='postalCode']")
        WebElement PostalCode_Checkout;
        Elements() {
            PageFactory.initElements(driver, this);
        }

    }
}


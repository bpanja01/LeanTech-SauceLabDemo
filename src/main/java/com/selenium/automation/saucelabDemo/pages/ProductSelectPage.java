package com.selenium.automation.saucelabDemo.pages;
import com.selenium.automation.saucelabDemo.utilities.LogUtil;
import com.selenium.automation.saucelabDemo.utilities.Page;
import com.selenium.automation.saucelabDemo.utilities.ReusableMethods;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class ProductSelectPage extends Page {
    Elements elements = new Elements();
    ReusableMethods reusableMethods = new ReusableMethods();
    public ProductSelectPage() throws IOException {
    }

    /**
     *
     * @param tableVal
     * @return
     * @throws IOException
     */
    public boolean selectingProducts(DataTable tableVal) throws IOException {
       boolean status = true;
        try {
            List<List<String>> rows = tableVal.asLists(String.class);
            for (List<String> row : rows) {
                for (String columns : row) {
                    LogUtil.logger.info("Product needs to be selected : {}", columns);
                    WebElement SelectProduct = driver.findElement(By.xpath("//div[text()='" + columns + "']/../../following-sibling::div/button[text()='ADD TO CART']"));
                    reusableMethods.clickElement(SelectProduct);
                }
                break;
            }
        }
        catch (Exception e) {
            LogUtil.logger.info("Exception in selectingProducts : {}", e.getMessage());
            status = false;
        }
        return status;
    }

    /**
     *
     * @param buttonToClick
     * @return
     */
    public boolean clickOnButtons(String buttonToClick)
    {
        boolean status=true;
        String buttonToClick1 = buttonToClick.replace("\"","");
        try{
            switch (buttonToClick1.trim().toUpperCase())
            {
                case "CART":  {reusableMethods.waitUntilElementIsVisible(elements.cart);
                    reusableMethods.clickElementWithActionClass(elements.cart);
                    LogUtil.logger.info("Cart clicked");
                break;}
                case "CHECKOUT": {
                    reusableMethods.waitUntilElementIsVisible(elements.checkout);
                    elements.checkout.click();
                    LogUtil.logger.info("Checkout clicked");
                    break;
                }
                case "FINISH": {
                    reusableMethods.waitUntilElementIsVisible(elements.Finish);
                    elements.Finish.click();
                    LogUtil.logger.info("Finish clicked");
                    break;
                }
                case "CONTINUE": {
                    reusableMethods.waitUntilElementIsVisible(elements.Continue);
                    reusableMethods.clickElementWithActionClass(elements.Continue);
                    LogUtil.logger.info("Continue clicked");
                    break;
                }
            }
        }
        catch (Exception e){
            status=false;
        }
        return status;
    }

    static class Elements {
        Elements() {
            PageFactory.initElements(driver, this);
        }

        @FindBy(xpath = "//div[text()='\" + columns + \"']/../../following-sibling::div/button[text()='ADD TO CART']")
        WebElement product;


        @FindBy(xpath = "//div[@id='shopping_cart_container']/a")
        WebElement cart;

        @FindBy(xpath = " //a[@class='btn_action checkout_button']")
        WebElement checkout;
        @FindBy(xpath = " //a[@class='btn_action cart_button']")
        WebElement Finish;
        @FindBy(xpath = " //input[@class='btn_primary cart_button']")
        WebElement Continue;

    }
}

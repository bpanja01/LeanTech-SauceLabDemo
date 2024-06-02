package com.selenium.automation.saucelabDemo.utilities;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.IOException;
import java.time.Duration;

public class ReusableMethods extends Page {
    public ReusableMethods() throws IOException {
    }

    Actions ac = new Actions(driver);

    /**
     *
     * @param element
     */
    public void clickElement(WebElement element) {
        try {
            waitUntilElementIsVisible(element);
            element.click();
        }
        catch (NoSuchElementException e) {
            LogUtil.logger.info("Exception in clickElement {}", e.getMessage());
        }

    }

    /**
     *
     * @param element
     */
    public void clickElementWithActionClass(WebElement element) {
        try {
            waitUntilElementIsVisible(element);
            ac.moveToElement(element).click(element).build().perform();
        }
        catch (NoSuchElementException e) {
            LogUtil.logger.info("Exception in clickElementWithActionClass {}", e.getMessage());
        }
    }

    /**
     *
     * @param element
     */
    public void waitUntilElementIsVisible(WebElement element) {
        try {
            FluentWait<WebDriver> ft = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(60)).pollingEvery(Duration.ofMillis(200)).ignoring(NoSuchElementException.class);
            ft.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            LogUtil.logger.info("Exception in waitUntilElementIsVisible {}", e.getMessage());
        }
    }

    /**
     *
     * @param element
     * @param value
     */
    public void enterValue(WebElement element, String value) {
        try {
            waitUntilElementIsVisible(element);
            element.sendKeys(value);
        }
        catch (Exception e) {
            LogUtil.logger.info("Exception in enterValue {}", e.getMessage());
        }

    }

    /**
     *
     * @param element
     * @param value
     */
    public void enterValueWithActionClass(WebElement element, String value) {
        try{
            waitUntilElementIsVisible(element);
            ac.moveToElement(element).sendKeys(value).build().perform();
        }
        catch (Exception e) {
            LogUtil.logger.info("Exception in enterValueWithActionClass {}", e.getMessage());
        }

    }

}

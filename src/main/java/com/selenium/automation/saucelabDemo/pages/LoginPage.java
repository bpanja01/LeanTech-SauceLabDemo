package com.selenium.automation.saucelabDemo.pages;
import com.selenium.automation.saucelabDemo.utilities.LogUtil;
import com.selenium.automation.saucelabDemo.utilities.Page;
import com.selenium.automation.saucelabDemo.utilities.ReusableMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage extends Page {

    public ReusableMethods reusableMethods = new ReusableMethods();
    Elements elements = new Elements();

    public LoginPage() throws IOException {
    }

    /**
     *
     * @param url
     * @return
     * @throws IOException
     */
    public boolean login(String url) throws IOException {
        boolean status = true;
        try {
            launchUrl(url);
            reusableMethods.enterValue(elements.UserName, props.getProperty("userName"));
            reusableMethods.enterValue(elements.Password, props.getProperty("password"));
            reusableMethods.clickElement(elements.LoginButton);
            LogUtil.logger.info("Entered Login Page");
        }
        catch (Exception e) {
            LogUtil.logger.info("Element Not Found : {}", e.getMessage());
            status = false;
        }
        return status;

    }
    static class Elements {
     Elements() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='user-name']")
    WebElement UserName;
    @FindBy(xpath = "//input[@data-test='password']")
    WebElement Password;

    @FindBy(xpath = "//input[@id='login-button']")
    WebElement LoginButton;
}}

package com.selenium.automation.saucelabDemo.utilities;

import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Page extends WebDriverUtils {
    public Page() throws IOException {
        super();
        driver = getDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        Page.driver = driver;
    }
}

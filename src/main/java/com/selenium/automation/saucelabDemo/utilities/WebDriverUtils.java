package com.selenium.automation.saucelabDemo.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.Properties;

public class WebDriverUtils extends FileReaderUtils {
static String filePath = "src/main/resources/Config.properties";
    public static Properties props;
    public static WebDriver driver;

    /**
     *
     * @throws IOException
     */
    public WebDriverUtils() throws IOException {
        try {
            if (driver == null) {
                props = PropertiesFileReader(filePath);
                String browser = props.getProperty("browser");


                if (browser.equalsIgnoreCase("chrome")) {

                    System.setProperty("chrome.driver", System.getProperty("user.dir")+props.getProperty("driverPath"));
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();

                }
            }
        }
        catch (Exception e) {
            LogUtil.logger.info("Exception in WebDriverUtils : {}", e.getMessage());
        }
    }

    /**
     *
     * @param Url
     * @throws IOException
     */
    public static void launchUrl(String Url) throws IOException {
        try {
            String url = props.getProperty(Url);
            driver.get(url);
            LogUtil.logger.info("launchUrl : {}", url);
        }
        catch (Exception e) {
            LogUtil.logger.info("Exception in launchUrl : {}", e.getMessage());
        }
    }
}

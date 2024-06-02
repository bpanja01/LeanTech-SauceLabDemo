package com.selenium.automation.saucelabDemo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileReaderUtils {
    static Properties prop;

    /**
     *
     * @param filePath
     * @return
     * @throws IOException
     */
    public static Properties PropertiesFileReader(String filePath) throws IOException {
        prop = new Properties();
        FileInputStream reader;
        reader = new FileInputStream(filePath);
        prop.load(reader);
        return prop;
    }
}



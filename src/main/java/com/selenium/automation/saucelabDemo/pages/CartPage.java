package com.selenium.automation.saucelabDemo.pages;

import com.selenium.automation.saucelabDemo.utilities.Page;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartPage extends Page {

    Elements elements = new Elements();

    public CartPage() throws IOException {
    }

    /**
     * @param tableVal
     * @return
     * @throws IOException
     */
    public boolean verifyProducts(DataTable tableVal) throws IOException {
        HashMap<Integer, String> itemAdded = new HashMap<>();

        HashMap<Integer, String> itemProvided = new HashMap<>();


        List<Map<Integer, String>> rows = Collections.singletonList(tableVal.asMap(Integer.class, String.class));
        Map<Integer, String> row = rows.get(0);
        int i = 1;
        for (WebElement ele : elements.productListInCart) {

            itemAdded.put(i, ele.getText().toUpperCase());
            i++;
        }
        return row.equals(itemAdded);
    }

    static class Elements {
        @FindBy(xpath = "//div[@class='inventory_item_name']")
        List<WebElement> productListInCart;

        Elements() {
            PageFactory.initElements(driver, this);
        }


    }
}

package PracticeAutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.PageBase;

import java.util.ArrayList;
import java.util.List;

public class ResultsPage extends PageBase

{
    @FindBy(xpath = "//ul[contains(@class, 'product_list')]/li")
    private List<WebElement> searchList;

    public ResultsPage(WebDriver driver)

    {
        super(driver);
        waitforURLToContains("authentication&back=my-account");

    }

    public List<String> getSavedProducts() {
        List<String> productsNames = new ArrayList<String>();
        if (searchList.size() == 0)
            return productsNames;

        waitForElementsToBeVisible(searchList);

        for (WebElement products : searchList) {
            productsNames.add(products.getText());
        }

        return productsNames;

    }

}
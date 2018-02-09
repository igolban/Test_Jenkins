package PracticeAutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.PageBase;

public class HomePage extends PageBase

{   @FindBy(id="search_query_top")
    private WebElement searchFieldInput;
    @FindBy(name="submit_search")
    private WebElement searchButton;
    @FindBy(xpath = "//li[@class = 'facebook']/a")
    private WebElement facebookLink;

    public HomePage(WebDriver driver)
    {
        super(driver);
        waitforURLToContains("controller=my-account");

    }

    public void clickFacebook()
    {
        waitForElementToBeVisible(facebookLink);
        facebookLink.click();

    }

    public ResultsPage searchItem ( String keyword)
    { waitForElementToBeVisible(searchFieldInput);
        searchFieldInput.sendKeys(keyword);
        searchButton.click();
        return new ResultsPage(driver);
    }





}

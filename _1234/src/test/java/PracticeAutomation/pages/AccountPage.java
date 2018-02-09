package PracticeAutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.PageBase;



public class AccountPage extends PageBase {

    @FindBy(xpath = "//*[@class='account']/span")
    private WebElement accountName;

    public AccountPage(WebDriver driver)

    { super(driver);
        waitforURLToContains("controller=my-account");

    }

    public String getAccountName()
    {
        waitForElementToBeVisible(accountName);
        return accountName.getText();
    }

}

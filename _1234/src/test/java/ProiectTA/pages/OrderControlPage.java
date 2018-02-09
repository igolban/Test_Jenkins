package ProiectTA.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.PageBase;


public class OrderControlPage extends PageBase

{

    @FindBy(xpath="//*[@id=\"center_column\"]/p[2]/a[1]")
    private WebElement proceedWithCheckOutButtonOrderPage;
    @FindBy(xpath="//h1[@id='cart_title']")
    private WebElement textShoppingCardSummary;

    public OrderControlPage(WebDriver driver)

    {
        super(driver);
        waitforURLToContains("controller=order");

    }


    public SignInPage clickProceedToCheckoutSignInPage()

    {
        waitForElementToBeVisible(proceedWithCheckOutButtonOrderPage);
        proceedWithCheckOutButtonOrderPage.click();
        return new SignInPage(driver);
    }




}

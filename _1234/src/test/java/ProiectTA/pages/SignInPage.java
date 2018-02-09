package ProiectTA.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.PageBase;

public class SignInPage extends PageBase

{
    @FindBy(xpath = "//*[@id='order_step']/li[2]/span")
    private WebElement selectedSignInTab;

    public SignInPage(WebDriver driver)
    {
        super(driver);
        waitforURLToContains("controller=authentication");
    }


}

package PracticeAutomation.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.PageBase;

public class LoginPage extends PageBase

{    @FindBy(id="email")
     private WebElement emailInput;
     @FindBy(id="passwd")
     private WebElement passwordInput;
     @FindBy(id="SubmitLogin")
     private WebElement signInButton;


     public LoginPage(WebDriver driver)

     { super(driver);
       waitforURLToContains("authentication&back=my-account");

     }

     public AccountPage loginAs( String email, String password)
     { waitForElementToBeVisible(emailInput);
         emailInput.sendKeys(email);
         passwordInput.sendKeys(password);
         signInButton.click();

       return new AccountPage(driver);
     }

}

package phptravels.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.PageBase;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class AccountPage extends PageBase


{

    @FindBy(xpath = ".//*[@id='body-section']/div/div[1]/div/div[1]/h3")
    private WebElement userName;
    @FindBy(name = "country")
    private WebElement countryInput;
    @FindBy(name = "city")
    private WebElement cityInput;
    @FindBy(className = "RTL")
    private WebElement greetMessage;
    @FindBy(className = "profile-icon")
    private WebElement myProfile;
    @FindBy(xpath = ".//div[text()='Profile Updated Successfully.']")
    private WebElement successMessage;
    @FindBy(xpath = ".//*[@id='profilefrm']/div/div[3]/div[2]/div[6]/div[2]/select/option[158]")
    private WebElement countrySelection;
    @FindBy(xpath = "html/body/div[3]/div/div/div[2]/ul/ul/li[1]/a")
    private WebElement accountName;
    @FindBy(xpath = "html/body/div[3]/div/div/div[2]/ul/ul/li[1]/ul/li[2]/a")
    private WebElement logOut;
    @FindBy(xpath = "//button[contains(@class,'loginbtn')]")
    private WebElement loginButton;

    public AccountPage(WebDriver driver) {

        super(driver);

        waitforURLToContains("/account"); //adaug cod pentru verificarea de url.


    }


    public String getGreetingMessages() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(visibilityOf(greetMessage));
        return greetMessage.getText();
    }

    public String getUserName() {
        wait.until(visibilityOf(userName));
        return userName.getText();
    }

    public AccountPage modifyLocation(String city, String country)

    {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(visibilityOf(greetMessage));
        myProfile.click();
        countryInput.sendKeys(country);
        cityInput.sendKeys(city);
        loginButton.click();

        return new AccountPage(driver);

    }

}

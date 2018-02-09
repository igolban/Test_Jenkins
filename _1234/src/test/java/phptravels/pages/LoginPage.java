package phptravels.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {


    protected WebDriver driver;
    @FindBy(name = "username")
    private WebElement usernameInput;
    @FindBy(name = "password")
    private WebElement passwordInput;
    @FindBy(xpath = "//div[contains(@class,'alert')]")
    private WebElement errorMessage;
    @FindBy(xpath = "//button[contains(@class,'loginbtn')]")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AccountPage loginAs(String username, String password)

    {

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(usernameInput));
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();

        return new AccountPage(driver);
    }

    public LoginPage loginAndExpectedErrors(String username, String password)

    {

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(usernameInput));
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();

        return new LoginPage(driver);
    }


    public String getErrorMessage()

    {

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.getText();

    }


}
package phptravels.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


public class SignUpPage

{
    @FindBy(xpath = "//input[contains(@name,'first')]")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[contains(@name,'last')]")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[contains(@name,'phone')]")
    private WebElement mobileNumberInput;

    @FindBy(xpath = "//input[contains(@name,'email')]")
    private WebElement emailInput;

    @FindBy(xpath = "//input[contains(@name,'password')]")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[contains(@name,'confirmpassword')]")
    private WebElement confirmPasswordInput;

    @FindBy(xpath = "//div[contains(@class,'signupbtn')]")
    private WebElement signUpButton;


    @FindBy(xpath = "//div[@class='resultsignup']//*[not child::*)]")
    private List<WebElement> errorMessages;

    private WebDriver driver;
    private WebDriverWait wait;

    public SignUpPage(WebDriver driver)

    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 5);
    }

    public AccountPage signUpAs(String firstName, String lastName, String mobileNumber, String email, String password, String confirmPassword)

    {
        fillInFirstName(firstName);
        fillInName(lastName);
        fillInMobileNumber(mobileNumber);
        fillInEmail(email);
        fillInPassword(password);
        fillInConfirmPassword(confirmPassword);
        clickSignUp();

        return new AccountPage(driver);
    }

    public SignUpPage signUpWithWrongCredentials(String firstName, String lastName, String mobileNumber, String email, String password, String confirmPassword)

    {
        fillInFirstName(firstName);
        fillInName(lastName);
        fillInMobileNumber(mobileNumber);
        fillInEmail(email);
        fillInPassword(password);
        fillInConfirmPassword(confirmPassword);
        clickSignUp();

        return new SignUpPage(driver);
    }


    public void fillInFirstName(String firstName) {
        wait.until(visibilityOf(firstNameInput));
        firstNameInput.sendKeys(firstName);
    }


    public void fillInName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }


    public void fillInMobileNumber(String mobileName) {
        mobileNumberInput.sendKeys(mobileName);
    }

    public void fillInEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void fillInPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void fillInConfirmPassword(String confirmpassword) {
        passwordInput.sendKeys(confirmpassword);
    }

    public void clickSignUp()

    {
        signUpButton.click();

    }

    public List<String> getErrorMessages() {
        wait.until(ExpectedConditions.visibilityOfAllElements(errorMessages));
        List<String> errorStrings = new ArrayList<String>();
        for (WebElement message : errorMessages)
            errorStrings.add(message.getText());

        return errorStrings;

    }


}












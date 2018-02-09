package PracticeAutomation.pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import resources.PageBase;

public class ContactPage extends PageBase

{

    @FindBy(id="id_contact")
    private WebElement subjectHeading;
    @FindBy(id="email")
    private WebElement emailAdress;
    @FindBy(id="id_order")
    private WebElement orderReference;
    @FindBy(id="message")
    private WebElement messageTextArea;
    @FindBy(id="submitMessage")
    private WebElement submitButton;
    @FindBy(xpath = "//*[contains(@class,'alert')]")
    private WebElement statusMessage;

    public ContactPage(WebDriver driver)

    {
        super(driver);
         waitforURLToContains("contact");
    }

    public void fillSubjectHeading(String select) {
        new Select(subjectHeading).selectByVisibleText(select);
    }


    public void fillEmail(String email) {
    emailAdress.sendKeys(email);
     }

    public void fillOrder (String order) {
        orderReference.sendKeys(order);
    }
    public void fillMessage (String message) {
        messageTextArea.sendKeys(message);
    }



    public ContactPage submitMessageButton()
    { submitButton.click();
       return new ContactPage(driver);


    }

    public String getStatusMessage()
    {
        return statusMessage.getText();

    }

    public ContactPage fillContactPage(String subject, String email,String order, String message )
    { fillSubjectHeading(subject);
      fillEmail(email);
      fillOrder(order);
      fillMessage(message);
      submitMessageButton();
      return new ContactPage(driver);
    }

    }



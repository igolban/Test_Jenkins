package ProiectTA.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import resources.PageBase;

import java.util.List;



public class HomePage extends PageBase

{
    @FindBy(xpath = "//*[@id=\"homefeatured\"]/li[1]/div")
    private List <WebElement> firstHomeProductList;
    @FindBy(xpath = "//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[1]/span")
    private WebElement addButtonFirstHomeProductList;
    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[1]/h2")
    private WebElement textSuccessAddItemMessage;
    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")
    private WebElement proceedToCheckoutButton;

    public HomePage(WebDriver driver) {
        super(driver);
        waitforURLToContains("index.php");
    }

    public HomePage clickOnAddItem()
    {

        moveOverElement(firstHomeProductList.get(0));
        waitForElementToBeVisible(addButtonFirstHomeProductList);
        addButtonFirstHomeProductList.click();


    return new HomePage(driver);
    }

    public void moveOverElement(WebElement element)
        {
         Actions actions = new Actions(driver);
         actions.moveToElement(element).build().perform();
        }

    public String getStatusMessage()
    {
        waitForElementToBeVisible(textSuccessAddItemMessage);
        return textSuccessAddItemMessage.getText();

    }

    public OrderControlPage clickProceedToCheckoutHomePage()
    {
       proceedToCheckoutButton.click();
       return new OrderControlPage(driver);
    }


}

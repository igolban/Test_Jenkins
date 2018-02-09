package resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

public class PageBase {


        protected WebDriver driver;
        protected WebDriverWait wait;

        public PageBase(WebDriver driver)
        {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            wait = new WebDriverWait(driver, 5);
        }

        public void waitforURLToContains(String partialURL)
        {
            wait.until(ExpectedConditions.urlContains(partialURL));
        }

        public void waitForElementToBeVisible(WebElement element)
        {
            wait.until(visibilityOf(element));
        }

        public void waitForElementsToBeVisible(List<WebElement> elements)
        {
            wait.until(visibilityOfAllElements(elements));
        }

    }


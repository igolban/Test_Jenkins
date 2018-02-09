package phptravels.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.PageBase;

import java.util.ArrayList;
import java.util.List;

public class CarsPage extends PageBase

  {

      @FindBy(id = "11")
      private WebElement firstWishlist;
      @FindBy (xpath = "//h4[contains(@class,\"list_title\")]/a/b")
      private WebElement firstCarTitle;
      @FindBy (xpath = "////h4[contains(@class,\"list_title\")]")
      private List<WebElement> carList;

      public CarsPage(WebDriver driver) {
          super(driver);
      }

      public List<String> getSavedCarList()

      {   //definirea listei & initializare
          List<String> carNames = new ArrayList<String>();  //in codul tau e pus ~
          if (carList.size()==0)
              return carNames;
          waitForElementsToBeVisible(carList);

          for(WebElement car : carList)
           {
               carNames.add(car.getText());
           }

          return carNames;
      }



  }

package phptravels.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.PageBase;

import java.util.ArrayList;
import java.util.List;

public class BlogPage extends PageBase

{

        @FindBy(xpath = "input[@class='form input-lg RTL']")
        private WebElement searchInput;
        @FindBy(xpath = "/button[contains(.,'Search')]")
        private WebElement searchButton;
        @FindBy(xpath = "//div[text()='Categories and Post']/folllowing-siblings::a")
        private List<WebElement> categoryLinks;

        public List<String> getCategories()

           { List<String> categoryList = new ArrayList<String>();

             for(WebElement link : categoryLinks)
                 categoryList.add(link.getText());

             return categoryList;
           }

//        public List<String> getResults()
//
//           { List<String> articleTitles = new ArrayList<String>();
//             waitForElementsToBeVisible(results);
//
//              for (WebElement result: results)
//                  articleTitles.add(result.getText());
//
//              return articleTitles;
//
//           }



        public BlogPage(WebDriver driver)
        {
            super(driver);

        }


}

package PracticeAutomation.Tests;

import PracticeAutomation.pages.HomePage;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import resources.TestBase;

import java.util.ArrayList;
import java.util.List;

import static PracticeAutomation.Utils.LoginUtils.HOME_PAGE_URL;
import static org.hamcrest.Matchers.is;

public class HomeTest extends TestBase

{

       HomePage homePage;

        @Before

        public void setUp()

        {
            driver.get(HOME_PAGE_URL);
            homePage = new HomePage(driver);

        }

        @Test


        public void canNavigateToFBPage()
        {
            homePage.clickFacebook();
            List<String> windowsHandels = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(windowsHandels.get(1));
            MatcherAssert.assertThat(driver.getCurrentUrl(), is("https://www.facebook.com/groups/525066904174158/"));
        }





}

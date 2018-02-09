package ProiectTA.Tests;

import PracticeAutomation.pages.AccountPage;
import PracticeAutomation.pages.LoginPage;
import ProiectTA.pages.HomePage;
import ProiectTA.pages.OrderControlPage;
import ProiectTA.pages.SignInPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import resources.TestBase;

import java.util.ArrayList;
import java.util.List;

import static PracticeAutomation.Utils.LoginUtils.HOME_PAGE_URL;
import static PracticeAutomation.Utils.LoginUtils.TEST_EMAIL;
import static PracticeAutomation.Utils.LoginUtils.TEST_PASSWORD;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class AddItemTest extends TestBase
{
    private HomePage homePage;


    @Before

    public void setUp()

    {
        driver.get(HOME_PAGE_URL);
        homePage = new HomePage(driver);

    }

    @Test

    public void addItemWithSuccess() throws Exception

    {
        HomePage page = homePage.clickOnAddItem();
        assertThat(page.getStatusMessage(), containsString("Product successfully added to your shopping cart"));
        OrderControlPage orderControlPage = page.clickProceedToCheckoutHomePage();
        SignInPage signInPage = orderControlPage.clickProceedToCheckoutSignInPage();

    }


}



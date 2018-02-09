package PracticeAutomation.Tests;

import PracticeAutomation.pages.AccountPage;
import PracticeAutomation.pages.LoginPage;
import org.junit.Before;
import org.junit.Test;
import resources.TestBase;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import static PracticeAutomation.Utils.LoginUtils.HOME_PAGE_URL;
import static PracticeAutomation.Utils.LoginUtils.TEST_EMAIL;
import static PracticeAutomation.Utils.LoginUtils.TEST_PASSWORD;

public class CheckAccountTest extends TestBase

{  private LoginPage loginPage;

   @Before
    public void setUp()

   {  driver.get(HOME_PAGE_URL + "?controller=authentication&back=my-account");
      loginPage = new LoginPage(driver);
   }

   @Test

   public void loginWithMyAccount() throws Exception
   {

      AccountPage  accountPage = loginPage.loginAs(TEST_EMAIL,TEST_PASSWORD);
      assertThat(accountPage.getAccountName(),is( "marius golban") );
   }
}

package phptravels.tests;

import org.junit.Before;
import org.junit.Test;
import phptravels.pages.AccountPage;
import phptravels.pages.LoginPage;
import resources.TestBase;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AccountTest extends TestBase {
    AccountPage accountPage;
    LoginPage loginPage;

    @Before
    public void setUp() {
        driver.get("http://www.phptravels.net/login/");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void canAccessValidAccount() throws Exception {
        AccountPage accountPage = loginPage.loginAs("user@phptravels.com", "demouser");
        assertThat(accountPage.getGreetingMessages(), is("Hi, marius golban"));
    }

    @Test //do it exactly like in login page!!!!
    public void canModifyLocation() throws Exception {
        AccountPage accountPage = loginPage.loginAs("user@phptravels.com", "123456");
        accountPage.modifyLocation("Timisoara", "John Doe"); //TODO : return new object
        assertThat(accountPage.getGreetingMessages(), is("Profile Updated Successfully."));
    }


}

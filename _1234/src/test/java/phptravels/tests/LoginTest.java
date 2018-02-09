package phptravels.tests;

import org.junit.Before;
import org.junit.Test;
import phptravels.pages.LoginPage;
import resources.TestBase;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LoginTest extends TestBase

{

    private LoginPage loginPage;

    @Before

    public void setUp() {
        driver.get("http://www.phptravels.net/login");
        LoginPage loginPage = new LoginPage(driver);
    }

    @Test
    public void cannotLogin()
            throws Exception {
        loginPage.loginAs("uservalid", "parola gresita");
        assertThat(loginPage.getErrorMessage(), is("Invalid Email or Password"));

    }


}

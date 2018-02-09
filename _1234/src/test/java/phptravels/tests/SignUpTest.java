package phptravels.tests;

import org.junit.Before;
import org.junit.Test;
import phptravels.pages.AccountPage;
import phptravels.pages.SignUpPage;
import resources.TestBase;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static phptravels.utils.LoginUtils.TEST_EMAIL;
import static phptravels.utils.LoginUtils.TEST_PASSWORD;
import static phptravels.utils.StringUtils.getRandomEmailAddress;


public class SignUpTest extends TestBase {

    private SignUpPage signUpPage;

    @Before
    public void setUp() {
        driver.get("http://www.phptravels.net/register");
        signUpPage = new SignUpPage(driver);
    }

    @Test
    public void canSignUpWithValidCredentials() {
        AccountPage accountPage = signUpPage.signUpAs
                ("John", "Doe", "0745123456", getRandomEmailAddress(), "123456", "123456");

        assertThat(accountPage.getGreetingMessages(), containsString("Hi, John Doe"));
    }

    @Test
    public void cannotSignUpWithoutCredentials() {
        SignUpPage signUpWithoutCredentials = signUpPage.signUpWithWrongCredentials
                ("", "", "", "", "", "");

        assertThat(signUpWithoutCredentials.getErrorMessages(),
                both(hasItem("The Email field is required."))
                        .and(hasItem("The Password field is required."))
                        .and(hasItem("The Password field is required."))
                        .and(hasItem("The First name field is required."))
                        .and(hasItem("The Last Name field is required.")));
    }

    @Test
    public void cannotSignUpWithAnExistingEmail() {
        SignUpPage signUpWithAnExistingEmail = signUpPage.signUpWithWrongCredentials
                ("John", "Smith", "0745123456", TEST_EMAIL, TEST_PASSWORD, TEST_PASSWORD);

        assertThat(signUpWithAnExistingEmail.getErrorMessages(), contains("Email Already Exists."));
    }

    @Test
    public void cannotSignUpWithShortPassword() {
        SignUpPage signUpWithShortPassword = signUpPage.signUpWithWrongCredentials
                ("John", "Doe", "0745123456", TEST_EMAIL, "1234", "1234");

        assertThat(signUpWithShortPassword.getErrorMessages(), contains("The Password field must be at least 6 characters in length."));
    }


}


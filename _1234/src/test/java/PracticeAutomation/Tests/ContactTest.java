package PracticeAutomation.Tests;

import PracticeAutomation.pages.ContactPage;
import org.junit.Before;

import org.junit.Test;
import resources.TestBase;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactTest extends TestBase {
    ContactPage contactPage;


    @Before
    public void setUp() {
        driver.get("http://automationpractice.com/index.php?controller=contact");
        contactPage = new ContactPage(driver);
    }

    @Test

     public void validateMessage() throws Exception {
        ContactPage countPage = contactPage.fillContactPage("Webmaster", "i@g.com", "123", "alibaba");
        assertThat(contactPage.getStatusMessage(), is("Your message has been successfully sent to our team."));

    }

    @Test


    public void invalidMessage() throws Exception {
        ContactPage countPage = contactPage.fillContactPage("Webmaster", "i@g.com","123", "");
        assertThat(contactPage.getStatusMessage(), is("There is 1 error\nInValid email address"));
    }

    }

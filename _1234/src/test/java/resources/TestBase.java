package resources;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {


        protected WebDriver driver;

        @Before
        public void baseSetup() {
            driver = new FirefoxDriver();
        }

        @After
        public void tearDown()

        {
            driver.quit();
        }


    }



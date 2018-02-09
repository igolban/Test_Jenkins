package phptravels.tests;

import org.junit.Before;
import phptravels.pages.AccountPage;
import phptravels.pages.CarsPage;
import phptravels.pages.LoginPage;
import resources.TestBase;

import static phptravels.utils.LoginUtils.HOME_PAGE_URL;




public class CarsTest extends TestBase

{
    AccountPage accountPage;


    @Before
    public void setUp() {
        driver.get(HOME_PAGE_URL + "login");
        LoginPage loginPage = new LoginPage(driver);


        driver.get(HOME_PAGE_URL + "cars/");
        CarsPage carsPage = new CarsPage(driver);
    }
        //@Test
        //   public void checkCarWislist() throws Exception
        // {
        //CarsPage carsPage = accountPage.
        // List<String> saveCar = carsNames.get

        //    String firstWishlist =
        //    assertThat()

        //  }
        //  }

    }

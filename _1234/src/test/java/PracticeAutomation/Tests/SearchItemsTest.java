package PracticeAutomation.Tests;

import PracticeAutomation.pages.HomePage;
import PracticeAutomation.pages.ResultsPage;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import resources.TestBase;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


import static PracticeAutomation.Utils.LoginUtils.HOME_PAGE_URL;



@RunWith(value = Parameterized.class)
    public class SearchItemsTest extends TestBase

    {
        private String query;
        private HomePage homePage;

        public SearchItemsTest(String query)
         {this.query = query;}

      @Parameterized.Parameters
        public static Collection data() {
          return Arrays.asList(
                  "dress",
                  "top",
                  "Shirt");
       }

      @Before
      public void setUp()

      {  driver.get(HOME_PAGE_URL );
          homePage = new HomePage(driver);

      }

      @Test
       public void canSearchTheItems() throws Exception

      { ResultsPage resultsPage = homePage.searchItem(query);
        assertThat(resultsPage.getSavedProducts(),everyItem(greaterThan("0")));

      }

    }






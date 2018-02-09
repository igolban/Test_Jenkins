package phptravels.tests;

import org.junit.Before;
import phptravels.pages.BlogPage;
import resources.TestBase;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BlogTest extends TestBase
{
    private BlogPage blogPageVar;

    @Before
    public void setUp()
    {
        driver.get("http://www.phptravels.net/blog/");
        blogPageVar = new BlogPage(driver);
    }



  //  @Test

//    public void whenEnteringBlog_articlesAreDisplayed() throws Exception

//    {

//        assertThat(blogPageVar.getResults().size(), greaterThan());

//    }

}

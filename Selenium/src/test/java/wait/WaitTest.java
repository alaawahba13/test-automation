package wait;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.DynamicLoadingExample1Page;
import pages.DynamicLoadingPage;

import static org.testng.Assert.assertEquals;

public class WaitTest extends BaseTests {
    @Test
    public void testWait() {
        DynamicLoadingPage dynamicLoadingPage = homePage.clickDynamicLoading();
        DynamicLoadingExample1Page example1Page = dynamicLoadingPage.clickExample1();
        example1Page.clickStart();
        String text = example1Page.getText();
        assertEquals(text, "Hello World!");
    }
}

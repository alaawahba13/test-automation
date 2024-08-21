package javascript;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.InfiniteScrollPage;
import pages.LargeAndDeepDomPage;

public class JavaScriptTests extends BaseTests {
    @Test
    public void testScrollTable() {
        LargeAndDeepDomPage largeAndDeepDom = homePage.clickLargeAndDeepDom();
        largeAndDeepDom.scrollToTable();

    }

    @Test
    public void testScrollToParagraph() {
        InfiniteScrollPage infiniteScrollPage = homePage.clickInfiniteScroll();
        infiniteScrollPage.scrollToParagraph(5);
    }
}

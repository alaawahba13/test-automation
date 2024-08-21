package navigation;

import base.BaseTests;
import org.testng.annotations.Test;
import utils.WindowManager;

public class NavigationTests extends BaseTests {
    @Test
    public void testNavigator() {
        homePage.clickDynamicLoading().clickExample1();
        WindowManager windowManager = getWindowManager();
        windowManager.goBack();
        windowManager.refreshPage();
        windowManager.goForward();
        windowManager.goTo("https://google.com");
    }

    @Test
    public void testSwitchToTab() {
        homePage.clickMultipleWindows().clickHere();
        getWindowManager().switchToTab("New Window");
    }
}

package utils;

import org.openqa.selenium.WebDriver;

public class WindowManager {
    private WebDriver driver;
    private WebDriver.Navigation navigate;

    public WindowManager(WebDriver driver) {
        this.driver = driver;
        navigate = driver.navigate();
    }

    public void goBack() {
        navigate.back();
    }

    public void goForward() {
        navigate.forward();
    }

    public void refreshPage() {
        navigate.refresh();
    }

    public void goTo(String url) {
        navigate.to(url);
    }

    public void switchToTab(String tabTitle) {
        var windows = driver.getWindowHandles(); // gets the name pf the tabs
        for (String window : windows) {
            driver.switchTo().window(window);
            System.out.println("Current window: " + driver.getTitle());
            if (driver.getTitle().equals(tabTitle)) {
                break;
            }
        }

    }

}

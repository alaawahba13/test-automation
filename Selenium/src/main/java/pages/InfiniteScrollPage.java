package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class InfiniteScrollPage {
    private WebDriver driver;
    By textBlocks = By.className("jscroll-added");

    public InfiniteScrollPage(WebDriver driver) {
        this.driver = driver;
    }

    //index is 1-based
    public void scrollToParagraph(int index) {
        String script = "window.scrollTo(0, document.body.scrollHeight);";
        //keep scrolling untill a certain number of paragraphs exits
        JavascriptExecutor js = (JavascriptExecutor) driver;
        while (getNumberOfParagraphs() < index) {
            js.executeScript(script);
        }
    }

    private int getNumberOfParagraphs() {
        return driver.findElements(textBlocks).size();
    }

}

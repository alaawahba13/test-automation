package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HoverPage {
    private WebDriver driver;
    public HoverPage(WebDriver driver) {
        this.driver = driver;
    }

    public void hoverOverFigure(int index){
        Actions actions = new Actions(driver);
        List<WebElement> imgList = driver.findElements(By.cssSelector("#content img"));
        actions.moveToElement(imgList.get(index-1)).perform();
    }
}

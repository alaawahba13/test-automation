package rect;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RectTests {
    private WebDriver driver;
    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationu.applitools.com/learningpaths.html");
    }
    @Test
    public void getPositionDimension() {
        WebElement logoTAU = driver.findElement(By.xpath("//div[@id=\"app\"]//header/a/img"));
        Rectangle rect = logoTAU.getRect();
        System.out.println("Height: " + rect.height);
        System.out.println("x: " + rect.getX());
        System.out.println("y: " + rect.getY());
        System.out.println("Width: " + rect.getWidth());
    }
    @AfterClass
    public void tearDown() {
        // driver.quit();
    }
}

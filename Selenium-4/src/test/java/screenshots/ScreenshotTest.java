package screenshots;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;


public class ScreenshotTest {
    WebDriver driver;
    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://applitools.com/");
    }
    @Test
    public void testWebElementScreenshot() throws IOException {
        WebElement text = driver.findElement(By.cssSelector("#site-main h1"));
        File source=  text.getScreenshotAs(OutputType.FILE); // stores sc in a location as a file
        File destination= new File("screenshot.png");
        FileHandler.copy(source,destination);
    }
    @Test
    public void testSectionScreenshot() throws IOException {
        WebElement section = driver.findElement(By.xpath("//div[@class=\"wp-block-columns is-layout-flex wp-container-core-columns-is-layout-1 wp-block-columns-is-layout-flex\"]"));
        File source=  section.getScreenshotAs(OutputType.FILE); // stores sc in a location as a file
        System.out.println(source.getAbsolutePath());
        FileUtils.copyFile(source, new File("section.png"));
    }
    @Test
    public void testFullPageScreenshot() throws IOException {
        // this code only works if driver is Firefox driver not chrome.
//        File source = ((FirefoxDriver)driver).getFullPageScreenshotAs(OutputType.FILE);
//        System.out.println(source.getAbsolutePath());
//        FileHandler.copy(source,new File("page.png"));
    }
    @AfterClass
    public void tearDown() {
        // driver.quit();
    }
}

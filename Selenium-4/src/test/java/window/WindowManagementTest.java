package window;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class WindowManagementTest {
    private WebDriver driver;
    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");
    }
    @Test
    public void testNewTab() {
        WebDriver newTab =driver.switchTo().newWindow(WindowType.TAB);
        newTab.get("https://automationexercise.com/products");
        System.out.println(newTab.getTitle());
    }
    @Test
    public void testTabsSwitching() {
        // automatically open the new window
        WebDriver newTab = driver.switchTo().newWindow(WindowType.TAB);
        newTab.get("https://automationexercise.com/login");
        System.out.println("Title: " + driver.getTitle());

        //work in the new window
        driver.findElement(By.xpath("//form[@action=\"/signup\"]/input[@type=\"text\"]"))
                .sendKeys("alaa");
       driver.findElement(By.xpath("//form[@action=\"/signup\"]/input[@type=\"email\"]"))
                .sendKeys("alaawahbaa13@gmail.com");
        driver.findElement(By.xpath("//form[@action=\"/signup\"]/button")).click();

        //Get the window ID handles
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        String mainFirstWindow =  iterator.next();
        //switch and work in the main window
        driver.switchTo().window(mainFirstWindow);

    }
    @AfterClass
    public void tearDown() {
       // driver.quit();
    }

}

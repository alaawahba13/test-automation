package steps;

import base.BaseUtil;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ser.Serializers;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.AssertJUnit.assertTrue;


public class Steps extends BaseUtil {
    private WebDriver driver;
    private BaseUtil baseUtil;
    public Steps(BaseUtil base) {
        this.baseUtil = base;
    }
    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Given("I am in the login page of the Para Bank Application")
    public void i_am_in_the_login_page_of_the_para_bank_application() {

        driver.get("http://parabank.parasoft.com/parabank/index.htm");
    }

    @When("I enter valid {string} and {string} with {string}")
    public void i_enter_valid_credentials(String username, String password, String userFullName) {
        baseUtil.userFullname = userFullName;
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("username")).submit();
    }

    @Then("I should be taken to the Overview page")
    public void i_should_be_taken_to_the_overview_page() {
        By logoutLink = By.linkText("Log Out");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
        driver.findElement(logoutLink).isDisplayed();
        String actualuserFullName = driver.findElement(By.className("smallText")).getText().toString();
        assertTrue(actualuserFullName, actualuserFullName.contains(baseUtil.userFullname));
        driver.findElement(logoutLink).click();

    }
    @After
    public void after() {
        driver.quit();
    }
}

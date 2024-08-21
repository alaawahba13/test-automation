package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureArea;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.*;

public class LoginTests extends BaseTests {
    @Test
    public void testSuccessfulLogin() {
        LoginPage loginPage=  homePage.clickFormAuthentication();
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        SecureArea secureArea =  loginPage.clickLogin();
        assertTrue(secureArea.getStatusText().contains("You logged into a secure area!"),"Alert test is incorrect!");
    }
}

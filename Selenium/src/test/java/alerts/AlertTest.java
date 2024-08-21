package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AlertTest extends BaseTests {
    @Test
    public void testAcceptAlert() {
        var alertPage = homePage.clickJSAlerts();
        alertPage.clickAlert();
        alertPage.acceptAlert();
        assertEquals(alertPage.getResultText(),"You successfully clicked an alert");
    }
    @Test
    public void testGetTextFromAlert(){
        var alertPage = homePage.clickJSAlerts();
        alertPage.clickConfirm();
        String text = alertPage.alertGetText();
        alertPage.dismissAlert();
        assertEquals(text,"I am a JS Confirm");
    }
    @Test
    public void testPromptButton(){
        var alertPage = homePage.clickJSAlerts();
        alertPage.clickPrompt();
        alertPage.setAlertText("Hello World");
        alertPage.acceptAlert();
        String text = alertPage.getResultText();
        assertEquals(text,"You entered: Hello World");
    }
}

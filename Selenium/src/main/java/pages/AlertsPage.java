package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {
    private WebDriver driver;
    private By alertText = By.xpath("//button[text()=\"Click for JS Alert\"]");
    private By confirmText = By.xpath("//button[text()=\"Click for JS Confirm\"]");
    private By promptText = By.xpath("//button[text()=\"Click for JS Prompt\"]");

    private By result = By.id("result");
    public AlertsPage(WebDriver driver) {
        this.driver = driver;
    }
    // first button
    public void clickAlert() {
        driver.findElement(alertText).click();
    }

    // second button
    public void clickConfirm() {
        driver.findElement(confirmText).click();
    }
    // third button
    public void clickPrompt() {
        driver.findElement(promptText).click();
    }
    // alert functions
    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }
    public String alertGetText(){
        return driver.switchTo().alert().getText();
    }
    public void setAlertText(String text){
        driver.switchTo().alert().sendKeys(text);
    }
    //label
    public String getResultText(){
        return driver.findElement(result).getText();
    }

}

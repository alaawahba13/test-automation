package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditorPage {
    private WebDriver driver;
    private String editorFramId = "mce_0_ifr";
    private By textArea = By.id("tinymce");
    private By increaseButton= By.xpath("//button[@title=\"Increase indent\"]");
    public EditorPage(WebDriver driver) {
        this.driver = driver;
    }
    //switching
    private void switchToEditArea(){
        driver.switchTo().frame(editorFramId);
    }
    private void switchToMainArea(){
        driver.switchTo().parentFrame();
    }
    //text area
    public void clearTextArea(){
        switchToEditArea();
        driver.findElement(textArea).clear();
    }
    public void setTextArea(String text){
        switchToEditArea();
        driver.findElement(textArea).sendKeys(text);
    }
    public String getTextArea(){
        switchToEditArea();
        String text= driver.findElement(textArea).getText();
        switchToMainArea();
        return text;
    }
    //button
    public void clickButtonIncrease(){
        driver.findElement(increaseButton).click();
    }
}

package keys;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.KeyPressesPage;

import static org.testng.Assert.*;

public class KeysTest extends BaseTests {
    @Test
    public void testBackspace() {
        KeyPressesPage keyPage = homePage.clickKeyPresses();
        keyPage.sendCharacters("A"+ Keys.BACK_SPACE);
        String result = keyPage.getResult();
        assertEquals(result,"You entered: BACK_SPACE");
    }
    @Test
    public void testPi(){
        KeyPressesPage keyPage = homePage.clickKeyPresses();
    keyPage.enterPi();
    }
}

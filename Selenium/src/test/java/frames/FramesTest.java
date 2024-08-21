package frames;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FramesTest extends BaseTests {
    @Test
    public void testWysiwyg() {
        var editorPage = homePage.clickEditor();
        editorPage.clearTextArea();
        editorPage.setTextArea("Hello ");
        editorPage.clickButtonIncrease();
        editorPage.setTextArea("World");
        assertEquals(editorPage.getTextArea(),"Hello World");
    }
}

package devTools;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v113.emulation.Emulation;
import org.openqa.selenium.devtools.v85.log.Log;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.ConnectionType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DevToolsTests {
    private ChromeDriver driver;
    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.edge.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
// chapter 7.b NOT WORKING some version issues
    @Test
    public void testConsoleLogs() {
        // get devtools and create a session
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        // Enable the console logs
        devTools.send(Log.enable());
        //Add a listener for the console logs
        devTools.addListener(Log.entryAdded(),logEntry -> {
            System.out.println("----------");
            System.out.println("Level: " + logEntry.getLevel());
            System.out.println("Text: " + logEntry.getText());
            System.out.println("Broken URL: " + logEntry.getUrl());
        });
        driver.get("https://the-internet.herokuapp.com/broken_images");

    }
    //sets the Geo location (latitude, longtitude)
    @Test
    public void testMockGeoLocationCdp() {
        Map coordinates = new HashMap()
        {
            {
                put("latitude", 32.746940);
                put("longitude", -97.092400);
                put("accuracy", 1);            }
        };
        driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
        driver.get("https://where-am-i.org/");
    }
    @Test
    public void mockGeoLocation_DevTools(){
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Emulation.setGeolocationOverride(Optional.of(52.5043),
                Optional.of(13.4501),
                Optional.of(1)));
        driver.get("https://my-location.org/");
    }
    @Test
    public void enableSlowRexJonesII(){
        DevTools devTools= driver.getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(  // enable the network
                Optional.empty(),
                Optional.empty(),
                Optional.empty()));
        devTools.send(Network.emulateNetworkConditions(
                false,
                150,
                2500,
                2000,
                Optional.of(ConnectionType.CELLULAR3G)));
        driver.get("https://linkedin.com");
        System.out.println("Enable Slow Network: " + driver.getTitle());
    }

    @Test
    public void doNotEnableRexJonesII(){
        driver.get("https://RexJones2.com");
        System.out.println("Do Not Enable Network: " + driver.getTitle());
    }
    @AfterClass
    public void tearDown() {
       // driver.quit();
    }
}

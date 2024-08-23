package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.BeforeClass;



@CucumberOptions(
//        publish = true,
     //   plugin = {"pretty", "json:target/cucumber.json","html:target/cucumberHtmlReport.html","io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm", "usage:target/cucumber-usage.json"},
//        features = {"classpath:features"},
        features = {"src/test/resources/"},
//        plugin = {"pretty", "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm","html:target/cucumberHtmlReport.html", "json:target/cucumber-html-reports/cucumber.json"},

        //strict = true,
        glue = {"steps"},
        tags = "@LoginScenario"
)
public class TestRunner extends AbstractTestNGCucumberTests {
    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before Class");
    }
}

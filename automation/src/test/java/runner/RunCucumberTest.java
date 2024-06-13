package runner;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {},
    features ="src\\test\\resource\\features", //Where the BDD is located
    tags = "not @ignore",                      //Run all tests without tag @ignore 
    glue = {"steps"}                           //Where steps to  
)
public class RunCucumberTest{

    public static WebDriver driver;

    @BeforeClass
    public static void set_up(){
        String  browser = System.getProperty("browser");
        if (browser != null){
            driver = WebDriverFactory.createDriver(browser);
        }

        if (driver != null){
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }

    @AfterClass
    public static void tear_down(){
        driver.quit();
    }
}

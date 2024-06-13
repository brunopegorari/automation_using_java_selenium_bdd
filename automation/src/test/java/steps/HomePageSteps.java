package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.HomePage;
import runner.RunCucumberTest;

public class HomePageSteps extends RunCucumberTest {

    HomePage homePage = new HomePage(driver);
    
    @Given("^I am at homepage$")
    public void i_am_at_homepage() {
        homePage.accessHomepage();
    }

    @And("I click in register")
    public void i_click_in_register() {
        homePage.clickOnRegisterButton();
    }
}

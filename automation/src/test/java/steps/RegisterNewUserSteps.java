package steps;

import static org.junit.Assert.assertEquals;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ClientPage;
import pages.RegisterPage;
import runner.RunCucumberTest;
import support.Support;

public class RegisterNewUserSteps extends RunCucumberTest {

    RegisterPage registerPage = new RegisterPage(driver);
    ClientPage clientPage = new ClientPage(driver);
    Support support = new Support(driver);

    String client_name = "Teste da Silva";
    String client_email = support.get_random_email();
    String client_password = support.get_random_password(15);

    @When("I fill the form with my name, email and password")
    public void i_fill_the_form_with_my_name_email_and_password() {
        registerPage.fillForm(client_name, client_email, client_password);
        registerPage.clickOnRegisterNewUser();
    }

    @Then("I see the register has been done")
    public void i_see_the_register_has_been_done() {
        assertEquals("Cadastro realizado!", clientPage.getClientMessage());
        clientPage.clickOkButtonMessage();
    }

    @When("I fill the form with the following information, name {string}, password {string} and email {string}")
    public void i_fill_the_form_with_the_following_information_name_password_and_email(String name, String password, String email) {
        registerPage.fillForm(name, email, password);
        registerPage.clickOnRegisterNewUser();
    }

    @Then("I see the message {string}")
    public void i_see_the_message(String error_message) {
        assertEquals(registerPage.getErrorMessage(), error_message);
    }

}

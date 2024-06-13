package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import support.Support;

public class RegisterPage {
    WebDriver driver;

    //Elements
    private By fill_name = By.id("user");
    private By fill_email = By.cssSelector("#email");
    private By fill_password = By.xpath("//*[@id='password']");
    private By button_register = By.cssSelector("button[id='btnRegister']");//[class='theme-btn-one btn-black-overlay btn_md");
    //private By name_error_message = By.cssSelector("input[id='user'] + span[class='errorLabel']");
    private By name_error_message = By.xpath("//input[@id='user']/following-sibling::span[@id='errorMessageFirstName']");
    private By email_error_message = By.cssSelector("input[id='email'] + span[class='errorLabel']");
    private By password_error_message =  By.cssSelector("input[id='password'] + span[class='errorLabel']");

    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }

    public void fillForm(String name, String email, String password){
        Support wait = new Support(driver);
        wait.wait_element(fill_name, name);
        driver.findElement(fill_email).sendKeys(email);
        driver.findElement(fill_password).sendKeys(password);
    }

    public void clickOnRegisterNewUser(){
        Support wait = new Support(driver);
        wait.wait_element(button_register);
    }

    public String getErrorMessage(){
        String error_message = "";

        /* 
         *        if (driver.findElement(name_error_message).isDisplayed() == true){
            error_message = driver.findElement(name_error_message).getText();
        } else if (driver.findElement(email_error_message).isDisplayed() == true){
            error_message = driver.findElement(email_error_message).getText();
        } else if (driver.findElement(password_error_message).isDisplayed() == true){
            error_message = driver.findElement(password_error_message).getText();
        }
        */
        


        return error_message;  
    }


}

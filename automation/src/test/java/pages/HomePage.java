package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import support.Support;

public class HomePage {
    WebDriver driver;
    By register_button = By.cssSelector("a[href='/register']");
    
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void accessHomepage(){
        driver.get("https://automationpratice.com.br/");
    }

    public void clickOnRegisterButton(){
        Support wait =  new Support(driver);
        wait.wait_element(register_button);
    }
}

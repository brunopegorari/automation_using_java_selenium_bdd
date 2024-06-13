package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClientPage {
    WebDriver driver;

    public ClientPage(WebDriver driver){
        this.driver = driver;
    }

    public String getClientMessage(){
        return driver.findElement(By.id("swal2-title")).getText();
    }

    public String getWelcomeMessage(){
        return driver.findElement(By.cssSelector("div[class='swal2-html-container']")).getText();
    }

    public void clickOkButtonMessage(){
        driver.findElement(By.xpath("//button[@class='swal2-confirm swal2-styled'][@type='button']")).click();  
    }
    
}

package support;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Support {
    WebDriver driver;
    static Random random = new Random();

    public Support(WebDriver driver){
        this.driver = driver;
    }

    public void wait_element(By element_to_be_waited){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(element_to_be_waited)).click();
    }

    public void wait_element(By element_to_be_waited, String text){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(element_to_be_waited)).sendKeys(text);
    }

    public String get_random_email(){
        int email_random = random.nextInt(1+100);

        return "email" + email_random + "@testemail.com";
    }

    public String get_random_password(int password_lenght){
        String text                 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String number               = "0123456789";
        String special_character    = "!@#$%^&*()-=_+[]{}|;:'\",.<>/?";

        int text_lenght                 = (int) Math.ceil(password_lenght * 0.5); 
        int number_lenght               = (int) Math.ceil(password_lenght * 0.3);
        int special_character_lenght    = (int) Math.ceil(password_lenght * 0.2);

        return password_builder(text, text_lenght) + password_builder(number, number_lenght) + password_builder(special_character, special_character_lenght);
    }

    //CRIAR UM METODO QUE RECEBE A STRING QUE ELE PRECISA E TAMANHO, EXAMPLO: TEXT E LENGHT TEXT
    private static String password_builder (String character, int character_lenght){
        StringBuilder buildingRandomString = new StringBuilder(character_lenght);

        for (int i = 0; i < character_lenght ; i++){
            int indexRandom = random.nextInt(character.length());
            char randomString = character.charAt(indexRandom);

            buildingRandomString.append(randomString);
        } 

        String user_password = buildingRandomString.toString();
        return user_password;
    }
}

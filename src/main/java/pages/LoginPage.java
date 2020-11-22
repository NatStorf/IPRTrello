package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public static SelenideElement loginPage(){
        return $(By.xpath("//section[@class='inner-section']"));
    }

    public static SelenideElement login(){
        return $(By.xpath("//input[@id='user']"));
    }

    public static SelenideElement password(){
        return $(By.xpath("//input[@id='password']"));
    }

    public static SelenideElement btnLogin(){
        return $(By.xpath("//input[@id='login']"));
    }

    public static SelenideElement loginSubmit(){
        return $(By.xpath("//button[@id='login-submit']"));
    }

}
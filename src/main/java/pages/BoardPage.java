package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$;

public class BoardPage {
    public static SelenideElement cardOnList( String listName, String cardName){
        return $(By.xpath("//h2[text()='"+listName+"']//ancestor::div[contains(@class,'list-wrapper')]//div[contains(@class,'list-cards')]//*[text()='"+cardName+"']"));
    }
    public static SelenideElement permLvl(){
        return $(By.xpath("//a[@id='permission-level']"));
    }
    public static SelenideElement selectLvl(String lvl){
        return $(By.xpath("//ul[@class='pop-over-list']//a[contains(text(),'"+lvl+"')]"));
    }

    public static SelenideElement teambtn(){
        return $(By.xpath("//a[contains(@class,'board-header-btn-org-name')]"));
    }
    public static SelenideElement changeTeamBtn(){
        return $(By.xpath("//ul[@class='pop-over-list']//a[text()='Сменить команду…']"));
    }
    public static SelenideElement createTeamBtn(){
        return $(By.xpath("//a[text()='Создать команду']"));
    }
    public static SelenideElement menuBtn(){
        return $(By.xpath("//a[contains(@class,'mod-show-menu')]"));
    }
    public static SelenideElement changeBg(){
        return $(By.xpath("//a[contains(@class,'change-background')]"));
    }
    public static SelenideElement changeBgColors(){
        return $(By.xpath("//div[contains(@class,'bg-colors')]"));
    }
    public static SelenideElement greenBgColor(){
        return $(By.xpath("//div[contains(@class,'board-backgrounds-section-tile')]/div[contains(@style,'rgb(81, 152, 57)')]"));
    }
}

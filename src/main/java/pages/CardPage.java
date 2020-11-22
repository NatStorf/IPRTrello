package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CardPage {
    public static SelenideElement progress(){
        return $(By.xpath("//div[@class=\"checklist-progress\"]/span"));
    }
    public static SelenideElement cardChangeBgButton(){
        return $(By.xpath("//a[contains(@class,'card-cover-chooser')]"));
    }
    public static SelenideElement greenCardBg(){
        return $(By.xpath("//div[@class='no-back']//div/div/div/div/div/button"));
    }
    public static SelenideElement closeBtn(){
        return $(By.xpath("//a[contains(@class,'dialog-close-button')]"));
    }
    public static SelenideElement completeTaskChBox(){
        return $(By.xpath("//a[contains(@class,'complete')]"));
    }
    public static SelenideElement timeStatus(){
        return $(By.xpath("//span[contains(@class,'status')]"));
    }

}

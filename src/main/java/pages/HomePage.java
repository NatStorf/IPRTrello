package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    public static SelenideElement boardKanbanTool(){
        return $(By.xpath("//div[@title='KanbanTool']"));
    }
}

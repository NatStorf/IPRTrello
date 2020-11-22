package steps;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import pages.CardPage;

import java.security.PublicKey;

public class CardSteps {
    public static void taskComplite(){
        Assertions.assertEquals("100%", CardPage.progress().getText(), "Выполнены не все задания");
    }
    public static void closeCard(){
        SelenideElement closeBtn = CardPage.closeBtn();
        if (closeBtn.isDisplayed())closeBtn.click();
        else Assertions.assertTrue(closeBtn.isDisplayed(),"Не отображается кнопка закрытия карточки");
    }
    public static void openChangeBg() throws InterruptedException {
       SelenideElement changeBg = CardPage.cardChangeBgButton();
       if (changeBg.isDisplayed())changeBg.click();
       else Assertions.assertTrue(changeBg.isDisplayed(),"Не отображается кнопка смены обложки");
        Thread.sleep(3000);
    }
    public static void selectGreenBg(){
        SelenideElement selectBg = CardPage.greenCardBg();
        if (selectBg.isDisplayed())selectBg.click();
        else Assertions.assertTrue(selectBg.isDisplayed(),"Не отображается кнопка зеленого цвета обложки");
    }
    public static void completeTask(){
        if (CardPage.timeStatus().getText().contains("просрочено"))Assertions.fail("Время выполнения задачи просрочено");
        else {
            SelenideElement check = CardPage.completeTaskChBox();
            if (check.isDisplayed())check.click();
            else Assertions.assertTrue(check.isDisplayed(), "Не отображается чекбокс окончания задачи");
        }
    }
}

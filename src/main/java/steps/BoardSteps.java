package steps;


import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import pages.BoardPage;

public class BoardSteps {
    public static void checkCardOnList(String listname, String cardName) {
            Assertions.assertTrue(BoardPage.cardOnList(listname, cardName).isDisplayed(), "Не найдена карточка "+cardName+" в колонке "+listname);
    }
    public static void openCard(String listname, String cardName) throws InterruptedException {
        SelenideElement el = BoardPage.cardOnList(listname, cardName);
        if (el.isDisplayed())el.click();
        else Assertions.assertTrue(el.isDisplayed(), "Не найдена карточка "+cardName+" в колонке "+listname);
        Thread.sleep(4000);
    }
//    public static void openMenu(){
//        SelenideElement el = BoardPage.menuBtn();
//        if (el.isDisplayed())el.click();
//        else Assertions.assertTrue(el.isDisplayed(), "Не найдена кнопка меню");
//    }
    public static void openChangeBg() throws InterruptedException {
        SelenideElement el = BoardPage.changeBg();
        if (el.isDisplayed())el.click();
        else Assertions.assertTrue(el.isDisplayed(), "Не найдена кнопка изменения фона");
        Thread.sleep(2000);
    }
    public static void openChangeBgColors() throws InterruptedException {
        SelenideElement el = BoardPage.changeBgColors();
        if (el.isDisplayed())el.click();
        else Assertions.assertTrue(el.isDisplayed(), "Не найдена кнопка цвета");
        Thread.sleep(2000);
    }
    public static void selectGreenBg(){
        SelenideElement el = BoardPage.greenBgColor();
        if (el.isDisplayed())el.click();
        else Assertions.assertTrue(el.isDisplayed(), "Не найдена кнопка зеленого цвета");
    }
}

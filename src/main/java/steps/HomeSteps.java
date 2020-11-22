package steps;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import pages.HomePage;

public class HomeSteps {
    public static void openKanbanToolBoard() throws InterruptedException {
        SelenideElement board = HomePage.boardKanbanTool();
        if (board.isDisplayed())
        board.click();
        else
        Assertions.assertTrue(board.isDisplayed(), "Доска не отображается");
        Thread.sleep(5000);
    }
}

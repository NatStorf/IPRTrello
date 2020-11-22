import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import steps.BoardSteps;
import steps.CardSteps;
import steps.HomeSteps;
import steps.LoginSteps;


import static com.codeborne.selenide.Selenide.open;
import static io.restassured.RestAssured.given;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UITest {
    public static WebDriver driver;
    public static LoginPage loginPage;

    @Test
    @Order(1)
    public void login() throws InterruptedException {
        System.out.println("----------------------------------Начало теста----------------------------------");
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\chromedriver.exe");
        Configuration.timeout = 6000;
        Configuration.startMaximized = true;
        open("https://trello.com/login");
        LoginSteps.login("Storf1@yandex.ru", "90idASwda1Y2");
        Thread.sleep(10000);
    }

    //    Удостовериться, что карточка находится в колонке Done
//    Удостовериться, все пункты чек-боксов выполнены
//    Поставить обложку с зеленым цветом
//    Отметить, что задача выполнена в срок
//    Сменить фон доски на зеленый цвет
//    Сделать доску командной с названием "Ученики" и типом "Образование"
//    Выбрать тип команды "Образование"
//    Сменить имя доски "Только для образования"
    @Test
    @Order(2)
    public void checkCardInColumn() throws InterruptedException {
        HomeSteps.openKanbanToolBoard();
        BoardSteps.checkCardOnList("Done", "Карточка для изучения API");
    }

    @Test
    @Order(3)
    public void chBoxDone() throws InterruptedException {
        BoardSteps.openCard("Done", "Карточка для изучения API");
        CardSteps.taskComplite();
    }

    @Test
    @Order(4)
    public void changeCardBg() throws InterruptedException {
        CardSteps.openChangeBg();
        CardSteps.selectGreenBg();
    }

    @Test
    @Order(5)
    public void completeTask() {
        CardSteps.completeTask();
        CardSteps.closeCard();
    }

    @Test
    @Order(6)
    public void changeBoardBg() throws InterruptedException {
        BoardSteps.openChangeBg();
        BoardSteps.openChangeBgColors();
        BoardSteps.selectGreenBg();
    }
}

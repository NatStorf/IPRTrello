import util.FormatStringDate;
import util.fileUtils;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.MethodOrderer;

import org.junit.jupiter.api.Order;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.TestMethodOrder;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class APITest {
     private static String idBoard;
     private static String idList;
     private static String idCard;
    private static String idPunctOne;
     private static String idListDone;
     private static String idPunctTwo;

//    Создать доску "KanbanTool"
//    Создать колонку "Backlog"
//    Добавить карточку в колонку Backlog с названием "Карточка для изучения API"
//    Добавить вложение в виде любой фотографии
//    Поставить срок выполнения на следующий день
//    Добавить описание "Тут будет отмечаться прогресс обучения"
//    Создать чек-лист с пунктами:
//            - Понять протокол HTTP
//            - Выучить методы запросов
//    Отметить пункт в карточке "Понять протокол HTTP"
//    Создать колонку "Done"
//    Переместить карточку в эту колонку
//    Архивировать колонку "Backlog"
//    Отметить пункт в карточке "Выучить методы запросов"
//    Поставить в карточке эмоджи Палец вверх

    private RequestSpecification recSpec =
            given()
                    .header("content-type", "application/json")
                    .baseUri("https://api.trello.com/1")
                    .queryParam("key", "fa7f198fdbb4efe9be0c3b34b4c9ccd0")
                    .queryParam("token", "e8e17b8d768f319723bd0c8c3104fea7a8c7d14f6e48f94dfd3bea25dc519619");

    @Test
    @Order(2)
    public void createBoard() throws IOException {
        idBoard = given()
                .spec(recSpec)
                .queryParam("name", "KanbanTool")
                .when()
                .post("/boards")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .jsonPath()
                .get("id");
        fileUtils.changeFile("id", idBoard);
    }
    @Test
    @Order(3)
    public void createList() {
        idList = given()
                .spec(recSpec)
                .queryParam("name", "Backlog")
                .queryParam("idBoard", idBoard)
                .when()
                .post("/lists")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .jsonPath()
                .get("id");
    }

    @Test
    @Order(4)
    public void createCard() {
        idCard = given()
                .spec(recSpec)
                .queryParam("name", "Карточка для изучения API")
                .queryParam("idList", idList)
                .queryParam("desc", "Тут будет отмечаться прогресс обучения")
                .queryParam("due", FormatStringDate.date())
                .when()
                .post("/cards")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .jsonPath()
                .get("id");
    }

    @Test
    @Order(5)
    public void addImage() {
        String file = "src\\main\\resources\\image\\image.jpg";
        given()
                .spec(recSpec)
                .contentType("multipart/form-data")
                .multiPart("file", new File(file))
                .when()
                .post("/cards/" + idCard + "/attachments")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    @Order(6)
    public void createCheckList() {
        String idCheckList = given()
                .spec(recSpec)
                .queryParam("name", "Прогресс")
                .when()
                .post("/cards/" + idCard + "/checklists")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .jsonPath()
                .get("id");

        idPunctOne = given()
                .spec(recSpec)
                .queryParam("name", "Понять протокол HTTP")
                .when()
                .post("/checklists/" + idCheckList + "/checkItems")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .jsonPath()
                .get("id");

        idPunctTwo = given()
                .spec(recSpec)
                .queryParam("name", "Выучить методы запросов")
                .when()
                .post("/checklists/" + idCheckList + "/checkItems")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .jsonPath()
                .get("id");
    }

    @Test
    @Order(7)
    public void chekItem() {
        given()
                .spec(recSpec)
                .queryParam("state", "complete")
                .when()
                .put("/cards/" + idCard + "/checkItem/" + idPunctOne)
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    @Order(8)
    public void createListDone() {
        idListDone = given()
                .spec(recSpec)
                .queryParam("name", "Done")
                .queryParam("idBoard", idBoard)
                .when()
                .post("/lists")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .jsonPath()
                .get("id");
    }

    @Test
    @Order(9)
    public void rebaseCard() {
        given()
                .spec(recSpec)
                .queryParam("idList", idListDone)
                .when()
                .put("/cards/" + idCard)
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    @Order(10)
    public void closeListBacklog() {
        given()
                .spec(recSpec)
                .queryParam("value", "true")
                .when()
                .put("/lists/" + idList + "/closed")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    @Order(11)
    public void checkItemTwo() {
        given()
                .spec(recSpec)
                .queryParam("state", "complete")
                .when()
                .put("/cards/" + idCard + "/checkItem/" + idPunctTwo)
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    @Order(12)
    public void like() {
        given()
                .spec(recSpec)
                .queryParam("text", ":thumbsup: ")
                .when()
                .post("/cards/" + idCard + "/actions/comments")
                .then()
                .assertThat().
                statusCode(200);
    }
}

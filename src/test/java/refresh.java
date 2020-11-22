import util.fileUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

class refresh {
    static void refrechSite() throws IOException {
        String idBoard = fileUtils.getFileValue("id");
        given()
                .header("Accept", "application/json")
                .queryParam("key", "fa7f198fdbb4efe9be0c3b34b4c9ccd0")
                .queryParam("token", "e8e17b8d768f319723bd0c8c3104fea7a8c7d14f6e48f94dfd3bea25dc519619")
                .when()
                .delete("https://api.trello.com/1/boards/" + idBoard)
                .then()
                .assertThat()
                .statusCode(200);
    }
}

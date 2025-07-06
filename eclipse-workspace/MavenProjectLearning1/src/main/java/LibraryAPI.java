import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import files.Payload;


public class LibraryAPI {
	public static void main(String[] args) {
	RestAssured.baseURI="https://rahulshettyacademy.com";

    String response = given()
        .header("Content-Type", "application/json")
        .body(Payload.Addbook("adfs","3463"))
    .when()
        .post("/Library/Addbook.php")
    .then()
        .statusCode(200)
        .extract().response().asString();

    JsonPath js = new JsonPath(response);
    String id = js.getString("ID");
    System.out.println("Book ID created: " + id);

	
	
}	
	
}

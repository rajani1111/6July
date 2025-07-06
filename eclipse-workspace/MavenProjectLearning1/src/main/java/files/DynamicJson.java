package files;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class DynamicJson {
	
	
//@Test
//	public void addBook() {
//	RestAssured.baseURI="https://rahulshettyacademy.com";
//	 // String aisle = "1234"; // or generate dynamically
//	  //  String isbn = "abcd";
//	//String aisle = String.valueOf((int)(Math.random() * 10000));
//   // String isbn = "xyz" + System.currentTimeMillis();
//
//
// //  String aisle = "as" + System.currentTimeMillis();
//  // 
//	 //  System.out.println("Aisle: " + Payload.aisle);
//     //  System.out.println("ISBN: " + Payload.isbn);
//     //  System.out.println("Payload:\n" + Payload.Addbook(null, null));
//	
//	//String isbn = "isbn" + ((int)(Math.random() * 10000));
//   
//	String aisle = "A" + System.currentTimeMillis();
//	String isbn = "ISBN" + (int)(Math.random() * 10000);
//	
//	
//	// 🔍 Print the payload before sending the request
//    System.out.println("Payload:\n" + Payload.Addbook(aisle, isbn));
//	// 🔍 Print the payload before sending the request
//   // System.out.println("Payload:\n" + Payload.Addbook(aisle, isbn));
//  
//    String response = given()
//        .header("Content-Type", "application/json")
//        .body(Payload.Addbook("aisle","34863"))
//    .when()
//        .post("/Library/Addbook.php")
//    .then().log().all()
//        .assertThat().statusCode(200)
//        .extract().response().asString();
//
//    
//    System.out.println("response: "+response); 
//    JsonPath js = new JsonPath(response);
//    String id = js.getString("ID");
//    System.out.println("Book ID created: " + id);
//
	@Test
	public void addBook() {
	    RestAssured.baseURI = "https://rahulshettyacademy.com";

	    String aisle = "1234"; // or generate dynamically
	    String isbn = "abcd";

	    // Now this will work
	    System.out.println("Payload:\n" + Payload.Addbook(aisle, isbn));

	    String response = given()
	        .header("Content-Type", "application/json")
	        .body(Payload.Addbook(aisle, isbn)) // pass variables here
	    .when()
	        .post("/Library/Addbook.php")
	    .then().log().all()
	        .assertThat().statusCode(200)
	        .extract().response().asString();

	    JsonPath js = new JsonPath(response);
	    String id = js.getString("ID");
	    System.out.println("Book ID: " + id);
	}
//	
//}
//
//	
	
}

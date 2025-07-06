package files;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DeleteclassR {

	//public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	@Test(dataProvider= "BooksData")
	public void addBook(String aisle, String isbn) {
	    RestAssured.baseURI = "https://rahulshettyacademy.com";

	    
	    
	//    String aisle = "1234"; // or generate dynamically
	 //   String isbn = "abcd";

	    // Now this will work
	 //   System.out.println("Payload:\n" + Payload.Addbook(aisle, isbn));
	    
	    
	  //  String aisle = "1234"; // or generate dynamically
	  //  String isbn = "abcd";

	    // Now this will work
	 //   System.out.println("Payload:\n" + Payload.Addbook(aisle, isbn));

	    Response resp = given()
	        .header("Content-Type", "application/json")
	        .body(Payload.Addbook(aisle,isbn)) // pass variables here
	    .when()
	        .post("/Library/Addbook.php")
	    .then().
	        assertThat().statusCode(200)
	        .extract().response();

	    JsonPath js = ReusableMethods.rawToJSON(resp.asString());
	    String id = js.getString("ID");
	    System.out.println("Book ID: " + id);
	}
//	
//}
//
	@DataProvider(name="BooksData")
	
		public Object[][] getData() {
	
		
		//multidimensional arrays of collections
		
	return new Object[][] {
		{"1233","eee"},
		{"2424","wee"},
		{"222","erfff"}
	};
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	}



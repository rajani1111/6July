package package1;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Handle_static_json_file {

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		//validate if Add Place API is working as expected
		
		//given - all input details
		//when- submit the API - resource, http method
		//Then- validate the response
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		String filepath= "/Users/laprepos-122/Desktop/fille.json";
		String response= given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body(new String(Files.readAllBytes(Paths.get(filepath))))
				.when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope",equalTo("APP"))
		.header("server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();

	//Add place -> update place with new address -> get place to validate if the address is present in response 
	
		
		System.out.println("Api 1 response= " + response);
		
		
		JsonPath js= new JsonPath(response); //for parsing json
		
	
		String placeId= js.getString("place_id");
		
		System.out.println(placeId);
	

	
	}
		
}

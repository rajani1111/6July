package package1;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import files.Payload;
import files.ReusableMethods;
import io.restassured.response.Response;


public class Class1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//validate if Add Place API is working as expected
		
		//given - all input details
		//when- submit the API - resource, http method
		//Then- validate the response
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		String response= given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body(Payload.AddPlace()).when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope",equalTo("APP"))
		.header("server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();

	//Add place -> update place with new address -> get place to validate if the address is present in response 
	
		
		System.out.println("Api 1 response= " + response);
		
		
		JsonPath js= new JsonPath(response); //for parsing json
		
	
		String placeId= js.getString("place_id");
		
		System.out.println(placeId);
		
		//Update Place API
		
		String newAddress ="Pune";
		given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body("{\n"
				+ "\"place_id\":\""+placeId+ "\",\n"
				+ "\"address\":\"" +newAddress+ "\",\n"
				+ "\"key\":\"qaclick123\"\n"
				+ "}")
		.when().put("/maps/api/place/update/json")
		.then().assertThat().log().all().statusCode(200).body("msg",equalTo("Address successfully updated"));
	
		
		//get place to validate if the address is present in response 
		
		String getPlaceResponse = given().queryParam("key","qaclick123")
		.queryParam("place_id",placeId)
		.when().get("maps/api/place/get/json")
		.then().assertThat().log().all().statusCode(200).extract().response().asString();
	
	
	JsonPath js1= new JsonPath(getPlaceResponse);
		//JsonPath js1= ReusableMethods.rawToJSON(getPlaceResponse);
	String actualAddress= js1.getString("address");
	
	System.out.println(actualAddress);
	
	Assert.assertEquals(actualAddress, newAddress);
	
	}

}

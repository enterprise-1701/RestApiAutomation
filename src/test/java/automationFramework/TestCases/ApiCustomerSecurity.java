package automationFramework.TestCases;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import org.json.JSONArray; 
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.jayway.restassured.RestAssured.*;

//API customer/security question GET
public class ApiCustomerSecurity {
	
  	private static String ENDPOINT = "http://localhost:8201/nis/csapi/v1/customerservice/securityquestions";
	
  @Test
  public void getApiResponseSuccess() throws JSONException{
	    
	Response response = given().
   	header("x-cub-appid", "appId").
   	header("Authorization", "d2ViOnBhc3N3b3Jk").
   	header("x-cub-uid", "testUID").
   	header("x-cub-device", "deviceId").
   when().
   	get(ENDPOINT).thenReturn();
   
	    JsonPath jsonPath = new JsonPath(response.asString());
	    String result = jsonPath.getString("securityQuestions");
	    Assert.assertTrue(result.contains("what is your age?"));
	    String result2 = jsonPath.getString("hdr");
	    Assert.assertTrue(result2.contains("Successful"));	    
  }  
  
  @Test
  public void getApiResponseError() throws JSONException{
 	    
 	Response response = given().
 	header("x-cub-appid", "").
 	header("Authorization", "d2ViOnBhc3N3b3Jk").
    header("x-cub-uid", "testUID").
 	header("x-cub-device", "deviceId").
   when().
 	 get(ENDPOINT).thenReturn();
 	   
 	    JSONArray jsonResponse = new JSONArray("[" + response.asString() + "]"); 
 		System.out.println(jsonResponse);
 		JsonPath jsonPath = new JsonPath(response.asString());
 	    String result = jsonPath.getString("hdr");
 	    //Assert.assertTrue(result.contains("UnexpectedSystemError"));
   }  
  	
  @Test  
  public void getApiResponseError2() throws JSONException{
	    
		Response response = given().
	   	header("x-cub-appid", "appId").
		header("Authorization", "").
		header("x-cub-uid", "testUID").
	   	header("x-cub-device", "deviceId").
	   when().
	   	get(ENDPOINT).thenReturn();
	   
		JSONArray jsonResponse = new JSONArray("[" + response.asString() + "]"); 
		System.out.println(jsonResponse);
		JsonPath jsonPath = new JsonPath(response.asString());
	    String result = jsonPath.getString("hdr");
	    Assert.assertTrue(result.contains("UnexpectedSystemError"));
  }  
  
  @Test
  public void getApiResponseError3() throws JSONException{
	    
		Response response = given().
	   	header("x-cub-appid", "appId").
		header("Authorization", "d2ViOnBhc3N3b3Jk").
	   	header("x-cub-uid", "").
	   	header("x-cub-device", "deviceId").
	   when().
	   	get(ENDPOINT).thenReturn();
	   
		JSONArray jsonResponse = new JSONArray("[" + response.asString() + "]"); 
		System.out.println(jsonResponse);
		JsonPath jsonPath = new JsonPath(response.asString());
	    String result = jsonPath.getString("hdr");
	    Assert.assertTrue(result.contains("DataValidationError"));
	    Assert.assertTrue(result.contains("uid cannot be null"));
  }   
  
  @Test
  public void getApiResponseError4() throws JSONException{
	    
		Response response = given().
	   	header("x-cub-appid", "appId").
	   	header("Authorization", "d2ViOnBhc3N3b3Jk").
		header("x-cub-uid", "testUID").
	   	header("x-cub-device", "").
	   when().
	   	get(ENDPOINT).thenReturn();
	   
		JSONArray jsonResponse = new JSONArray("[" + response.asString() + "]"); 
		System.out.println(jsonResponse);
		JsonPath jsonPath = new JsonPath(response.asString());
	    String result = jsonPath.getString("hdr");
	    Assert.assertTrue(result.contains("DataValidationError"));
	    Assert.assertTrue(result.contains("device cannot be null"));
  }  
  
  @Test
  public void getApiResponseError5() throws JSONException{
	    
		Response response = given().
	   	header("", "").
	   	header("", "").
		header("", "").
	   	header("", "").
	   when().
	   	get(ENDPOINT).thenReturn();
	   
		JSONArray jsonResponse = new JSONArray("[" + response.asString() + "]"); 
		System.out.println(jsonResponse);
		JsonPath jsonPath = new JsonPath(response.asString());
	    String result = jsonPath.getString("hdr");
	    Assert.assertTrue(result.contains("DataValidationError"));
	    Assert.assertTrue(result.contains("username cannot be null"));
  }  
  
}	


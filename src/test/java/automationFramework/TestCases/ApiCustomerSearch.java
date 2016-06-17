package automationFramework.TestCases;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import org.json.JSONArray; 
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.jayway.restassured.RestAssured.*;

//API customer/search GET
public class ApiCustomerSearch {
	
  	private static String ENDPOINT = "http://localhost:8201/nis/csapi/v1/customer/search?email=jmala222233@yahoo.com";
	
  @Test
  public void getApiResponseSuccess() throws JSONException{
	    
	Response response = given().
   	header("x-cub-appid", "appId").
   	header("Authorization", "d2ViOnBhc3N3b3Jk").
   	header("x-cub-uid", "testUID").
   	header("x-cub-device", "deviceId").
   when().
   	get(ENDPOINT).thenReturn();
   
	JSONArray jsonResponse = new JSONArray("[" + response.asString() + "]"); 
	System.out.println(jsonResponse);
	JsonPath jsonPath = new JsonPath(response.asString());
    String result = jsonPath.getString("hdr");
    Assert.assertTrue(result.contains("Successful"));
    String result2 = jsonPath.getString("customers");
    Assert.assertTrue(result2.contains("san diego"));
    Assert.assertTrue(result2.contains("92122"));
    Assert.assertTrue(result2.contains("CA"));
    Assert.assertTrue(result2.contains("US"));
    Assert.assertTrue(result2.contains("84"));
    Assert.assertTrue(result2.contains("jamal"));
    Assert.assertTrue(result2.contains("8589998888"));
  }  
  
  @Test
  public void getApiResponseError() throws JSONException{
	    
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
	    Assert.assertTrue(result.contains("1"));
	  }  
  
  @Test
  public void getApiResponseError2() throws JSONException{
	    
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
  public void getApiResponseError3() throws JSONException{
	    
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
  public void getApiResponseError4() throws JSONException{
	    
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
	    //Assert.assertTrue(result.contains("DataValidationError"));
	  
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


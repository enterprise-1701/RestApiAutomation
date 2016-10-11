package automationFramework.TestCases;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.jayway.restassured.RestAssured.*;
import automationFramework.Utilities.Logging;
import org.apache.log4j.Logger;
import automationFramework.Utilities.Utils;

//API Test
public class ApiCreateAccount {
	
  	private static String ENDPOINT = "http://172.23.4.196:8601/oam/oamapi/v1/oneaccount";
 	private static Logger Log = Logger.getLogger(Logger.class.getName());
  	
  //API Post
  	@Test(enabled=true)
  	public static void ApiPostSuccess() throws JSONException{
	    
  	  	Logging.setLogConsole();
  		Logging.setLogFile();
        CreateAccountRequest requestBody = new CreateAccountRequest();
  		requestBody.setCustomerId("5003");
        
	CreateAccountResponse response = Utils.getRequestSpecifications().
    body(requestBody).
    when().
   	post(ENDPOINT).as(CreateAccountResponse.class);
  
	   Assert.assertEquals(response.getHdr().getResult(),"Successful");
	   Log.info(response.toString());
    
  }
  	
}	


package automationFramework.TestCases;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.jayway.restassured.RestAssured.*;
import automationFramework.Utilities.Logging;
import org.apache.log4j.Logger;


public class CreateAccountResponse{
	
	private RestResponseHeader hdr;
	private String oneAccountId;

	
	public RestResponseHeader getHdr() {
		return hdr;
	}

	public void setHdr(RestResponseHeader hdr) {
		this.hdr = hdr;
	}
	

	public String getOneAccountId() {
		return oneAccountId;
	}

	public void setOneAccountId(String oneAccountId) {
		this.oneAccountId = oneAccountId;
	}
	
	   
  }  
	   
  
 
	


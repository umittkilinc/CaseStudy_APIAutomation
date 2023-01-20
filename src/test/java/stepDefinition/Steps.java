package stepDefinition;

import base.CrudOperation;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.Cookies;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.Utilities;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Steps extends CrudOperation{
	public static Response response;
	JsonPath js;
	public static String userID;

	@ParameterType(value = "true|True|TRUE|false|False|FALSE")
	public Boolean booleanValue(String value) {
		return Boolean.valueOf(value);
	}
	
	@Then("Status code is {int}")
	public void status_code_is(Integer int1) {
		if (int1 == 200) {
			System.out.println("Status Code: " + response.statusCode());
			Assert.assertEquals(response.statusCode(), 200);
		}
		else if (int1 == 500) {
			System.out.println("Status Code: " + response.statusCode());
			Assert.assertEquals(response.statusCode(), 500);
		}
		else if (int1 == 404) {
			System.out.println("Status Code: " + response.statusCode());
			Assert.assertEquals(response.statusCode(), 404);
		}

	}
	
	@Then("{string} in response body is {booleanValue}")
	public void in_response_body_is(String value1, Boolean value2) {
		js = Utilities.rawToJson(response);
		Assert.assertEquals(js.get(value1), value2);
	}

	@Given("Send {string} with {string} https request")
	public void send_with_https_request(String apiName, String requestType) throws FileNotFoundException {
		if(requestType.equalsIgnoreCase("POST")) {
			if(apiName.equalsIgnoreCase("LoginAPI")){
				response = postRequestLogin(apiName);
			}
			else if(apiName.equalsIgnoreCase("CreateUserAPI")){
				response = postRequestCreateUser(apiName);
			}
			else if (apiName.equalsIgnoreCase("AssignSessionAPI")){
				response = postRequestAssignSession(apiName);
			}
			CrudOperation.rawToJson(response);
		}
		else if(requestType.equalsIgnoreCase("GET")) {
			if(apiName.equalsIgnoreCase("CreateUserAPI")){
				response = getRequestQueryUserID(apiName);
			}
			else if(apiName.equalsIgnoreCase("AssignSessionAPI")){
				response = getRequestQuerySession(apiName);
			}
			else if(apiName.equalsIgnoreCase("SessionTemplatesAPI")){
				response = getRequestQuerySessionTemplates(apiName);
			}
			CrudOperation.rawToJson(response);
		}
	}

	@Then("Get {string} from response header")
	public void get_from_response_header(String cookie) {
		Cookies cookies = response.getDetailedCookies();
		Utilities.getCookie(cookies, cookie);
	}

	@Then("{string} is in response body {string}")
	public void is_in_response_body(String string, String string2) {
		js = Utilities.rawToJson(response);
		Assert.assertEquals(js.get(string), string2);
	}

	@Then("I retrieve the UserID")
	public void i_retrieve_the_userID() {
		js = Utilities.rawToJson(response);
		userID = js.get("id");
		System.out.println("UserID: "+userID);
	}

	@Then("Total Templates check")
	public void total_templates_check() {
		js = Utilities.rawToJson(response);

		List<String> resultInResponse = new ArrayList<>();
		resultInResponse = js.getList("results");
		int resultSize = resultInResponse.size();
		System.out.println("==> Result Size: "+resultSize);

		int totalElement = js.getInt("totalElements");
		System.out.println("==> Total Elements: "+totalElement);

		Assert.assertEquals(resultSize, totalElement);
	}

}

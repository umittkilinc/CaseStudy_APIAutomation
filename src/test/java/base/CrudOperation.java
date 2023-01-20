package base;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.APIResources;
import resources.Payload;
import stepDefinition.Steps;
import utilities.PropertiesReader;

import java.io.FileNotFoundException;


public class CrudOperation  {
	PropertiesReader pro = new PropertiesReader();

	public static JsonPath rawToJson(Response r)
	{
		String respon=r.asString();
		JsonPath x=new JsonPath(respon);
		System.out.println("Response: "+respon+"\n~~~~~~~~~~~~~~~~~~~~~");
		return x;
	}

	public Response postRequestLogin(String apiName) {

		RestAssured.baseURI = pro.getPropValue("baseURI");

		APIResources resourceAPI= APIResources.valueOf(apiName);

		Response response = RestAssured.given().log().all() //.log().all() kısmını URI için ben ekledim
				.header("Content-Type", "application/json")
				.header("secretKey", pro.getPropValue("secretKey"))
				.body(Payload.loginPayload())
				.post(resourceAPI.getResource());

		return response;
	}

	public Response postRequestCreateUser(String apiName) {

		RestAssured.baseURI = pro.getPropValue("baseURI");

		APIResources resourceAPI= APIResources.valueOf(apiName);

		Response response = RestAssured.given().log().all()
				.cookie(pro.getPropValue("cookie1"), pro.getPropValue("cookie2"))
				.header("Content-Type", "application/json")
				.header("secretKey", pro.getPropValue("secretKey"))
				.body(Payload.createUserPayload())
				.post(resourceAPI.getResource());
		return response;
	}

	public Response getRequestQueryUserID(String apiName) throws FileNotFoundException {

		RestAssured.baseURI = pro.getPropValue("baseURI");

		APIResources resourceAPI= APIResources.valueOf(apiName);

		if(Steps.userID == null) {
			//Payload.createUserPayload().getUsername();
			Steps wi = new Steps();
			wi.send_with_https_request("CreateUserAPI", "POST");
			wi.i_retrieve_the_userID();
		}

		Response response = RestAssured.given().log().all()
				.cookie(pro.getPropValue("cookie1"), pro.getPropValue("cookie2"))
				.header("Content-Type", "application/json")
				.header("secretKey", pro.getPropValue("secretKey"))
				.get(resourceAPI.getResource()+ Steps.userID);
		return response;
	}

	public Response postRequestAssignSession(String apiName) {

		RestAssured.baseURI = pro.getPropValue("baseURI");

		APIResources resourceAPI= APIResources.valueOf(apiName);

		Response response = RestAssured.given().log().all()
				.cookie(pro.getPropValue("cookie1"), pro.getPropValue("cookie2"))
				.header("Content-Type", "application/json")
				.header("secretKey", pro.getPropValue("secretKey"))
				.body(Payload.assignSessionPayload())
				.post(resourceAPI.getResource());
		return response;
	}

	public Response getRequestQuerySession(String apiName) throws FileNotFoundException {

		RestAssured.baseURI = pro.getPropValue("baseURI");

		APIResources resourceAPI= APIResources.valueOf(apiName);

		Response response = RestAssured.given().log().all()
				.cookie(pro.getPropValue("cookie1"), pro.getPropValue("cookie2"))
				.header("Content-Type", "application/json")
				.header("secretKey", pro.getPropValue("secretKey"))
				.get(resourceAPI.getResource()+ "/1ed98344-9b20-c549-ddf4-094fda53f2fe");
		return response;
	}

	public Response getRequestQuerySessionTemplates(String apiName) throws FileNotFoundException {

		RestAssured.baseURI = pro.getPropValue("baseURI");

		APIResources resourceAPI= APIResources.valueOf(apiName);

		Response response = RestAssured.given().log().all()
				.cookie(pro.getPropValue("cookie1"), pro.getPropValue("cookie2"))
				.header("Content-Type", "application/json")
				.header("secretKey", pro.getPropValue("secretKey"))
				.get(resourceAPI.getResource());
		return response;
	}

}

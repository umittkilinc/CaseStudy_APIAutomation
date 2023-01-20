package utilities;

import io.restassured.http.Cookies;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Utilities {

	public static JsonPath rawToJson(Response response) {
		JsonPath js = new JsonPath(response.body().asString());
		return js;
	}

	public static String getCookie(Cookies cookies, String cookie){
		String charCookies = cookies.toString();
		String[] arrayCookie= charCookies.split(";");
		cookie = arrayCookie[0];
		System.out.println("Cookie: "+cookie);
		return cookie;
	}
}

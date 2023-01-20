package util;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojo.Login;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class ReusableMethods {

//    public static String getGlobalValue(String key) throws IOException, FileNotFoundException {
//        Properties prop =new Properties();
//        FileInputStream fis =new FileInputStream("C:\\Users\\umit.kilinc\\Desktop\\QAEngineer Program\\Case Study\\src\\test\\java\\resources\\global.properties");
//        prop.load(fis);
//        return prop.getProperty(key);
//    }
//
//    public static JsonPath rawToJson(Response r)
//    {
//        String respon=r.asString();
//        JsonPath x=new JsonPath(respon);
//        System.out.println("Response: "+respon+"\n~~~~~~~~~~~~~~~~~~~~~");
//        return x;
//    }
//
//    public static void sendPostLoginRequest(String BaseUrl, Login RequestBody, String Endpoint) throws IOException {
//
//        Response resp=given().log().all()
//                .header("Content-Type","application/json")
//                .header("secretKey", getGlobalValue("secretKey"))
//                .body(RequestBody)
//                .when().post(Endpoint);
//        ReusableMethods.rawToJson(resp);
//    }


}

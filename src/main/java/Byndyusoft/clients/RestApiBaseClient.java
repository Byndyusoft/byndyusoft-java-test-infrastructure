package Byndyusoft.clients;


import com.google.gson.JsonObject;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class RestApiBaseClient {

    public static String getRequest(String headerName, String headerValue, String hostUrl) {
        given()
                .header(headerName, headerValue)
                .when().get(hostUrl)
                .then().log().status().log().body();

        String statusCode = given().header(headerName, headerValue).when().get(hostUrl).then().log().status().toString();

        return statusCode;
    }

    public static void postRequest(String headerName, String headerValue, String hostUrl, JsonObject jsonBody) {
        given()
                .contentType(ContentType.JSON)
                .body(jsonBody)
                .header(headerName, headerValue)
                .log().all()
                .when().post(hostUrl)
                .then().log().status().log().body();
    }

    public static String getHttpStatus() {


        String httpStatus = "";

        return httpStatus;
    }

}

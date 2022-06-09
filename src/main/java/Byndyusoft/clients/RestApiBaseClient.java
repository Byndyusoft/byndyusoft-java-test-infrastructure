package Byndyusoft.clients;


import com.google.gson.JsonObject;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class RestApiBaseClient {

    public static void getRequest(String headerName, String headerValue, String hostUrl) {
        given()
                .header(headerName, headerValue)
                .when().get(hostUrl)
                .then().statusCode(200).log().status().log().body();
    }

    public static void postRequest(String headerName, String headerValue, String hostUrl, JsonObject jsonBody) {
        given()
                .contentType(ContentType.JSON)
                .body(jsonBody)
                .header(headerName, headerValue)
                .log().all()
                .when().post(hostUrl)
                .then().statusCode(200).log().status().log().body();
    }

}

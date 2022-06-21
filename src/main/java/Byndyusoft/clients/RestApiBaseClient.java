package Byndyusoft.clients;


import com.google.gson.JsonObject;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;

import static io.restassured.RestAssured.given;

public class RestApiBaseClient {

    public static Response getRequest(String headerName, String headerValue, String hostUrl) {
        given()
                .header(headerName, headerValue)
                .when().get(hostUrl)
                .then().log().status().log().body();

        return (Response) given().header(headerName, headerValue).when().get(hostUrl).then().log().status();
    }

    public static Response postRequestWithJsonBody(String headerName, String headerValue, String hostUrl,
                                                   JsonObject jsonBody) {
        given()
                .contentType(ContentType.JSON)
                .body(jsonBody)
                .header(headerName, headerValue)
                .log().all()
                .when().post(hostUrl)
                .then().log().status().log().body();

        return (Response) given().header(headerName, headerValue).when().get(hostUrl).then().log().status();
    }

    public static Response postRequestWithFile(String headerName, String headerValue, String hostUrl, String filePath) {
        given()
                .contentType(ContentType.MULTIPART)
                .multiPart("file", new File(filePath))
                .body(filePath)
                .header(headerName, headerValue)
                .log().all()
                .when().post(hostUrl)
                .then().log().body().log().status();

        return given().header(headerName, headerValue).when().get(hostUrl).then().extract().response();
    }

}

package rest;

import Byndyusoft.clients.MongoDBBaseClient;
import Byndyusoft.clients.RestApiBaseClient;
import Byndyusoft.configs.Property;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class test {


    @Test
    public void getTest() throws IOException {
        String bearerToken = new Property().getProperty("bearerToken");
        String headerName = "Authorization";
        String headerValue = "Bearer "+ bearerToken;
        String host = "https://gorest.co.in/public-api/users/";
        String userId = "5965";
        String hostUrl = host + userId;

        RestApiBaseClient.getRequest(headerName,headerValue,hostUrl);

    }

    @Test
    public void postTest() throws IOException {
        String bearerToken = new Property().getProperty("bearerToken");
        String headerName = "Authorization";
        String headerValue = "Bearer "+ bearerToken;
        String hostUrl = "https://gorest.co.in/public-api/users/";

        JsonObject jsonBody = new JsonObject();

        jsonBody.addProperty("name", "nameBlade");
        jsonBody.addProperty("gender", "Male");
        jsonBody.addProperty("email", "nameBlade@blade.com");
        jsonBody.addProperty("status", "active");

        RestApiBaseClient.postRequest(headerName,headerValue,hostUrl,jsonBody);
        //Assert.assertEquals();

    }

    @Test
    public void mongoFindTest() throws IOException, InterruptedException {
        String var = MongoDBBaseClient.find("collectionName", "varKey", "varValue");
        System.out.println(var);
    }

}






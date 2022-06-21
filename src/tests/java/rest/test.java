package rest;

import Byndyusoft.clients.MongoDBBaseClient;
import Byndyusoft.clients.PostgreSqlBaseClient;
import Byndyusoft.clients.RabbitMQBaseClient;
import Byndyusoft.clients.RestApiBaseClient;
import Byndyusoft.configs.Property;
import Byndyusoft.enums.SQLStatements;
import com.google.gson.JsonObject;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeoutException;


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

        RestApiBaseClient.postRequestWithJsonBody(headerName,headerValue,hostUrl,jsonBody);
        //Assert.assertEquals();

    }

    @Test
    public void mongoFindTest() throws IOException, InterruptedException {
        String var = MongoDBBaseClient.find("collectionName", "varKey", "varValue");
        System.out.println(var);
    }

    @Test
    public void postgreSqlSelect() throws SQLException, IOException {
        String query = SQLStatements.selectAllFromDB.getValue();
        String s = PostgreSqlBaseClient.selectFromPostgre(query);

        System.out.println(s);
    }

    @Test
    public void postWithFile() {
        String hostUrl = "";
        String headerName = "";
        String headerValue = "";
        String filePath= "";

        Response response = RestApiBaseClient.postRequestWithFile(headerName,headerValue,hostUrl,filePath);
        Assert.assertEquals(response, "200");
    }

    @Test
    public void rabbitPublish() throws IOException, TimeoutException {
        String hostName = "";
        Integer port = 0;
        String userName = "";
        String userPassword = "";
        String queueName = "";
        String message = "";
        RabbitMQBaseClient.publishMessage(hostName, port, userName, userPassword, queueName, message);
    }

}






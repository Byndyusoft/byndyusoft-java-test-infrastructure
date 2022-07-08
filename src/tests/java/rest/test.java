package rest;

import Byndyusoft.clients.MongoDBBaseClient;
import Byndyusoft.clients.PostgreSqlBaseClient;
import Byndyusoft.clients.RabbitMQBaseClient;
import Byndyusoft.clients.RestApiBaseClient;
import Byndyusoft.enums.SQLStatements;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.message.BasicHeader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.concurrent.TimeoutException;


public class test {

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
    public void rabbitPublish() throws IOException, TimeoutException {
        String hostName = "";
        Integer port = 0;
        String userName = "";
        String userPassword = "";
        String queueName = "";
        String message = "";
        RabbitMQBaseClient.publishMessage(hostName, port, userName, userPassword, queueName, message);
    }

    @Test
    public void getWithParams() throws IOException {
        String uri = "https://backoffice-entity-repository-test-supchain-stage.apps.lmru.tech/emailNotificationGroups";
        Header[] header = {
                new BasicHeader("accept", "*/*")
        };

        CloseableHttpResponse response = RestApiBaseClient.getWithParams(uri, header);

        System.out.println(response);

        Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);
    }

    @Test
    public void getWithParamsAuth() throws IOException {
        String uri = "https://backoffice-gui-test-supchain-stage.apps.lmru.tech/api/reports/cdf";
        Header[] header = {
                new BasicHeader("accept", "*/*"),
                new BasicHeader("id-token", "eyJhbGciOiJSUzI1NiIsImtpZCI6Ijg4RkNCNEY2OEIyNEZEMDZDNkNFQTI1NTI0RTIyQ0MzMkM3ODQwNDYiLCJ0eXAiOiJKV1QiLCJ4NXQiOiJpUHkwOW9za19RYkd6cUpWSk9Jc3d5eDRRRVkifQ.eyJuYmYiOjE2NTY1MDIwMjQsImV4cCI6MTY1NjUwMjMyNCwiaXNzIjoiaHR0cHM6Ly90LWxlZ29hdXRoLWFzMDIuaHEucnUuY29ycC5sZXJveW1lcmxpbi5jb20iLCJhdWQiOiJsbS1icG1zLXZlZC1leHQiLCJpYXQiOjE2NTY1MDIwMjQsImF0X2hhc2giOiJnWVVUNEJBa3dyZ0YzUEtKRFA4MUtBIiwic3ViIjoiOTY3IiwiYXV0aF90aW1lIjoxNjU2NTAxNTcxLCJpZHAiOiJsb2NhbCIsInRpdGxlIjoiVHJhbnNwb3J0IEdyb3VwIFNwZWNpYWxpc3QiLCJ2ZWRfbW9kZSI6IlRyYWRlIiwidmVkX29yZ2FuaXphdGlvbklkIjoiNjA2MWRiNzQ1MDYxZTIzZTE0NTEwMjllIiwidmVkX3JvbGUiOiJUcmFuc3BvcnRHcm91cFNwZWNpYWxpc3QiLCJmdWxsX25hbWUiOiJ0ZXN0LnRyYW5zcG9ydGdyb3Vwc3BlY2lhbGlzdCIsIm5hbWUiOiJ0ZXN0LnRyYW5zcG9ydGdyb3Vwc3BlY2lhbGlzdCIsImVtYWlsIjoidGVzdC50cmFuc3BvcnRncm91cHNwZWNpYWxpc3RAbGVyb3ltZXJsaW4ucnUiLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwiYW1yIjpbInB3ZCJdfQ.xsJpLoRveS7cSAvcG_37k51OlSEvb0O4iPNQIkVNCm0lIi_c66WoIX8-8x4OBtMtRD3UnGCrhdP414pWiWQSOnhoCf9HytVpezSMnW4d9A4IG7aGqseUK5vk2csuMXPNojqMZ_sKJXLxSqcVAUrgpXub1bhpZIpJgotBnRB2ED1jkiz1Ib8UlqunxMwDg1N5_bVNuIGXE8rO0om_CYa4MbkGjJt1ysVQEjxyPPSmSVHl-__Kf3COVH9mpetlgqxQe7DqFXykMkUQ59F8HJkk7uLpwjy-GSg0gMNH0kqlJTCz9QZ_zQTnrubM0c8Xj44Qv43J51bV6CWA3JbM-fCx5w")
        };

        CloseableHttpResponse response = RestApiBaseClient.getWithParams(uri, header);

        InputStream inputStream =  response.getEntity().getContent();
        String filePath = "src/main/resources/files/LI123.xlsx";
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        int inByte;
        while((inByte = inputStream.read()) != -1)
            fileOutputStream.write(inByte);
        inputStream.close();
        fileOutputStream.close();

        System.out.println(response);

        Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);
    }

    @Test
    public void postWithParams() throws IOException {
        String json = "src/main/resources/json/body1.json";
        StringEntity entity = new StringEntity(json);
        CloseableHttpResponse code = RestApiBaseClient.postWithParamsA("https://backoffice-entity-repository-test-supchain-stage.apps.lmru.tech/orders/byOcNumbers",
                "application/json",
                entity);
        System.out.println(code);
    }

    @Test
    public void postWithParamsA() throws IOException {
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.addBinaryBody(
                "file", new File("src/main/resources/files/LI.xlsx"), ContentType.APPLICATION_OCTET_STREAM, "LI.xlsx");

        HttpEntity multipart = builder.build();

        CloseableHttpResponse code = RestApiBaseClient.postWithParamsA("https://backoffice-gui-test-supchain-stage.apps.lmru.tech/api/reports/cdf",
                "multipart/form-data",
                multipart);
        System.out.println(code);
    }

}






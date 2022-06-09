package Byndyusoft.clients;


import Byndyusoft.configs.Property;
import com.mongodb.BasicDBObject;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.io.IOException;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static java.lang.Thread.sleep;

public class MongoDBBaseClient {

    private static final int mongoSleep = 1000;

    public MongoClient createConnect() throws IOException {
        ConnectionString connectionString = new ConnectionString(new Property().getProperty("mongoDB.connectionString"));
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .retryWrites(true)
                .retryReads(true)
                .build();
        return MongoClients.create(settings);
    }

    public String find(String collectionName, String varKey, String varValue) throws IOException, InterruptedException {
        MongoDatabase database = this.createConnect().getDatabase(new Property().getProperty("mongoDB.database"));
        MongoCollection<Document> collection = database.getCollection(collectionName);
        BasicDBObject query = new BasicDBObject(varKey, varValue);
        String fieldValue = null;
        for (int i=0;i<5;i++) {
            if(!Objects.isNull(collection.find(query).first())) {
                Document document = collection.find(query).first();
                fieldValue=document.get(varKey).toString();
                System.out.println(""+varKey+" = "+fieldValue);
                break;
            }
            sleep(mongoSleep);
        }
        return fieldValue;
    }

}

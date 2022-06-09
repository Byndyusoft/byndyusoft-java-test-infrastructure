package Byndyusoft.configs;

import java.io.*;
import java.util.Properties;


public class Property {

    private static final String environment = "develop";
    private static final String appPropPath = environment + ".properties";

    private static Properties appProps;

    private static void ReadProperty() throws IOException {
        appProps = new Properties();
        File property = new File("src/main/resources/properties/" + appPropPath);
        FileReader fr = new FileReader(property);
        appProps.load(fr);
    }

    public String getProperty(String propertyName) throws IOException {
        ReadProperty();
        String property = appProps.getProperty(propertyName);

        return property;
    }

}

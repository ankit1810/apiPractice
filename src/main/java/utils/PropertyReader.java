package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    public static Properties properties = new Properties();
    public static final String path=System.getProperty("user.dir")+"/src/main/resources/config.properties";
    public static String getValue(String key) throws IOException {
        FileInputStream fis= new FileInputStream(path);
        properties.load(fis);
        return properties.getProperty(key);
    }

}

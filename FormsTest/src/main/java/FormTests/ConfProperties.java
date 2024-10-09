package FormTests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfProperties {
    private static Properties PROPERTIES = new Properties();

    static {
        try (FileInputStream fileInputStream = new FileInputStream("src/main/resources/conf.properties")) {
            PROPERTIES.load(fileInputStream);
        } catch (IOException e) {
            System.out.println("Error loading properties file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        String value = PROPERTIES.getProperty(key);
        if (value == null) {
            System.out.println("Property not found for key: " + key);
        }
        return value;
    }
}

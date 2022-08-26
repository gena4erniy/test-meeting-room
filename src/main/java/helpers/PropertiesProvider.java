package helpers;

import java.io.IOException;

public class PropertiesProvider {

    public static String provideProperty(String property) {
        try {
            System.getProperties().load(ClassLoader.getSystemResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return System.getProperty(property);
    }
}

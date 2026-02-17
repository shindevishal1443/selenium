package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigClass {
	private static Properties prop;

    public static Properties initProperties() {
        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream("./src/test/resources/Configuration.properties");
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    public static String get(String key) {
        return prop.getProperty(key);
    }
}

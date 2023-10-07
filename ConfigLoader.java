import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {

    public static Properties loadProperties(String configFile) throws IOException {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream(configFile)) {
            properties.load(input);
        }
        return properties;
    }

    public static void main(String[] args) {
        String configFile = "config.properties"; // Specify the path to your properties file

        try {
            Properties properties = loadProperties(configFile);

            // Access the properties
            String path1 = properties.getProperty("Path1");
            String path2 = properties.getProperty("Path2");

            // Use the paths as needed in your batch job
            System.out.println("Path1: " + path1);
            System.out.println("Path2: " + path2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
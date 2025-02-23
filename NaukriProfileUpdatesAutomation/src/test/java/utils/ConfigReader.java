package utils;

	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Properties;

	public class ConfigReader {
	    private static Properties prop;

	    // Load properties file
	    static {
	        try {
	            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/testData/data.properties");
	            prop = new Properties();
	            prop.load(fis);
	        } catch (IOException e) {
	            System.out.println("⚠️ Failed to load properties file: " + e.getMessage());
	        }
	    }

	    // Get property value
	    public static String getProperty(String key) {
	        return prop.getProperty(key);
	    }
	}

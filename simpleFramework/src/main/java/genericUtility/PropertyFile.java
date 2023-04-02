package genericUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFile {

	public String getPropertyKeyValue(String key) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String value = pro.getProperty(key);
		return value;
	}

}

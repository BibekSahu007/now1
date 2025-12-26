package crm_Generic_FileUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	public String getPropertyFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./ConfigAppData/Common_Data.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String data = prop.getProperty(key);
		return data;
	}
}

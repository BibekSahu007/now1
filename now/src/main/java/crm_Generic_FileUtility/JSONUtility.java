package crm_Generic_FileUtility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONUtility {
	public String getJsonfile(String key) throws IOException, ParseException {
		FileReader jr= new FileReader("./ConfigAppData/commonjsonData.json");
		JSONParser parser= new JSONParser();
		Object ob=parser.parse(jr);
		JSONObject map = (JSONObject) ob;
		 String data = (String)map.get(key);
		return data;
	}
}
